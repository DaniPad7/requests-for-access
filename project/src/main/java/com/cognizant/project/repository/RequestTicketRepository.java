package com.cognizant.project.repository;

import com.cognizant.project.model.AppUser;
import com.cognizant.project.model.RequestTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestTicketRepository extends JpaRepository<RequestTicket, Long> {
    @Query(value = "SELECT r FROM RequestTicket r WHERE r.date > DATEADD(DAY, -:days, CURRENT_DATE)")
    List<RequestTicket> findAll(@Param(value = "days") int days);

    @Query(value = "SELECT r FROM RequestTicket r WHERE r.date > DATEADD(DAY, -:days, CURRENT_DATE) " +
            "AND r.appUserId = :user AND r.statusOption.status = 'APPROVED'")
    List<RequestTicket> findAllByAppUser(@Param(value = "days")int days, @Param(value = "user")AppUser user);
}
