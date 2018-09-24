package com.way.buytickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/buy")
public class TicketController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ticket/{name}")
    public String buyTikcet(@PathVariable(value="name") String name) {
        String result = restTemplate.getForObject("http://SELLTICKETS/sell/ticket", String.class);
        return name + " has bought a " + result;
    }
}
