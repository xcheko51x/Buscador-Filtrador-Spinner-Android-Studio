package com.xcheko51x.spinnerfiltrador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    Context context;
    List<Trabajadores> listaTrabajadores = new ArrayList<>();

    public AdapterRecyclerView(Context context, List<Trabajadores> listaTrabajadores) {
        this.context = context;
        this.listaTrabajadores = listaTrabajadores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_trabajadores, null, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNomTrabajadores.setText(listaTrabajadores.get(position).getNombre());
        holder.tvArea.setText(listaTrabajadores.get(position).getArea());
    }

    @Override
    public int getItemCount() {
        return listaTrabajadores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomTrabajadores, tvArea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomTrabajadores = itemView.findViewById(R.id.tvNomTrabajadores);
            tvArea = itemView.findViewById(R.id.tvArea);
        }
    }
}
