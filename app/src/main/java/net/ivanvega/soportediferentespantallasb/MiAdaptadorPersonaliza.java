package net.ivanvega.soportediferentespantallasb;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.Vector;

public class MiAdaptadorPersonaliza extends
        Adapter<MiAdaptadorPersonaliza.ViewHolder>{
    private Vector<Libro> libros;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  static class ViewHolder extends
                RecyclerView.ViewHolder {

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

            }
        }

}
