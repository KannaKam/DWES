package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.buisness.entities.UserRestaurant;
import com.olgibaba.restaurant.payload.request.AdminLoginRequest;
import org.springframework.http.ResponseEntity;


public interface AccountService {

    ResponseEntity<?> signIn(AdminLoginRequest admin);
    ResponseEntity<?> signIn(UserRestaurant userRestaurant);


}
