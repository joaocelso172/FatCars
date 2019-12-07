package com.example.fatcars;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.fatcars.Login.logado;

public class Pagamento extends AppCompatActivity{


    private CheckBox boleto;
    private CheckBox cartao;
    private static String pagamentos;
    private TextView textae;
    private Dialog myDialog;
    private Login login;
    private ConstraintLayout pag;
    private ConstraintLayout log;
    private Button contPag;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        myDialog = new Dialog(this);

        boleto = findViewById(R.id.checkBol);
        cartao = findViewById(R.id.checCart);
        textae = findViewById(R.id.texte);
        pag = findViewById(R.id.constraintPagina);
        contPag = findViewById(R.id.btnContinuarPag);
        contPag.setVisibility(View.GONE);
        log = findViewById(R.id.constraintLogin);



        if (!logado) {

            login = new Login();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.constraintLogin, login);
            pag.setVisibility(View.GONE);
            contPag.setVisibility(View.VISIBLE);
            transaction.commit();

        }


    }

    public void fecharLogin(View view){
        login = new Login();
        if (getFragmentManager().getBackStackEntryCount() == 0) {
        //    this.finish();
            log.setVisibility(View.GONE);
            contPag.setVisibility(View.GONE);
            pag.setVisibility(View.VISIBLE);
        }/* else {
            getFragmentManager().popBackStack();
        }*/


    }


    public void finalizar (View view){
        if(pagamentos != null) {
            Intent Finalizar = new Intent(this, comprovanteLateral.class);
            startActivity(Finalizar);
            Toast.makeText(getApplicationContext(), "Pagamento realizado", Toast.LENGTH_SHORT).show();
        }else {
            AlertDialog.Builder msgErro = new AlertDialog.Builder(this);
            msgErro.create();
            msgErro.setMessage("Selecione a forma de pagamento antes de prosseguir!");
            msgErro.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            msgErro.show();
        }
    }

    public void Boleto (View view){
        if (boleto.isChecked()) {
            cartao.setChecked(false);
           setPagamentos("Boleto");
            textae.setText(getPagamentos());
        }else {setPagamentos(null); textae.setText(null);}
    }

    public void cartao (View view){
        if (cartao.isChecked()) {
            boleto.setChecked(false);
           setPagamentos("Cartao");
            textae.setText(getPagamentos());
        }else {setPagamentos(null); textae.setText(null); }
    }

    public static String getPagamentos() {
        return pagamentos;
    }

    public static void setPagamentos(String pagamentos) {
        Pagamento.pagamentos = pagamentos;
    }


}
