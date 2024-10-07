package com.outercode.UpLocacoes.models;


import com.outercode.UpLocacoes.models.enums.StateContract;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer stateContract;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "contract")
    private Rent rent;


    public Contract(Integer id, StateContract stateContract) {
        this.id = id;
        this.stateContract = stateContract.getCode();
    }
}
