package com.bert.test.test.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.bert.test.test.dao.UserDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.bert.test.test.dto.UserDto;

import javax.sound.midi.SysexMessage;

@Service
@Transactional
public class StockServiceImpl implements StockService{

	@Autowired
	UserService userService;

	@Override
	public Map<String, Map> getStock(String token) throws MalformedURLException, IOException {
		String nome = userService.decodeJwt(token);
	    UserDto user = userService.getUser(nome);

	    System.out.println("Nome dto: " + user.getName());

	    Map<String, Object> config = user.getConfig();

	    System.out.println("STOCK: "+ config.get("stock").toString());

	    String stock = config.get("stock").toString();
	    String[] stockSplit = stock.split(",");

	    String api = "https://financialmodelingprep.com/api/v3/quote/";
	    for(String s : stockSplit){
	      s = s.replace("[", "");
	      if(s.contains("]")){
	        s = s.replace("]", "");
	        api += s;
	      } else{
	        api += s + ",";
	      }
	    }

	    api = api.replaceAll(" ", "");
	    System.out.println("Stringa di connessione: " + api);

	    InputStream is = new URL(api).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);

	      String[] splitted = jsonText.split("},");
	      Map<String, Map> test = new HashMap<>();

	      for(String s : splitted){
	        s = s.replace("[", "");
	        s = s.replace("]", "");
	        if(s.equals(" ")) s = "}";
	        s = s.replace("}", "");
	        s = s+="}";
	        JSONObject jj = new JSONObject(s);
	        test.put((String) jj.get("symbol"), jj.toMap());
	      }

	      return test;
	    } finally {
	      is.close();
	    }
	}

  @Override
  public void updateStock(Map<String, Object> stock, String token) {
    String nome = userService.decodeJwt(token);
    Optional<UserDao> user = userService.getUserDao(nome);
    if(user.isPresent()){
      UserDto dto = new UserDto();
      dto.setConfig(user.get().getConfig());
      Map<String, Object> config = dto.getConfig();
      config.replace("stock", stock.get("value"));
      user.get().setConfigStock(config);

      System.out.println("Nome: " + user.get().getName());
      System.out.println("Password: " + user.get().getPassword());
      System.out.println("Role: " + user.get().getRole());
      System.out.println("Config: " + user.get().getConfig());

      userService.updateUser(user.get());
    }
  }

	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  private Map<String, Map> formatting(String jsonText){
      String[] splitted = jsonText.split("},");
      Map<String, Map> test = new HashMap<>();

      for(String s : splitted){
        s = s.replace("[", "");
        s = s.replace("]", "");
        if(s.equals(" ")) s = "}";
        s = s.replace("}", "");
        s = s+="}";

        System.out.println("sssssssssss" + s);

        JSONObject jj = new JSONObject(s);
        test.put((String) jj.get("symbol"), jj.toMap());
      }

      return test;
    }

	@Override
	public Map<String, Map> getStock1(String token) {

		  String nome = userService.decodeJwt(token);
	    UserDto user = userService.getUser(nome);

	    Map<String, Object> config = user.getConfig();

	    String stock = config.get("stock").toString();
	    System.out.println("Stock: " + stock);
	    String[] stockSplit = stock.split(",");

	    System.out.println("StockSplit: " + Arrays.toString(stockSplit));

	    String api = "https://financialmodelingprep.com/api/v3/quote/";
	    for(String s : stockSplit){
	      s = s.replace("[", "");
	      if(s.contains("]")){
	        s = s.replace("]", "");
	        api += s;
	      } else{
	        api += s + ",";
	      }
	    }

	    System.out.println("STRINGA: " + api);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> responseEntity = restTemplate.exchange(api, HttpMethod.GET, request, String.class);

		responseEntity.getStatusCode();

		if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
		   System.out.println("BODY: " + responseEntity.getBody());
			 Map<String, Map> test = formatting(responseEntity.getBody());
			 return test;
		}
		else {
		  Map<String, Map> bad = new HashMap<>();
		  bad.put("bad request", bad);
			return bad;
		}
	}
}
