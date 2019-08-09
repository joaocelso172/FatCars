package com.example.fatcars;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fatcars.lista.listaCarros;

public class reservar extends AppCompatActivity {

    private CalendarView theDate;
    private TextView status;
    private TextView inicioViagem;
    private TextView fimViagem;
    private TextView agendar;
    private TextView altern;
    String data;
    String inicioAlugar;
    String fimAlugar;
    boolean inicio;
    boolean fim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);

        theDate = (CalendarView) findViewById(R.id.Calendario);
        status = (TextView) findViewById(R.id.textstt);
        inicioViagem = (TextView) findViewById(R.id.textDataini);
        fimViagem = (TextView) findViewById(R.id.textDatafim);
        agendar = (TextView) findViewById(R.id.btnAgendar);
        altern = (TextView) findViewById(R.id.alterar);
        altern.setVisibility(View.GONE);

        theDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(), "Item pressionado: " + dayOfMonth + month + year, Toast.LENGTH_SHORT);
                        data = dayOfMonth + "/" + month + "/" + year;
            }

        });

    }

    public void alternClick(View view){
        inicioAlugar = "";
        inicioViagem.setText("Retirada: " + inicioAlugar);
        inicio = false;
        fimAlugar = "";
        fimViagem.setText("Devolução: " + fimAlugar);
        fim = false;
        altern.setVisibility(View.GONE);
        agendar.setText("Agendar");
    }
    public void clicar (View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.create();
        if (!inicio) {

            dialog.setMessage("Confirmar data de retirada de veículo? ");

            dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    inicioAlugar = data;
                    Toast.makeText(getApplicationContext(), "Retirada de veículo confirmada para " + inicioAlugar + ".", Toast.LENGTH_SHORT).show();
                    inicio = true;
                    inicioViagem.setText("Retirada: " + inicioAlugar);
                    status.setText("Escolha a data para devolução do veículo");
                }
            });

            dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    inicio = false;
                    Toast.makeText(getApplicationContext(), "Escolha a data para retirada de veículo", Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();
           /* inicioAlugar = data;
            inicio = true;*/


        } else if (!fim ) {
            dialog.setMessage("Confirmar data de devolução de veículo? ");

            dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    fimAlugar = data;
                    Toast.makeText(getApplicationContext(), "Devolução de veículo confirmada para " + fimAlugar + ".", Toast.LENGTH_SHORT).show();
                    fim = true;
                    fimViagem.setText("Devolução: " + fimAlugar);
                  //  agendar.setText("Pagar");
                    status.setText("Confira a data e vá para o pagamento");
                    altern.setVisibility(View.VISIBLE);
                }
            });

            dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    fim = false;
                    Toast.makeText(getApplicationContext(), "Escolha a data para retirada de veículo", Toast.LENGTH_SHORT).show();
                }
            });
           /* fimAlugar = data;
            fim = true;*/
           dialog.show();
        }else if (inicio && fim) {
            Intent mudarPagamento = new Intent(this, listaCarros.class);
            startActivity(mudarPagamento);
            Pagamento.setPagamentos(null);
        }

        /*inicioViagem.setText(inicioAlugar);
        fimViagem.setText(fimAlugar);*/

    }
}

