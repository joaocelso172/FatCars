package com.example.fatcars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class testeCadastro extends AppCompatActivity {

    private ToggleButton testes;
    private TextView textCF;
    private TextView textCJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_cadastro);

        testes = findViewById(R.id.togglePessoa);
        textCF = findViewById(R.id.textFisica);
        textCJ = findViewById(R.id.textJuridica);
    }

    public void Toggle(View view) {
        if (testes.isChecked()){
            textCF.setVisibility(View.GONE);
            textCJ.setVisibility(View.VISIBLE);
        }else{
            textCJ.setVisibility(View.GONE);
            textCF.setVisibility(View.VISIBLE);
        }
    }
}
