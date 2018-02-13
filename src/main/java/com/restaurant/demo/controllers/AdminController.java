package com.restaurant.demo.controllers;

import com.restaurant.demo.services.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "This is my Admin Controller ")
@RestController
@RequestMapping(AdminController.BASE_URL)
public class AdminController {


    public static final String BASE_URL = "/admin";
    private final AdminService adminService;

    public AdminController(AdminService adminService)
    {this.adminService=adminService;}



    @ApiOperation(value = "Delete a Guest")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteGuestById(@PathVariable Long id){adminService.deleteGuestById(id);

    }
}


