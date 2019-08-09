package com.example.fatcars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fatcars.adapter.informCarro;
import com.example.fatcars.adapter.informLateral;

public class comprovante extends AppCompatActivity {

  //  String formPag;
    private TextView Pag;


    public void voltandoaoCar(View view){
        Intent voltandoInf = new Intent(this, informLateral.class);
        startActivity(voltandoInf);
        informCarro.desligarBot = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprovante);

        Pag = findViewById(R.id.textPag);


        this.setando();
    }



    public void setando(){
        Pagamento forma = new Pagamento();
       // formPag = forma.getPagamento();
        //forma.getPagamento();
         Pag.setText("Forma de pagamento: \n" + forma.getPagamentos());
    }


}
