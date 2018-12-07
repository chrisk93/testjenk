package com.example.valid.myapplication.polimorf;

public abstract class SeleccionFutbol {

    protected int id;
    protected String nombres;
    protected String apellidos;

    public SeleccionFutbol(int id, String nombres, String apellidos){
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public void viajar(){
        System.out.println("Viajar clase padre");

    }

    public void concentrarse(){
        System.out.println("Concentrarsse clase padre");
    }

    public void partidoFutbol(){
        System.out.println("Asiste partido clase padre " + nombres);
    }

    public abstract void entrenamiento();
}
