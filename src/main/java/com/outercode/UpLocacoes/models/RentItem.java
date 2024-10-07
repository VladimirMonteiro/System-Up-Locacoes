package com.outercode.UpLocacoes.models;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RentItem {

    @EmbeddedId
    private RentItemPK id = new RentItemPK();

    private double price;
    private int quantity;

    public RentItem( double price, int quantity, Rent rent, Tool tool) {
        id.setRent(rent);
        id.setTool(tool);
        this.price = price;
        this.quantity = quantity;
    }

    public Tool getTool(){
        return id.getTool();
    }

    public Rent getRent(){
        return id.getRent();
    }

}
