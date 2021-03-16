package com.example.componentesavanzados4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Usamos esta matriz dinámica (ArrayList) para guardar los datos de las 32 opciones del listado
    private ArrayList<Articulo> datos;

    // Lista del tipo RecyclerView
    private RecyclerView recView;

    //Boton añadir
    private Button btnAniadir;

    //EditText con el nombre del articulo
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscamos en el layout la lista RecyclerView
        recView = (RecyclerView) findViewById(R.id.recView);

        // Indicamos que el tamaño del RecyclerView no cambia
        recView.setHasFixedSize(true);

        // Crea el ArrayList con elementos Opcion
        datos = new ArrayList<Articulo>();

        // Creamos el Adaptador que se usa para mostrar las opciones del listado
        final AdaptadorArticulos adaptador = new AdaptadorArticulos(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.get(recView.getChildAdapterPosition(v)).setComprado(true);
                Toast.makeText(getBaseContext(), "Has hecho clic en '" + datos.get(recView.getChildAdapterPosition(v)).getNombre()
                        + "'", Toast.LENGTH_SHORT).show();
            }
        });

        // Asignamos el adaptador al RecyclerView para que sepa cómo dibujar el listado de opciones
        recView.setAdapter(adaptador);

        // Muy importante indicar el tipo de Layout. ¡Obligatorio!!!
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        // Animador de la lista
        recView.setItemAnimator(new DefaultItemAnimator());

        btnAniadir = findViewById(R.id.button);
        editText = findViewById(R.id.editTextArticulo);

        btnAniadir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                datos.add(0, new Articulo(editText.getText().toString()));

                // Indicamos al adaptador que hemos añadido un nuevo elemento en la posición 0
                // para que redibuje el RecyclerView.
                adaptador.notifyItemInserted(0);
                Toast.makeText(getBaseContext(), "Articulo añadido tamaño de la lista: "+ adaptador.getItemCount(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}