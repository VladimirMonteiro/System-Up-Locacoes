package com.outercode.UpLocacoes.models;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class RentItemPK {

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;
}
