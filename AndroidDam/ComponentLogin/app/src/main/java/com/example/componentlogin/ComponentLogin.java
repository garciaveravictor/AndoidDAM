package com.example.componentlogin;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ComponentLogin extends LinearLayout
{
    // Componentes que forman el componente compuesto
    private EditText textoUsuario;
    private EditText textoPassword;
    private Button botonLogin;
    private TextView labelMensaje;

    // Evento que se invoca cuando el usuario pulsa el botón Entrar
    private OnLoginListener listener;

    // Constructor por defecto
    public ComponentLogin(Context context)
    {
        super(context);
        inicializar();
    }

    // Constructor que define el texto del botón de acceso
    public ComponentLogin(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        inicializar();

        // Procesamos los atributos XML personalizados
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ComponentLogin);
        String textoBoton = a.getString(R.styleable.ComponentLogin_text_button);

        // Escribimos el testo del botón
        botonLogin.setText(textoBoton);

        // Liberamos memoria
        a.recycle();
    }

    // Este método se usa para dibujar (inflar) el componente compuesto
    private void inicializar()
    {
        //Utilizamos el diseño layout 'componente_login' como interfaz del componente
        // Primero obtener el inflater
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li =(LayoutInflater)getContext().getSystemService(infService);

        // Inflamos el componente compuesto definido en el XML
        li.inflate(R.layout.component_login, this, true);

        //Obtenemos las referencias a los distintos componentes internos
        textoUsuario = (EditText)findViewById(R.id.TextoUsuario);
        textoPassword = (EditText)findViewById(R.id.TextoPassword);
        botonLogin = (Button)findViewById(R.id.BotonAceptar);
        labelMensaje = (TextView)findViewById(R.id.LabelMensaje);

        //Asociamos los eventos necesarios
        asignarEventos();
    }

    // Establece el listener del componente compuesto
    public void setOnLoginListener(OnLoginListener l)
    {
        listener = l;
    }

    // Define un nuevo evento para el componente compuesto
    private void asignarEventos()
    {
        // Cuando el usuario hace clic sobre el botón Entrar
        // entonces se lanza el evento onLogin con los datos
        // de las cajas de texto
        botonLogin.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                listener.onLogin(textoUsuario.getText().toString(),
                        textoPassword.getText().toString());
            }
        });
    }

    // Permite escribir la etiqueta con el resultado del Login
    public void setMensaje(String msg)
    {
        labelMensaje.setText(msg);
    }
}
