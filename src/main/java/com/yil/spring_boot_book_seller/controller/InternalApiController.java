package com.yil.spring_boot_book_seller.controller;

import com.yil.spring_boot_book_seller.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/internal")//pre-path
public class InternalApiController {

    @Autowired
    private IUserService userService;

    @PutMapping("make-admin/{username}") //api/internal/make-admin/{username}
    public ResponseEntity<?> makeAdmin(@PathVariable String username)
    {
        userService.makeAdmin(username);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}