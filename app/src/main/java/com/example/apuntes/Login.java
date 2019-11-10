package com.example.apuntes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    /*Declaramos aquellos objetos de la pantalla de Login que vamos a necesitar consultar o
     * de los cuales tendremos que programar su funcionalidad*/

    private EditText et_usuario_login;
    private EditText et_contraseña_login;
    private Button btn_iniciar_sesión;
    private Button btn_crear_cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Inicializamos las variables*/
        et_usuario_login = findViewById(R.id.et_usuario_login);
        et_contraseña_login = findViewById(R.id.et_contrasena_login);

        btn_iniciar_sesión = findViewById(R.id.btn_iniciar_sesion);
        btn_crear_cuenta = findViewById(R.id.btn_crear_cuenta);

        /*Porgramamos la funcionalidad de cada uno de los botones*/
        btn_iniciar_sesión.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent init = new Intent(Login.this, MainActivity.class);
                startActivity(init);
            }
        });

    }
}
