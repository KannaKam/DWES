package com.olgibaba.restaurant.buisness.services;

import com.olgibaba.restaurant.buisness.entities.Admin;
import com.olgibaba.restaurant.buisness.entities.UserRestaurant;
import com.olgibaba.restaurant.payload.jsonWebToken.JWToken;
import com.olgibaba.restaurant.payload.request.AdminLoginRequest;
import com.olgibaba.restaurant.payload.response.ResponseMessages;
import com.olgibaba.restaurant.persistence.AdminRepository;
import com.olgibaba.restaurant.persistence.UserRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserRestaurantRepository userRestaurantRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    JWToken jwToken;


    @Override
    public ResponseEntity<?> signIn(AdminLoginRequest admin) {

        if(!adminRepository.existsByMail(admin.getMail())){
            return ResponseEntity.badRequest().body(new ResponseMessages(400, "Error", "Current email does not exist."));
        }

        Optional<Admin> adminOptional = adminRepository.findAdminByMail(admin.getMail());

        if (adminOptional.isPresent()){
            if(!admin.getPassword().equals(adminOptional.get().getPassword())){
                return ResponseEntity.badRequest().body(new ResponseMessages(400, "Error", "Wrong credentials."));
            }
        }
        
        return ResponseEntity.ok(jwToken.generateToken(admin.getMail()));
    }

    @Override
    public ResponseEntity<?> signIn(UserRestaurant userRestaurant) {
        return null;
    }
}
