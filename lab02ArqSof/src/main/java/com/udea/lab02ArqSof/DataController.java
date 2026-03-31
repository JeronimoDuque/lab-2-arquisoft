package com.udea.lab02ArqSof;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@RestController
public class DataController {

    @GetMapping("/")
    public String healthCheck() {
        return "health check ok";
    }

    @GetMapping("/version")
    public String version() {
        return "the actual Version 1.0.0";
    }

    @GetMapping("/nations")
    public JsonNode getRandomNations() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker();
        var nations = objectMapper.createArrayNode();
        for (var i = 0; i < 10 ; i++) { 
            var nation = faker.nation();
            nations.add(objectMapper.createObjectNode()
            .put("nationality",nation.nationality())
            .put("capitalCity",nation.capitalCity())
            .put("bandera", nation.flag())
            .put("language",nation.language())
        ); 
        
        }
    return nations;
    }

    @GetMapping("/currencies")
    public JsonNode getRandomCurrencies() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker();
        var currencies = objectMapper.createArrayNode();
        for (var i = 0; i < 10 ; i++) { 
            var currency = faker.currency();
            currencies.add(objectMapper.createObjectNode()
            .put("name",currency.name())
            .put("code",currency.code())
        ); 
        
        }
    return currencies;
    }

    @GetMapping("/aviation")
    public JsonNode getRandomAviation() {
        var objectMapper = new ObjectMapper();
        var faker = new Faker();
        var aviations = objectMapper.createArrayNode();
        for (var i = 0; i < 10 ; i++) { 
            var aviation = faker.aviation();
            aviations.add(objectMapper.createObjectNode()
            .put("aircraft",aviation.aircraft())
            .put("airport",aviation.airport())
            .put("METAR", aviation.METAR())); 
        
        }
    return aviations;
    }
}
