package com.example.panteon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.AbstractCollection;


public class DatosPagante extends Fragment {
    EditText NombreAcredor;
    EditText ApellidoPatAcredor;
    EditText ApellidoMatAcredor;
    EditText Telefono;
    EditText Calle;
    EditText Colonia;
    EditText Municipio;
    EditText Estado;
    EditText NumExterior;
    EditText NombreDifunto;
    EditText ApPaterDifunto;
    EditText ApMaterDifunto;
    private AbstractCollection<JsonObjectRequest> queue;


    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datos_pagante, container, false);
    }
    public void onViewCreated(View view, Bundle SavedInstanceState){

        NombreAcredor = (EditText) view.findViewById(R.id.ETNombreAcreador);
        ApellidoPatAcredor = (EditText) view.findViewById(R.id.ETApePatAcredor);
        ApellidoMatAcredor = (EditText) view.findViewById(R.id.ETApeMatAcredor);
        Telefono = (EditText) view.findViewById(R.id.ETNumeroTel);
        Calle = (EditText) view.findViewById(R.id.ETCalle);
        Colonia = (EditText) view.findViewById(R.id.ETColonia);
        Municipio = (EditText) view.findViewById(R.id.ETMunicipio);
        Estado = (EditText) view.findViewById(R.id.ETEstado);
        NumExterior = (EditText) view.findViewById(R.id.ETNumExte);
        NombreDifunto = (EditText) view.findViewById(R.id.ETNombreDifunto);
        ApPaterDifunto = (EditText) view.findViewById(R.id.ETApellidoPatDif);
        ApMaterDifunto = (EditText) view.findViewById(R.id.ETApellidoMatDif);

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        Button BotonContPago = view.findViewById(R.id.btnContinuar);
        BotonContPago.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String sNombreAcredor = NombreAcredor.getText().toString();
                String sApellidoPatAcredor = ApellidoPatAcredor.getText().toString();
                String sApellidoMatAcredor = ApellidoMatAcredor.getText().toString();
                String sTelefono = Telefono.getText().toString();
                String sCalle = Calle.getText().toString();
                String sColonia  = Colonia.getText().toString();
                String sMunicipio = Municipio.getText().toString();
                String sEstado = Estado.getText().toString();
                String sNumExterior = NumExterior.getText().toString();
                String sNombreDifunto = NombreDifunto.getText().toString();
                String sApPaterDifunto = ApPaterDifunto.getText().toString();
                String sApMaterDifunto = ApMaterDifunto.getText().toString();

                String url="http://192.168.0.104/Panteon/ServicioAcredor.php?NombreAcredor="+sNombreAcredor+"&ApellidoPAcredor="+sApellidoPatAcredor+"&ApellidoMAcredor="+sApellidoMatAcredor+
                        "&Telefono="+sTelefono+"&Calle="+sCalle+"&Colonia="+sColonia+"&NumeroExterior="+sNumExterior+"&Municipio="+sMunicipio+"&Estado="+sEstado+"&NombreDifunto="+sNombreDifunto+
                        "&ApellidoPDifunto="+sApPaterDifunto+"&ApellidoMDifunto="+sApMaterDifunto;

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(v.getContext(), response.toString(), Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(v.getContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
                );
                queue.add(jsonObjectRequest);
                Navigation.findNavController(view).navigate(R.id.action_datosPagante_to_datosPago);


            }
        });
        Button BotonReg = view.findViewById(R.id.btnRegresar4);
        BotonReg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_datosPagante_to_inicio);
            }
        });
    }
}