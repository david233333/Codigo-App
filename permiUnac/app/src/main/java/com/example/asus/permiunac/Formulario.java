package com.example.asus.permiunac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Formulario extends AppCompatActivity {

    Button buttonGuardar, buttonVolver,buttonEnviar;
    EditText editTexNombre,editTextApellido,editTextSalida,editTextLlegada,editTexFecha,editTexMotivo;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        editTexNombre = (EditText) findViewById(R.id.editTexNombre);
        editTextApellido = (EditText) findViewById(R.id.editTextApellido);
        editTextSalida = (EditText) findViewById(R.id.editTextSalida);
        editTextLlegada = (EditText) findViewById(R.id.editTextLlegada);
        editTexFecha = (EditText) findViewById(R.id.editTexFecha);
        editTexMotivo = (EditText) findViewById(R.id.editTexMotivo);
        buttonGuardar = (Button) findViewById(R.id.buttonGuardar);
        buttonVolver = (Button) findViewById(R.id.buttonVolver);
        buttonEnviar = (Button) findViewById(R.id.buttonEnviar);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = editTexNombre.getText().toString();
                String Apellidos = editTextApellido.getText().toString();
                String salida = editTextLlegada.getText().toString();
                String fecha = editTexFecha.getText().toString();
                String motivo = editTexMotivo.getText().toString();

                Datos datos = new Datos(Nombre,Apellidos,salida,fecha,motivo);

                databaseReference.child("user").child(Nombre).setValue(datos);
            }
        });

    }
}
