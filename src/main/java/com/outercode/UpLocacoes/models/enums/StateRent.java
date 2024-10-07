package com.outercode.UpLocacoes.models.enums;

public enum StateRent {

    RENTED(1),
    DELIVERED(2);

    private int code;

    private StateRent(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static StateRent valueOf(int code){
        for(StateRent value: StateRent.values()){
            if(value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid rent status code");

    }

}
