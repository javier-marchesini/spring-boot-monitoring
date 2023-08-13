package com.demo.prometheus.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;
    private Integer stock;
}
