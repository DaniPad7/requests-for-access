package com.cognizant.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketId;
    @ManyToOne(fetch = FetchType.EAGER)
    private AppUser appUserId;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private JustificationOption businessJustification;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private StatusOption statusOption;
    private LocalDate date;
}
