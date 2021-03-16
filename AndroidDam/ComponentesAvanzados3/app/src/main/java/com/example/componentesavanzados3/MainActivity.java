package com.example.componentesavanzados3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private Opcion[] opciones;
    private RecyclerView recView;
    private Button btnAceptar;
    private CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscamos en el layout la lista RecyclerView
        recView = (RecyclerView) findViewById(R.id.recView);

        //Creo el array de opciones
        opciones = new Opcion[6];
        checkBoxes = new CheckBox[6];

        //Creo las 6 opciones
        opciones[0] = new Opcion("Televisión", checkBoxes[0] = (CheckBox) findViewById(R.id.checkbox), R.drawable.television);
        opciones[1] = new Opcion("Teléfono Móvil", checkBoxes[1] = (CheckBox) findViewById(R.id.checkbox), R.drawable.telefono);
        opciones[2] = new Opcion("Tablet", checkBoxes[2] = (CheckBox) findViewById(R.id.checkbox), R.drawable.tablet);
        opciones[3] = new Opcion("Ordenador", checkBoxes[3] = (CheckBox) findViewById(R.id.checkbox), R.drawable.pc);
        opciones[4] = new Opcion("Portatil", checkBoxes[4] = (CheckBox) findViewById(R.id.checkbox), R.drawable.portatil);
        opciones[5] = new Opcion("Reloj", checkBoxes[5] = (CheckBox) findViewById(R.id.checkbox), R.drawable.reloj);

        // Creamos el Adaptador que se usa para mostrar las opciones del listado
        final AdaptadorOpciones adaptador = new AdaptadorOpciones(opciones);

        // Definimos el evento onClick del adaptador
        adaptador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Usamos el resultado de "getChildAdapterPosition()" para saber
                // la posición de la opción sobre la que el usuario ha hecho clic.
                Toast.makeText(getBaseContext(), "Has hecho clic en '"
                        + opciones[recView.getChildAdapterPosition(v)].getTitulo()
                        + "'", Toast.LENGTH_SHORT).show();

                opciones[recView.getChildAdapterPosition(v)].getCheckBox().setChecked(true);
            }
        });

        // Asignamos el adaptador al RecyclerView para que sepa cómo dibujar el listado de opciones
        recView.setAdapter(adaptador);

        // Muy importante indicar el tipo de Layout. ¡Obligatorio!!!
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        btnAceptar = findViewById(R.id.button);

       /* btnAceptar.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(checkBoxes[0].isChecked())
                      Toast.makeText(getBaseContext(), "Utilizas " + opciones[0].getTitulo(), Toast.LENGTH_SHORT).show();
              }
        });*/
    }

}