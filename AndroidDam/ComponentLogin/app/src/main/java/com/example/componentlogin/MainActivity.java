package com.example.componentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Referencia al componente
        final ComponentLogin compLogin = (ComponentLogin)findViewById(R.id.ComponentLogin);

        // Definimos lo que hace el evento onLogin
        compLogin.setOnLoginListener(new OnLoginListener()
        {
            @Override
            public void onLogin(String usuario, String password)
            {
                //Validamos el usuario y la contraseña
                if (usuario.equals("admin") && password.equals("admin"))
                    compLogin.setMensaje("¡El usuario es correcto!");
                else
                    compLogin.setMensaje("Error, usuario y/o contraseña no válidos");
            }
        });
    }
}