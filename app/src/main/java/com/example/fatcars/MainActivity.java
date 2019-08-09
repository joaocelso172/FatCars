package com.example.fatcars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


           // Intent Mudar = new Intent(this, catalogo.class);
           //startActivity(Mudar);


        //Intent intent = new Intent(this, catalogo.class);
       // startActivity(intent);
    }

  //  public void comecar (View view)

    public void fazerReserva (View view){
        Intent fReserva = new Intent(this, reservar.class);
        startActivity(fReserva);
    }

    public void mudarTela (View view){
        Intent Mudar = new Intent(this, reservar.class);
        startActivity(Mudar);
    }

    public void mudarLogin (View view){
        Intent login = new Intent(this, Login.class);
        startActivity(login);

    }
    public void mudarCadastro (View view){
        Intent cadastrar = new Intent(this, cadastro.class);
        startActivity(cadastrar);

    }

    public void A (View view){
        Intent cadastrar = new Intent(this, MenuPadrao.class);
        startActivity(cadastrar);

    }


}
