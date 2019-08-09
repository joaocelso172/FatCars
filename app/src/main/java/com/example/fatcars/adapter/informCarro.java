package com.example.fatcars.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fatcars.Pagamento;
import com.example.fatcars.R;
import com.example.fatcars.reservar;

public class informCarro extends AppCompatActivity {

    //public Intent testando = new Intent(this, informCarro.class);
    public static String nomeCarro;
    public static String montadora;
    public static String anoFab;
    public static int fotoCarro;
    public static String valor;
    public static boolean desligarBot = false;


public void tentandoReserv (View view) {
    Intent irReservar = new Intent(getApplicationContext(), Pagamento.class);
    startActivity(irReservar);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform_carro);

        this.tela();
    }

    public void tela () {
        Button alug = (Button) findViewById(R.id.button11);
        if (desligarBot){
            alug.setVisibility(View.GONE);
        }else alug.setVisibility(View.VISIBLE);
        ImageView foto = (ImageView) findViewById(R.id.fotoCar);
        TextView modeloCarro = (TextView) findViewById(R.id.modeloCar);
        TextView fabricante = (TextView) findViewById(R.id.montadoraCar);
        TextView anoFabrica = (TextView) findViewById(R.id.anoCar);
        TextView precoAlug = (TextView) findViewById(R.id.valorCar);
        foto.setImageResource(informCarro.fotoCarro);
        modeloCarro.setText(informCarro.nomeCarro);
        fabricante.setText(informCarro.montadora);
        anoFabrica.setText(informCarro.anoFab);
        precoAlug.setText(informCarro.valor);
    }
}
