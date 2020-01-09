package com.example.agendalatv02json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class Listar extends AppCompatActivity {
    GridView gvdatos;
    ListArrayAdapter gridViewArrayAdapter;
    List<Product> productList;

    private  final String nomarch="dateAngel.txt";

    private ArrayList<String> TextoCompleto=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        gvdatos=findViewById(R.id.gvdatos);

        getProductList();

        gridViewArrayAdapter=new ListArrayAdapter(this,R.layout.elementos,productList);
        gvdatos.setAdapter(gridViewArrayAdapter);
    }

    public List<Product> getProductList(){
        productList=new ArrayList<>();
        manejoArchivoTXT infoNombre=new manejoArchivoTXT();

        if(infoNombre.leer(this,nomarch)){
            TextoCompleto= infoNombre.getContenido();
            String temp1="";
            for (String cadena1:TextoCompleto){
                temp1=cadena1;
                productList.add(new Product(R.drawable.img4,temp1));
            }
        }
        return productList;
    }

    public void volvermenu(View v){
        Intent volver= new Intent(this,MainActivity.class);
        startActivity(volver);
        finish();
    }
}
