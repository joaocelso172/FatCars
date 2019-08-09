package com.example.fatcars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class historico extends AppCompatActivity {

    public void retornarReserva(View view){
        Intent retornarReserv = new Intent(this, comprovanteLateral.class);
        startActivity(retornarReserv);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
    }
}
