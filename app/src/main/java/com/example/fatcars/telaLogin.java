package com.example.fatcars;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.fatcars.Login.logado;

public class telaLogin extends AppCompatActivity {


    private TextView BemVindo;

    public void historico (View view){
        Intent hist = new Intent(this, historico.class);
        startActivity(hist);
    }

    public void alterarCadastro(View view){
        Intent altCad = new Intent(this, Editarcadastro.class);
        startActivity(altCad);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        BemVindo = findViewById(R.id.textWelcome);

        Bundle teste = getIntent().getExtras();
        String email = teste.getString("email");

        if (logado) {
            BemVindo.setText("Bem vindo," + email);

        }
    }


}
