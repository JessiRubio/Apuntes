package com.example.apuntes.ui.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apuntes.R;

import java.util.List;

public class adaptadorRecycler extends RecyclerView.Adapter<adaptadorRecycler.ViewHolder> {

    private LayoutInflater inflador;
    protected List<Objeto> Lista;
    private Context contexto;

    private View.OnClickListener onClickListener;
    private View.OnLongClickListener onLongClickListener;


    public adaptadorRecycler (Context contexto, List<Objeto> List) {
        inflador = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        this.Lista = List;
        this.contexto = contexto;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;
        public TextView apellido;
        public ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen = itemView.findViewById(R.id.imagenPerfil);
            apellido = itemView.findViewById(R.id.apellido_objeto);
            nombre = itemView.findViewById(R.id.nombre_objeto);


        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.contenido_recycler,null);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int posicion) {
        Objeto persona = Lista.get(posicion);
        holder.nombre.setText(persona.getNombre());
        holder.apellido.setText(persona.getApellido());
    }

    @Override
    public int getItemCount () { return Lista.size(); }

    public void setOnItemClickListener (View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


}