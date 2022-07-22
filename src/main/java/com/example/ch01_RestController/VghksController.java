package com.example.ch01_RestController;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/vghks/*")
@Validated
public class VghksController {
	@RequestMapping(value = "vip_check_in", method = {RequestMethod.POST, RequestMethod.GET})
    public String vipCheckIn(@RequestParam("identifier") String identifier) {
        
        if(identifier.isEmpty()){
            return "{\"result\":\"0001\",\"message\":\"identifier is not empty\"}";
        }
         return "{\"result\":\"0000\",\"message\":\"Ok\"}";
    }
}
