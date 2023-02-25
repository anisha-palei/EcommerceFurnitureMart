/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Furniture Not Found")
public class FurnitureNotFoundException extends Exception{
}
