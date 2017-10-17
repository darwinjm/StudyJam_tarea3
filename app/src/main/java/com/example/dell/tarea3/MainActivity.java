package com.example.dell.tarea3;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity implements EquipoAdapter.onEquipoSelectedListener{

        RecyclerView equiposRecyclerView;
        EquipoAdapter equipoAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            equiposRecyclerView = (RecyclerView) findViewById(R.id.recycler_main);
            equiposRecyclerView.setHasFixedSize(true);
            equiposRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            equipoAdapter = new EquipoAdapter(this, this);

            llenarDatos();

            equiposRecyclerView.setAdapter(equipoAdapter);
        }

        private void llenarDatos() {
            List<Equipo> lista = new ArrayList<>();
            lista.add(new Equipo(R.drawable.coche1, " Lamborghini ", getString(R.string.Descripcion_Coche1)));
            lista.add(new Equipo(R.drawable.coche2, "Autobots", getString(R.string.Descripcion_Coche2)));
            lista.add(new Equipo(R.drawable.coche3, " Lamborghini ", getString(R.string.Descripcion_Coche3)));
            lista.add(new Equipo(R.drawable.coche4, "Autobots", getString(R.string.Descripcion_Coche4)));
            lista.add(new Equipo(R.drawable.coche5, " Lamborghini ", getString(R.string.Descripcion_Coche5)));
            lista.add(new Equipo(R.drawable.coche6, " Lamborghini ", getString(R.string.Descripcion_Coche6)));
            lista.add(new Equipo(R.drawable.coche7, "Autobots", getString(R.string.Descripcion_Coche7)));
            lista.add(new Equipo(R.drawable.coche8, " Lamborghini ", getString(R.string.Descripcion_Coche8)));
            lista.add(new Equipo(R.drawable.coche9, "Autobots", getString(R.string.Descripcion_Coche2)));

            equipoAdapter.setDataset(lista);
        }

        @Override
        public void onEquipoSelected(Equipo equipo) {
            Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
            intent.putExtra("equipo", equipo);
            startActivity(intent);
        }

    }
