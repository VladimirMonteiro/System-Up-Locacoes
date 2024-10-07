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
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String number;
    private String complement;
    private String cep;
    private String neighborhood;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany(mappedBy = "addresses")
    private Set<Client> clients = new HashSet<>();
}
