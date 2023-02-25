/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Furniture {

    @Id
    private int furnitureId;

    private String furnitureName;

    private String furniturePrice;

    private String furnitureImage;
}
