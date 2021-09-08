package com.cognizant.project.service;

import com.cognizant.project.model.RequestTicket;
import com.cognizant.project.model.Role;
import com.cognizant.project.model.StatusOption;
import com.cognizant.project.model.UserAuthentication;
import com.cognizant.project.repository.RequestTicketRepository;
import com.cognizant.project.repository.RoleRepository;
import com.cognizant.project.repository.UserAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService{
    private final RequestTicketRepository requestTicketRepository;
    @Override
    public RequestTicket appendRoleToUser(RequestTicket req) {
        log.info("Appending role {} to user {}", req.getPrivileges());
        StatusOption st = req.getStatusOption();
        if (st.getStatusId() == 2) {
            req.getStatusOption().setStatus("APPROVED");
            RequestTicket rq = requestTicketRepository.save(req);
            return rq;
        } else if (st.getStatusId() == 3) {
            req.getStatusOption().setStatus("REJECTED");
            RequestTicket rq = requestTicketRepository.save(req);
            return rq;
        }
        else return null;
    }
}
