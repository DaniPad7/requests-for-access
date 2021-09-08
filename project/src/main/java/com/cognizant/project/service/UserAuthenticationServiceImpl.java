package com.cognizant.project.service;

import com.cognizant.project.model.AppUser;
import com.cognizant.project.model.RequestTicket;
import com.cognizant.project.model.Role;
import com.cognizant.project.model.UserAuthentication;
import com.cognizant.project.repository.AppUserRepository;
import com.cognizant.project.repository.RequestTicketRepository;
import com.cognizant.project.repository.RoleRepository;
import com.cognizant.project.repository.UserAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserAuthenticationServiceImpl implements UserAuthenticationService, UserDetailsService {
    private final UserAuthenticationRepository userAuthenticationRepository;
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final RequestTicketRepository requestTicketRepository;

    @Override
    public UserAuthentication saveUser(UserAuthentication user) {
        log.info("Saving AppUser {} first.", user.getAppUserId());
        AppUser savedUser = appUserRepository.save(user.getAppUserId());
        log.info("Saving AppUser credentials now.");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAppUserId(savedUser);
        return userAuthenticationRepository.save(user);

    }

    @Override
    public UserAuthentication getUser(String username) {
        return userAuthenticationRepository.findByUsername(username);
    }

    @Override
    public AppUser getAppUser(String username) {
        AppUser temp = getUser(username).getAppUserId();
        log.info("Here is the appUser in service: {}", temp);
        return temp;
    }


    @Override
    public List<AppUser> getUsers() {
        return userAuthenticationRepository.findAll()
                .stream().map(user -> user.getAppUserId())
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthentication user = getUser(username);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database {}", username);
            Collection<RequestTicket> requestTickets = requestTicketRepository.findAllByAppUser(30, user.getAppUserId());
            if(!requestTickets.isEmpty()) {
                Collection<Role> existingRoles = user.getRoles();
                requestTickets.forEach(rt -> {
                    if(!existingRoles.contains(rt.getPrivileges()))
                        existingRoles.add(rt.getPrivileges());
                });
                user.setRoles(existingRoles);
                UserAuthentication newUser = userAuthenticationRepository.save(user);
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                newUser.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
                return new User(user.getUsername(), user.getPassword(), authorities);
            }else {
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
                return new User(user.getUsername(), user.getPassword(), authorities);
            }

        }
    }
}
