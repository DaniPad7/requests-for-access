package com.cognizant.project.service;

import com.cognizant.project.model.RequestTicket;
import com.cognizant.project.repository.RequestTicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RequestTicketServiceImpl implements RequestTicketService {
    private final RequestTicketRepository ticketRepository;
    @Override
    public RequestTicket saveTicket(RequestTicket ticket) {
        log.info("Saving new ticket {} to the database", ticket);
        ticket.getStatusOption().setStatus("PENDING");
        return ticketRepository.save(ticket);
    }

    @Override
    public List<RequestTicket> findAll(int days) {
        return ticketRepository.findAll(days);
    }
}
