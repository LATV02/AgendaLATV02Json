package com.example.agendalatv02json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAgregar(View v){
        Intent agrega=new Intent(this,Agregar.class);
        startActivity(agrega);
        finish();
    }

    public void irMostrar(View v){
        Intent mostrar=new Intent(this,Listar.class);
        startActivity(mostrar);
        finish();
    }
}
