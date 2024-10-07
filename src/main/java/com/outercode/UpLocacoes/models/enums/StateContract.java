package com.outercode.UpLocacoes.models.enums;

public enum StateContract {

    PAID(1),
    UNPAID(2);

    private int code;

    private StateContract(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static StateContract valueOf(int code){
        for(StateContract value: StateContract.values()){
            if(value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid status code");

    }
}
