package com.example.agendalatv02json;

import android.app.Activity;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class manejoArchivoTXT {
    private ArrayList<String> TextoCompleto=new ArrayList<String>();

    private JSONArray array = new JSONArray();
    private JSONObject obj = new JSONObject();

    public void agregar(String dato1,String dato2,String dato3,String dato4, ArrayList<String> contenido){

        try {
            obj.put("nombre",dato1);
            obj.put("Correo",dato2);
            obj.put("Edad",dato3);
            obj.put("CURP",dato4);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextoCompleto=contenido;
        TextoCompleto.add(obj.toString());
    }

    public boolean grabar(ArrayList<String> dato, Context contexto, String nomarch) throws IOException {
        boolean estado=true;
        try{
            OutputStreamWriter achivo = new OutputStreamWriter(contexto.openFileOutput(nomarch, Activity.MODE_PRIVATE));
            for(String Texto:dato)
                achivo.write(Texto+"\n" );
            achivo.flush();
            achivo.close();
        }catch (Exception e){
            estado=false;
        }
        return estado;

    }

    public boolean leer(Context context, String nomarch){
        ArrayList<String> textcompletoo=new ArrayList<String>();
        try{
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(nomarch));
            BufferedReader br= new BufferedReader(archivo);
            String cadena= br.readLine();
            while(cadena!=null){
                textcompletoo.add(cadena);
                cadena=br.readLine();
            }

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        TextoCompleto=textcompletoo;
        return true;
    }

    public boolean verificar(Context context, String nomarch){
        String[] archivos= context.fileList();
        for (String archivo: archivos){
            if(archivo.equals(nomarch)) return true;
        }
        return false;
    }

    public ArrayList<String> getContenido()
    {
        return TextoCompleto;
    }
}
