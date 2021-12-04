package com.upb.cerofilas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.upb.cerofilas.controlador.ControladorLogin;
import com.upb.cerofilas.interfaz.LoginIterface;

public class MainActivity extends AppCompatActivity implements LoginIterface.View {

    EditText editUsuario, editPassword;
    Button btnIngresar;
    ControladorLogin controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsuario = findViewById(R.id.editUsuario);
        editPassword = findViewById(R.id.editPassword);
        btnIngresar = findViewById(R.id.btnIngresar);

        controlador = new ControladorLogin(this);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editUsuario.getText().toString();
                String password = editPassword.getText().toString();
                boolean estado = controlador.validarLogin(usuario,"usuario");

                if(estado == true) {
                    estado = controlador.validarLogin(password,"password");

                    if (estado) {
                        if ("prueba".equals(usuario) && "12345".equals(password)) {
                            Toast.makeText(getApplicationContext(), "Usuario autorizado", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuario/Contraseña incorrecto", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });
    }

    @Override
    public void validarLogin(String indicador, String mensaje) {

        if(indicador.equals("usuario")) {
            editUsuario.setError(mensaje);
        } else {
            editPassword.setError(mensaje);
        }

    }
}