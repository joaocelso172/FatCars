package com.example.fatcars;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fatcars.ApiCep.CEP;
import com.example.fatcars.ApiCep.HTTPService;

import java.util.concurrent.ExecutionException;

public class endereco extends AppCompatActivity {

   // String ruaExport = "";

  /*  public String getRuaExport() {
        return ruaExport;
    }

    public void setRuaExport(String ruaExport) {
        this.ruaExport = ruaExport;
    }*/

    /*public void retornar(View v){
        Intent retornCadastro = new Intent(this, cadastro.class);
     //   retornCadastro.putExtra("ruaCad", ruaExport);
      //  retornCadastro.putExtra("bairroCad", ruaExport);
        startActivity(retornCadastro);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        final EditText eCep = findViewById(R.id.etCep);
       // final TextView end = findViewById(R.id.txtEnd);
       // final TextInputLayout tlRua = findViewById(R.id.tilRua);
        final TextInputEditText rua = findViewById(R.id.etRua);
        final TextInputEditText bairro = findViewById(R.id.etBairro);
        final TextInputEditText cidade = findViewById(R.id.etCity);
        final TextInputEditText complemento = findViewById(R.id.etComplemento);
        final TextInputEditText estado = findViewById(R.id.etUf);


        Button buscar = findViewById(R.id.btnCep);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eCep.getText().toString().length() > 0 && !eCep.getText().toString().equals("") && eCep.getText().toString().length() == 8){
                    HTTPService service = new HTTPService(eCep.getText().toString());
                    try {
                        CEP retorno = service.execute().get();
                        cadastro cad = new cadastro();
                        //teste = retorno.toString();
                        if (retorno.toString() != "" || retorno.toString() != null) {
                          //  end.setText(retorno.toString());
                            if (!retorno.getLogradouro().equals("")) {
                                rua.setText(retorno.getLogradouro());
                                rua.setEnabled(false);
                            }
                            if (!retorno.getBairro().equals("")) {
                                bairro.setText(retorno.getBairro());
                                bairro.setEnabled(false);
                            }
                            if (!retorno.getLocalidade().equals("")) {
                                cidade.setText(retorno.getLocalidade());
                                cidade.setEnabled(false);
                            }
                            /*if (!retorno.getComplemento().equals("")) {
                                complemento.setText(retorno.getComplemento());
                                complemento.setEnabled(false);
                            }*/
                            if (!retorno.getUf().equals("")) {
                                estado.setText(retorno.getUf());
                                estado.setEnabled(false);
                            }

                        }//else end.setText("Não foi possível acessar o servidor");
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
