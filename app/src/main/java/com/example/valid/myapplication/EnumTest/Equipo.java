package com.example.valid.myapplication.EnumTest;

public enum Equipo {
    MILLOS("ZOLO MILLOZ LOK",1),
    NAC_NAL("LDS",2);

    private String descr;
    private int posicion;

    Equipo(String descr, int posicion) {
        this.descr = descr;
        this.posicion = posicion;
    }

    public String getDescr(){
        return descr;
    }

    public int getPos(){
        return posicion;
    }
}
