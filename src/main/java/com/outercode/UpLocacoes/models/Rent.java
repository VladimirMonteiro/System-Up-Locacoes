package com.outercode.UpLocacoes.models;

import com.outercode.UpLocacoes.models.enums.StateRent;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double price;
    private Date initialDate;
    private Date deliveryDate;
    private Integer stateRent;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @OneToMany(mappedBy = "id.rent")
    private Set<RentItem> rentItems = new HashSet<>();

    public Rent(Integer id, Client client, double price, Date initialDate, Date deliveryDate, StateRent stateRent) {
        this.id = id;
        this.price = price;
        this.initialDate = initialDate;
        this.deliveryDate = deliveryDate;
        this.client = client;
        this.stateRent = stateRent.getCode();
    }
}
