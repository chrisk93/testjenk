package com.example.valid.myapplication.polimorf;

public class Futbolista extends SeleccionFutbol{

    private int dorsal;
    private String demarcacion;



    public Futbolista(int id, String nombres, String apellidos, int dorsal, String demarcacion) {

        super(id, nombres, apellidos);

        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    @Override
    public void entrenamiento() {
        System.out.println("El futbolista realiza un entrenamiento en la cancha clase FutbolistaEnum con el dorsal Nro " + dorsal + "y la demarcacion " + demarcacion);
    }

    @Override
    public void partidoFutbol() {
        super.partidoFutbol();
        //System.out.println("en el partido de futbol el futbolista juega");
    }


    public void entrevista(){
        System.out.println("da entrevistas");
    }
}
