package com.example.valid.myapplication.testSOLID;

public class Circulo implements Shape{

    private double radio;
    private String tipoFigura;


    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return (radio * radio * Math.PI);
    }

    @Override
    public String tipoFigura() {
        return "circulo";
    }
}
