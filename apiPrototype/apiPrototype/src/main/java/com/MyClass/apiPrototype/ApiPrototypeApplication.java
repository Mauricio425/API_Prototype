package com.MyClass.apiPrototype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiPrototypeApplication {
    
    /*
        Mauricio Garcia-Paez
        2/4/2024
        CSC 340-02
    
        This program sends a get request to an API which returns information on
        a random emoji.
    */

	public static void main(String[] args) {
		SpringApplication.run(ApiPrototypeApplication.class, args);
                randomEmoji();
	}
        
        //Get random dog fact and print
    public static void randomEmoji() {

        try {            
            String url = "https://emojihub.yurace.pro/api/random";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            
            String emojiData = restTemplate.getForObject(url,String.class);
            JsonNode root = mapper.readTree(emojiData);
            
            String name = root.findValue("name").asText();
            String category = root.findValue("category").asText();
            String unicode = root.findValue("unicode").toString();
            
            System.out.println("---------------------------------------------"
                    + "----------------------------");
            System.out.println("Emoji information: ");
            System.out.println("Name: " + name);
            System.out.println("Category: " + category);
            System.out.println("unicode id: " + unicode);

        } catch (JsonProcessingException ex) {
            System.out.println("error in randomEmoji");

        }

    }

}
