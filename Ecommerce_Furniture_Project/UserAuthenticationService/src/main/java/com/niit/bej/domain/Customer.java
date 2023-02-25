/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    @Id
    private String emailId;
    private String password;
}
