package com.way.selltickets;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public String getTicket(){
        return "you will have a ticket";
    }
}
