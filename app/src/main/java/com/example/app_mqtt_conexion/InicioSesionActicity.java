package com.example.app_mqtt_conexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InicioSesionActicity extends AppCompatActivity {

    private EditText et_User,et_Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion_acticity);
        et_User = (EditText) findViewById(R.id.et_User);
        et_Pass = (EditText) findViewById(R.id.et_Pass);
    }

    public void Ingresar(View view){
        //Aca le digo que voy a querer pasar de este contexto (this) a la clase SegundoActivity
        Intent Int_Ingresar = new Intent(this, MainActivity.class);
        if (et_User.getText().toString() == "Diego" && et_Pass.getText().toString() == "hola"){
            startActivity(Int_Ingresar); //Aca se dispara osea se ejecuta la accion de switchear los activitys
        }else {
            Toast.makeText(this, "Usuario o Contraseña errorneo", Toast.LENGTH_SHORT).show();
            startActivity(Int_Ingresar); //Aca se dispara osea se ejecuta la accion de switchear los activitys
        }

    }
}