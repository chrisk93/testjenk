package com.example.valid.myapplication.EnumTest;

public class FutbolistaEnum {

    private int dorsal;
    private String Nombre;
    private Demarcacion demarcacion;
    private Equipo equipo;

    public FutbolistaEnum() {
    }

    public FutbolistaEnum(String nombre, int dorsal, Demarcacion demarcacion, Equipo equipo) {
        this.dorsal = dorsal;
        Nombre = nombre;
        this.demarcacion = demarcacion;
        this.equipo = equipo;
    }



    @Override
    public String toString() {
        return this.dorsal + " - " + this.Nombre + " - "
                + this.demarcacion.name() + " - " + " posicion test " + this.equipo.getPos() + " descr -" + this.equipo.getDescr() + " number " + this.demarcacion.ordinal();
    }
}