package com.example.valid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.valid.myapplication.EnumTest.Demarcacion;
import com.example.valid.myapplication.EnumTest.Equipo;
import com.example.valid.myapplication.EnumTest.FutbolistaEnum;
import com.example.valid.myapplication.herenc.Gato;
import com.example.valid.myapplication.polimorf.Futbolista;
import com.example.valid.myapplication.polimorf.SeleccionFutbol;
import com.example.valid.myapplication.testSOLID.CalculaAreas;
import com.example.valid.myapplication.testSOLID.Circulo;
import com.example.valid.myapplication.testSOLID.Rectangulo;
import com.example.valid.myapplication.testSOLID.Shape;
import com.example.valid.myapplication.testVolley.MiPeticion;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text) TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        enums();

    }

    public void muestraDatos(){

        ArrayList<Shape> shapes1 = new ArrayList<>();
        shapes1.add(new Rectangulo(12,12));
        shapes1.add(new Circulo(24));

        CalculaAreas calculaAreas = new CalculaAreas();

        StringBuilder stringBuilder = new StringBuilder();

        for(String data: calculaAreas.obtieneAreas(shapes1)){

            stringBuilder.append(data + "\n");

        }

        String areaFiguras = stringBuilder.toString();

        text.setText(areaFiguras);
    }

    public void muestraData(){
        SeleccionFutbol futbolista = new Futbolista(1,"wilder","medina",12,"nose");
        futbolista.partidoFutbol();
        futbolista.entrenamiento();
        ((Futbolista) futbolista).entrevista();
    }

    public void sada(){
        Gato gato = new Gato();
        gato.miNombre("asdas");
        gato.nose();
    }

    public void enums(){
        FutbolistaEnum casillas = new FutbolistaEnum("cosillas",15,Demarcacion.PORTERO,Equipo.MILLOS);

        System.out.println(casillas.toString());

    }

    @OnClick(R.id.btnrealizaPeticion)
    public void realizaPeticion(){
        MiPeticion.realizaPeticionGETRX();
    }
}
