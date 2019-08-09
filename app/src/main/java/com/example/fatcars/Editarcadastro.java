package com.example.fatcars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Editarcadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarcadastro);
    }

    public void salvarAltern(View view){
        Intent salvar = new Intent(this, telaLogin.class);
        startActivity(salvar);
        Toast.makeText(getApplicationContext(), "Alterações salvas com sucesso", Toast.LENGTH_SHORT).show();
    }

    public void irHOME(View view){
        Intent casa = new Intent(this, MainActivity.class);
        startActivity(casa);
        //Toast.makeText(getApplicationContext(), "Alterações salvas com sucesso", Toast.LENGTH_SHORT).show();
    }

}
