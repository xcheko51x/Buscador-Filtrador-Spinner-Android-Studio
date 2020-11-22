package com.xcheko51x.spinnerfiltrador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    RecyclerView rvLista;
    AdapterRecyclerView adapter;

    List<Trabajadores> listaTrabajadores = new ArrayList<>();
    List<Trabajadores> listaFiltrada = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(new GridLayoutManager(this, 1));

        String[] elementosSpinner = {"Selecciona un area", "Ventas", "Almacen", "Informatica", "Administracion", "Direccion"};
        spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, elementosSpinner));

        listaTrabajadores.add(new Trabajadores("Sergio", "Informatica"));
        listaTrabajadores.add(new Trabajadores("Laura", "Ventas"));
        listaTrabajadores.add(new Trabajadores("Antonio", "Administracion"));
        listaTrabajadores.add(new Trabajadores("Saul", "Informatica"));
        listaTrabajadores.add(new Trabajadores("Daniel", "Almacen"));
        listaTrabajadores.add(new Trabajadores("Ana", "Ventas"));
        listaTrabajadores.add(new Trabajadores("Monica", "Direccion"));

        adapter = new AdapterRecyclerView(MainActivity.this, listaTrabajadores);
        rvLista.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String area = spinner.getSelectedItem().toString();

                if(area.equals("Selecciona un area")) {

                } else {
                    filtrarLista(area);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void filtrarLista(String area) {
        listaFiltrada.clear();

        for(int i = 0 ; i < listaTrabajadores.size() ; i++) {
            if(listaTrabajadores.get(i).getArea().equals(area)) {
                listaFiltrada.add(listaTrabajadores.get(i));
            }
        }

        Intent intent = new Intent(MainActivity.this, ActivityFiltrados.class);
        intent.putExtra("lista", (Serializable) listaFiltrada);
        startActivity(intent);
    }
}