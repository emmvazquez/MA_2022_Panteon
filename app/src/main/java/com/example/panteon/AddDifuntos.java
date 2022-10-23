package com.example.panteon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class AddDifuntos extends Fragment {
    EditText nombre;
    EditText apellidopaterno;
    EditText apellidomaterno;
    EditText fechainhumacion;
    EditText metrostumba;
    EditText numeroconstancia;
    EditText tipodifunto;
    EditText genero;
    EditText clave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_difuntos, container, false);
    }
    public void onViewCreated(View view, Bundle SavedInstanceState){
        nombre           = (EditText) view.findViewById(R.id.ETNombre);
        apellidopaterno  = (EditText) view.findViewById(R.id.ETAPaterno);
        apellidomaterno  = (EditText) view.findViewById(R.id.ETAMaterno);
        fechainhumacion  = (EditText) view.findViewById(R.id.ETFecha);
        metrostumba      = (EditText) view.findViewById(R.id.ETMetrosTumba);
        numeroconstancia = (EditText) view.findViewById(R.id.ETNumero);
        tipodifunto      = (EditText) view.findViewById(R.id.ETTipo);
        genero           = (EditText) view.findViewById(R.id.ETGenero);
        clave            = (EditText) view.findViewById(R.id.ETClave);

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        Button BotonRegresar = view.findViewById(R.id.btnRegresar);
        Button BotonGuardar = view.findViewById(R.id.btnGuardar);

        BotonRegresar.setOnClickListener(new View.OnClickListener()

         {

            @Override

            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_addDifuntos_to_inicio2);

            }
        });

        BotonGuardar.setOnClickListener(new View.OnClickListener()

       {
            @Override
            public void onClick(View v) {

                String sNombre                    = nombre.getText().toString();
                String sApellidoPaterno           = apellidopaterno.getText().toString();
                String sApellidoMaterno           = apellidomaterno.getText().toString();
                String sFechaInhumacion           = fechainhumacion.getText().toString();
                String sMetrosTumba               = metrostumba.getText().toString();
                String sNumeroConstancia          = numeroconstancia.getText().toString();
                String sTipoDifunto               = tipodifunto.getText().toString();
                String sGenero                    = genero.getText().toString();
                String sClave                     = clave.getText().toString();

                String url = "http://192.168.0.104/Panteon/ServicioDifunto.php?Nombre="+sNombre+"&ApellidoPaterno="+sApellidoPaterno+"&ApellidoMaterno="+sApellidoMaterno+"&FechaInhumacion="+sFechaInhumacion+"&NumeroConstancia="+sNumeroConstancia+"&TipoDifunto="+sTipoDifunto+"&MetrosTumba="+sMetrosTumba+"&Genero="+sGenero+"&Clave="+sClave;

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

               Navigation.findNavController(view).navigate(R.id.action_addDifuntos_to_inicio2);

            }
        });
    }

}