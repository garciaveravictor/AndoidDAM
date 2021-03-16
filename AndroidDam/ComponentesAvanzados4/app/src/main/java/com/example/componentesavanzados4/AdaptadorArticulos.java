package com.example.componentesavanzados4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class AdaptadorArticulos  extends RecyclerView.Adapter<ArticuloViewHolder> implements View.OnClickListener{
    // Matriz dinámica para guardar los datos
    private final ArrayList<Articulo> datos;

    // Variable para guardar la referencia al método onClick para llamarlo cuando sea necesario
    private View.OnClickListener listener;

    AdaptadorArticulos(ArrayList<Articulo> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ArticuloViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Inflamos la opción con el layout correspondiente
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.articulo, viewGroup, false);

        // Establecemos el evento onClick de la opción
        itemView.setOnClickListener(this);

        // Definimos la nueva opción a partir del elemento anterior
        ArticuloViewHolder ovh = new ArticuloViewHolder(itemView);

        // Devolvemos ya la opción dentro la clase OpcionViewHolder
        return ovh;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticuloViewHolder holder, int position) {
        // Simplemente optenemos los datos en esa posición
        Articulo item = datos.get(position);

        // Añadimos (bind=ligamos) al ViewHolder los datos
        holder.bindArticulo(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    // Método para establecer el evento onClick de la lista
    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    // Método que se ejecuta cuando se invoca el evento onClick
    @Override
    public void onClick(View view)
    {
        // ¡Sólo se invoca si está establecido previamente!
        if(listener != null)
            listener.onClick(view);
    }
}
class ArticuloViewHolder extends RecyclerView.ViewHolder{
    private TextView nombre;

    public ArticuloViewHolder(View itemView){
        super(itemView);

        nombre = (TextView)itemView.findViewById(R.id.textViewNombre);
    }

    @SuppressLint("ResourceAsColor")
    public void bindArticulo(Articulo articulo){
        nombre.setText(articulo.getNombre());

        if(articulo.isComprado())
            nombre.setBackgroundColor(R.color.green);
        else
            nombre.setBackgroundColor(R.color.red);
    }
}
