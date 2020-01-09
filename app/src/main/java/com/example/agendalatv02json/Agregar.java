package com.example.agendalatv02json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Agregar extends AppCompatActivity {
    EditText txtnombre,txtcorreo,txtedad,txtcurp;
    TextView lblmostrar;

    private  final String nomarch="dateAngel.txt";
    private ArrayList<String> TextoCompleto= new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        txtnombre=findViewById(R.id.txtNombre);
        txtcorreo=findViewById(R.id.txtCorreo);
        txtedad=findViewById(R.id.txtEdad);
        txtcurp=findViewById(R.id.txtCurp);
        lblmostrar=findViewById(R.id.lblMostrar);
    }

    public void mgrabar(View v){
        manejoArchivoTXT controlador = new manejoArchivoTXT();
        String Texto1="";
        String Texto2="";
        String Texto3="";
        String Texto4="";
        try {
            Texto1=txtnombre.getText().toString();
            Texto2=txtcorreo.getText().toString();
            Texto3=txtedad.getText().toString();
            Texto4=txtcurp.getText().toString();
            controlador.agregar(Texto1,Texto2,Texto3,Texto4,TextoCompleto);
            TextoCompleto=controlador.getContenido();
            if(controlador.grabar(TextoCompleto,this,nomarch)){
                Toast.makeText(this,"Se grabo correctamente",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"no se grabo correctamente",Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mleer(View v){ cargarinfo();}

    private void cargarinfo(){
        manejoArchivoTXT objmanarch= new manejoArchivoTXT();
        if(objmanarch.verificar(this,nomarch)){
            Toast.makeText(this,"Existe el archivo...",Toast.LENGTH_LONG).show();

            if(objmanarch.leer(this,nomarch)){
                TextoCompleto= objmanarch.getContenido();
                String cadenita="";

                for(String micadena:TextoCompleto){
                    cadenita+=micadena;
                }
                lblmostrar.setText(cadenita);
            }
        }else{
            Toast.makeText(this,"no existe el archivo...",Toast.LENGTH_LONG).show();
        }
    }


    public void volvermenu(View v){
        Intent volver= new Intent(this,MainActivity.class);
        startActivity(volver);
        finish();
    }
}
