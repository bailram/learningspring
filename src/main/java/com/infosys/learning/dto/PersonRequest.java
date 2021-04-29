package com.infosys.learning.dto;

public class PersonRequest extends Person{
    private int yearofBirth;

    public PersonRequest() {
    }

    public int getYearofBirth() {
        return yearofBirth;
    }

    public void setYearofBirth(int yearofBirth) {
        this.yearofBirth = yearofBirth;
    }
}
