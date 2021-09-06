package com.cognizant.project.service;

import com.cognizant.project.model.RequestTicket;

import java.util.List;

public interface RequestTicketService {
    RequestTicket saveTicket(RequestTicket ticket);
    List<RequestTicket> findAll(int days);
}
