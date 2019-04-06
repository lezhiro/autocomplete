package com.rim.autocomplete.model;

public class Buscador {

    public Buscador() {

    }

    private String value ="";

    private Integer data =0;



    public String getValue(String string) {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
