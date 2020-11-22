package com.xcheko51x.spinnerfiltrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ActivityFiltrados extends AppCompatActivity {

    RecyclerView rvFiltrados;
    AdapterRecyclerView adapter;

    List<Trabajadores> listaTrabajadores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrados);

        listaTrabajadores = (List<Trabajadores>) getIntent().getSerializableExtra("lista");

        rvFiltrados = findViewById(R.id.rvFiltrados);
        rvFiltrados.setLayoutManager(new GridLayoutManager(this, 1));

        adapter = new AdapterRecyclerView(ActivityFiltrados.this, listaTrabajadores);
        rvFiltrados.setAdapter(adapter);
    }
}