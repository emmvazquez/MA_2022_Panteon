package com.example.panteon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Inicio extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    public void onViewCreated(View view, Bundle SavedInstanceState){
        Button BotonAdd = view.findViewById(R.id.btnAdd);
        BotonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_inicio_to_addDifuntos);
            }
        });

        Button BotonMap = view.findViewById(R.id.btnMapa);
        BotonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_inicio_to_mapa);
            }
        });
        Button BotonGraf = view.findViewById(R.id.btnMapa);
        BotonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_inicio_to_mapa);
            }
        });
        Button BotonLineas = view.findViewById(R.id.btnGrafica);
        BotonLineas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_inicio_to_graficas);
            }
        });
        Button BotonPagos = view.findViewById(R.id.btnPago);
        BotonPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_inicio_to_datosPagante);
            }
        });




    }
}