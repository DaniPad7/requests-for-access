package com.cognizant.project.controller;

import com.cognizant.project.model.RequestTicket;
import com.cognizant.project.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PutMapping(value = "/user")
    public ResponseEntity<RequestTicket> appendRoleToUser(@RequestBody RequestTicket req) {
        return ResponseEntity.ok().body(roleService.appendRoleToUser(req));
    }

}
