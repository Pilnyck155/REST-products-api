package com.pilnyck.products.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Setter
@Builder
public class Product {
    private int id;
    private String name;
    private double price;
    private Date creationDate;
    //TODO: Change date type to TimeStamp or LocalDay/LocalDayTime
}
