package com.cognizant.project.service;

import com.cognizant.project.model.AppUser;
import com.cognizant.project.model.UserAuthentication;

import java.util.List;

public interface UserAuthenticationService {
    UserAuthentication saveUser(UserAuthentication user);
    //saveRole in Role Repo
    UserAuthentication getUser(String username);
    AppUser getAppUser(String username);
    List<AppUser> getUsers();
}
