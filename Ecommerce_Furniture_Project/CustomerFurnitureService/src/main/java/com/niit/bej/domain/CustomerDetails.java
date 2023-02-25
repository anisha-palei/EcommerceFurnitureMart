/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
public class CustomerDetails {
    @Id
    String emailId;
    int age;
    String password;
    String customerName;

    String mobileNo;

    private List<Furniture> furnitureList;




}
