/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.controller;

import com.niit.bej.domain.Furniture;
import com.niit.bej.domain.CustomerDetails;
import com.niit.bej.service.CustomerServiceImpl;
import com.niit.bej.service.FurnitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v2")
@CrossOrigin("http://localhost:4200")
public class CustomerController {

    @Autowired
    FurnitureServiceImpl furnitureService;

    @Autowired
    CustomerServiceImpl customerService;

    private ResponseEntity responseEntity;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CustomerDetails user)
    {
        try{customerService.saveUser(user);

            responseEntity=new ResponseEntity(user,HttpStatus.CREATED);

        }
        catch(Exception e)
        {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    @PostMapping("/user/add")
    public ResponseEntity<?> addProduct(@RequestBody Furniture furniture)  {
        try{
            furnitureService.addFurniture(furniture);
            responseEntity=new ResponseEntity(furniture,HttpStatus.CREATED);
        } catch (Exception e)
        {
            responseEntity=new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }



    @GetMapping("/user/getAllFurniture")
    public ResponseEntity<?> getAllProducts()
    {  try{
        responseEntity = new ResponseEntity(furnitureService.getAllFurniture(),HttpStatus.OK);
    }catch (Exception exception){
        responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
        return responseEntity;
    }

    @GetMapping("/product/user/{furnitureId}")
    public ResponseEntity<?> getId(@PathVariable int furnitureId)
    {
        try{
            responseEntity = new ResponseEntity(furnitureService.getFurnitureById(furnitureId), HttpStatus.OK);

        }catch (Exception exception){
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }

    @PostMapping("/user/addToCart/{emailId}")
    public ResponseEntity<?> addProductToCart(@PathVariable String emailId,@RequestBody Furniture furniture)  {
        try{
            CustomerDetails customerDetails=customerService.detailsByEmailId(emailId,furniture);
            responseEntity=new ResponseEntity(customerDetails,HttpStatus.CREATED);
        } catch (Exception e)
        {
            responseEntity=new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/user/furnitureCart/customer/{emailId}")
    public ResponseEntity<?> getByEmailId(@PathVariable String emailId) {

        CustomerDetails customerByEmailId = customerService.getCustomerByEmailId(emailId);

       return new ResponseEntity(customerByEmailId,HttpStatus.OK);

    }
    @GetMapping("/user/furnitureCart/{emailId}")
    public ResponseEntity<?> getProductsByEmailIDToCart(@PathVariable String emailId) {

        List<Furniture> furnitureList=customerService.getAllFurnitureToCart(emailId);
        return new ResponseEntity(furnitureList, HttpStatus.OK);

    }


}
