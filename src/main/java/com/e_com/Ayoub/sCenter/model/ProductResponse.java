package com.e_com.Ayoub.sCenter.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id ;

    private String name;

    private String description ;

    private double price ;

    private String pictureUrl;

    private String book ;

    private String category ;

}
