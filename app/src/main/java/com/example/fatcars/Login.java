package com.example.fatcars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void mudarCadastro (View view){
        Intent cadastrar = new Intent(this, cadastro.class);
        startActivity(cadastrar);
    }

    public void Logar (View view){
        email = findViewById(R.id.etLog);
        Intent logar = new Intent(this, telaLogin.class);
        logar.putExtra("email", email.getText().toString());
        startActivity(logar);
        Toast.makeText(getApplicationContext(),"Logado com sucesso!", Toast.LENGTH_SHORT).show();
    }

}
