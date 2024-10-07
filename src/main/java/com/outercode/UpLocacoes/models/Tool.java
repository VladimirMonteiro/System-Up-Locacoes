package com.outercode.UpLocacoes.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int quantity;
    private double daily;
    private double week;
    private double priceMonth;

    @OneToMany(mappedBy = "id.tool")
    private Set<RentItem> rentItems = new HashSet<>();

    public Tool(Integer id, String name, int quantity, double daily, double week, double priceMonth) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.daily = daily;
        this.week = week;
        this.priceMonth = priceMonth;
    }
}
