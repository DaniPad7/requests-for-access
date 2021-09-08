package com.cognizant.project.controller;

import com.cognizant.project.model.AppUser;
import com.cognizant.project.model.RequestTicket;
import com.cognizant.project.model.UserAuthentication;
import com.cognizant.project.service.RequestTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/ticket")
@RequiredArgsConstructor
public class RequestTicketController {
    private final RequestTicketService ticketService;

    @PostMapping(value = "/create")
    public ResponseEntity<RequestTicket> saveTicket(@RequestBody RequestTicket ticket) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/ticket/create").toUriString());
        return ResponseEntity.created(uri).body(ticketService.saveTicket(ticket));
    }

    @GetMapping(value = "/retrieve/all/{days}")
    public ResponseEntity<List<RequestTicket>> findAll(@PathVariable int days) {
        return ResponseEntity.ok().body(ticketService.findAll(days));

    }


}
