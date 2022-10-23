package com.example.panteon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InicioSesion extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
    }

    public void onViewCreated (View view, Bundle SavedInstanceState){
        Button BotonIS = view.findViewById(R.id.btnInicio);
        BotonIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_inicioSesion_to_inicio);
            }
        });
        Button BotonI = view.findViewById(R.id.btnRegistrar);
        BotonI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_inicioSesion_to_registrarse);
            }
        });
    }
}