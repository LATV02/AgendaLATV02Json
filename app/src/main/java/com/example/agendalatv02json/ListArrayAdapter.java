package com.example.agendalatv02json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListArrayAdapter extends ArrayAdapter {
    public ListArrayAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;
        if(null==v){
            LayoutInflater layoutInflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=layoutInflater.inflate(R.layout.elementos,null);
        }
        Product product= (Product) getItem(position);
        ImageView img=v.findViewById(R.id.imageView);
        TextView txtnombre=v.findViewById(R.id.mNombre);

        img.setImageResource(product.getImageid());
        txtnombre.setText(product.getNombre());
        return v;
    }
}
