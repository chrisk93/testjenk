package com.example.valid.myapplication.testSOLID;

import android.util.Log;

import java.util.ArrayList;

public class Area {

    private static final String TAG = Area.class.getSimpleName();


    public Area() {

        //ArrayList<Shape> shapes1 = new ArrayList<>();
        //shapes1.add(new Rectangulo(12,12));
        //shapes1.add(new Circulo(24));

    }

    public double calculaArea(ArrayList<Shape> shapes1){

        double area = 0;

        for (Shape shape: shapes1){

            area += shape.getArea();
        }
        return area;
    }

    public ArrayList<String> obtieneAreas(ArrayList<Shape> shapes1){

        ArrayList<String> datos = new ArrayList<>();
        for(Shape shape: shapes1){

            datos.add(shape.tipoFigura() + " su area es de: " + shape.getArea());
        }

        return datos;
    }
}
