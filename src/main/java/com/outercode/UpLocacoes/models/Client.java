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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String cpfOrCnpj;

    @OneToMany(mappedBy = "client")
    private Set<Phone> phones = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Rent> rents = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Contract> contracts = new HashSet<>();


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "client_address",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Set<Address> addresses = new HashSet<>();
}
