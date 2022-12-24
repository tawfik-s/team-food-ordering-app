package com.fawry.foodorderingapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class ExceptionResponse {

   private String message;

   @JsonFormat(shape = JsonFormat.Shape.ANY)
   private Date date;

   public ExceptionResponse(String message, String date) {
      this.message = message;
      this.date = new Date();
   }
}
