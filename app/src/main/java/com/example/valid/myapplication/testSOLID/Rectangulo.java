package com.example.valid.myapplication.testSOLID;

public class Rectangulo implements Shape {

    private double ancho;
    private double alto;


    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }


    @Override
    public double getArea() {
        return (ancho * alto);
    }

    @Override
    public String tipoFigura() {
        return "rectangulo";
    }
}
