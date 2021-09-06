package com.cognizant.project.repository;

import com.cognizant.project.model.RequestTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestTicketRepository extends JpaRepository<RequestTicket, Long> {
    @Query(value = "SELECT r FROM RequestTicket r WHERE r.date > DATEADD(DAY, -:days, CURRENT_DATE)")
    List<RequestTicket> findAll(@Param(value = "days") int days);
}
