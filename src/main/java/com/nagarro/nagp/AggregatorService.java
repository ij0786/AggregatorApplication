package com.nagarro.nagp;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AggregatorService {

    @Autowired
    private RestTemplate template;
    
    @GetMapping("/orderdetails/1")
    public JSONObject getName() {
      
    	JSONObject orderString = template.getForObject("http://localhost:8090/orders/1",
        		JSONObject.class);

    	JSONObject userString = template.getForObject("http://localhost:8098/user/1",
        		JSONObject.class);
        
        JSONObject obj = new JSONObject();
        obj.put("userDetails", userString );
        obj.put("orders", orderString);
        
        return obj;
    }

}
