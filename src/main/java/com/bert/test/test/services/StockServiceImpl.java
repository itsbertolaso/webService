package com.bert.test.test.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bert.test.test.dto.UserDto;

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
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
}
