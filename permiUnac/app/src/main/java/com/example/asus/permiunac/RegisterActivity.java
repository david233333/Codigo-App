package com.example.asus.permiunac;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText email,password;
    Button register2;
    FirebaseAuth auth;
    FirebaseUser user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth =FirebaseAuth.getInstance();


        email = (EditText) findViewById(R.id.CorreoElectronico);
        password = (EditText) findViewById(R.id.Contraseña);
        register2 = (Button) findViewById(R.id.Crear);


        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userE = email.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(userE)) {
                    Toast.makeText(getApplicationContext(), "coloca un correo", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(), "coloca una contraseña", Toast.LENGTH_SHORT).show();
                }
                auth.createUserWithEmailAndPassword(userE,pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            FirebaseAuth auth = FirebaseAuth.getInstance();
                            FirebaseUser user = auth.getCurrentUser();

                            user.sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(getApplicationContext(), "Coreeo de verificacion enviado", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                        }
                        if (!task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "No se ha creado La cuenta", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }


}
