package com.infosys.learning.dto;

public class PersonResponse extends Person{
    private Data data;

    public PersonResponse() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
