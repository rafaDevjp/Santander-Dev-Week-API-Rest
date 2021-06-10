package com.santander.apisantander.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

@Entity
@Table(name = "tb_stock")
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price")
    private Double price;

    @Column(name = "variation")
    private Double variation;
}
