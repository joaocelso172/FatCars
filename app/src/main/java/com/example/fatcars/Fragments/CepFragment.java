package com.example.fatcars.Fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fatcars.ApiCep.CEP;
import com.example.fatcars.ApiCep.HTTPService;
import com.example.fatcars.R;
import com.example.fatcars.cadastro;

import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 */
public class CepFragment extends Fragment implements View.OnClickListener {


    String nomeRua;
    String tipoCasa;
    String numero;
    TextInputEditText local;
    TextView setarEnd;

    public CepFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View CepView = inflater.inflate(R.layout.activity_endereco, container, false);

      /*  final EditText eCep = CepView.findViewById(R.id.etCep);
        // final TextView end = findViewById(R.id.txtEnd);
        // final TextInputLayout tlRua = findViewById(R.id.tilRua);
        final TextInputEditText rua = CepView.findViewById(R.id.etRua);
        final TextInputEditText bairro = CepView.findViewById(R.id.etBairro);
        final TextInputEditText cidade = CepView.findViewById(R.id.etCity);
        final TextInputEditText complemento = CepView.findViewById(R.id.etComplemento);
        final TextInputEditText estado = CepView.findViewById(R.id.etUf);*/



       Button addCep = CepView.findViewById(R.id.btnCep);
       Button addEnd = CepView.findViewById(R.id.btnRetornar);
       addEnd.setOnClickListener(this);
       addCep.setOnClickListener(this);
       setarEnd = getActivity().findViewById(R.id.btnBsc);

        return CepView;


    }

    public void retornarCep(){

        final EditText eCep = getActivity().findViewById(R.id.etCep);
        // final TextView end = findViewById(R.id.txtEnd);
        // final TextInputLayout tlRua = findViewById(R.id.tilRua);
        final TextInputEditText rua = getActivity().findViewById(R.id.etRua);
        final TextInputEditText bairro = getActivity().findViewById(R.id.etBairro);
        final TextInputEditText cidade = getActivity().findViewById(R.id.etCity);
        final TextInputEditText complemento = getActivity().findViewById(R.id.etComplemento);
        final TextInputEditText estado = getActivity().findViewById(R.id.etUf);
       // final TextInputEditText local = getActivity().findViewById(R.id.etLocal);
       // final TextInputEditText numero = getActivity().findViewById(R.id.etNumero);


        if (eCep.getText().toString().length() > 0 && !eCep.getText().toString().equals("") && eCep.getText().toString().length() == 8){
            HTTPService service = new HTTPService(eCep.getText().toString());
            try {
                CEP retorno = service.execute().get();
                //teste = retorno.toString();
                if (retorno.toString() != "" || retorno.toString() != null || !retorno.toString().equals("")) {
                    //  end.setText(retorno.toString());
                    if (!retorno.getLogradouro().equals("")) {
                        rua.setText(retorno.getLogradouro());
                        rua.setEnabled(false);
                        nomeRua = retorno.getLogradouro();
                    }
                    if (!retorno.getBairro().equals("")) {
                        bairro.setText(retorno.getBairro());
                        bairro.setEnabled(false);
                    }
                    if (!retorno.getLocalidade().equals("")) {
                        cidade.setText(retorno.getLocalidade());
                        cidade.setEnabled(false);
                    }
                            if (!retorno.getComplemento().equals("")) {
                                complemento.setText(retorno.getComplemento());
                                complemento.setEnabled(false);
                            }
                    if (!retorno.getUf().equals("")) {
                        estado.setText(retorno.getUf());
                        estado.setEnabled(false);
                    }

                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void retornar(){

        local = getActivity().findViewById(R.id.tetLocal);
        final EditText eCep = getActivity().findViewById(R.id.etCep);
        // final TextView end = findViewById(R.id.txtEnd);
        // final TextInputLayout tlRua = findViewById(R.id.tilRua);
        final TextInputEditText rua = getActivity().findViewById(R.id.etRua);
        final TextInputEditText bairro = getActivity().findViewById(R.id.etBairro);
        final TextInputEditText cidade = getActivity().findViewById(R.id.etCity);
        final TextInputEditText complemento = getActivity().findViewById(R.id.etComplemento);
        final TextInputEditText estado = getActivity().findViewById(R.id.etUf);
        final TextInputEditText numeroET = getActivity().findViewById(R.id.etNumero);

        if (eCep.getText().toString().equals("")){
            eCep.setError("Preencha o CEP do logradouro");
        }
        if (rua.getText().toString().equals("")){
            rua.setError("Preencha o endereço do logradouro");
        }
        if (bairro.getText().toString().equals("")){
            bairro.setError("Preencha o bairro do logradouro");
        }
        if (cidade.getText().toString().equals("")){
            cidade.setError("Preencha a cidade do logradouro");
        }
        if (estado.getText().toString().equals("")){
            estado.setError("Preencha o estado do logradouro");
        }
        if (numeroET.getText().toString().equals("")){
            numeroET.setError("Preencha o número do logradouro");
        }
        if (local.getText().toString().equals("")){
            local.setError("Preencha o apelido do local");
        }
        if (!eCep.getText().toString().equals("") && !rua.getText().toString().equals("") && !bairro.getText().toString().equals("") &&
                !cidade.getText().toString().equals("") && !estado.getText().toString().equals("") &&
                !numeroET.getText().toString().equals("") && !local.getText().toString().equals("")) {

           /* AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
            dialog.create();
            dialog.setMessage("Preencha todos os campos para prosseguir!");
            dialog.show();*/
            local.setAllCaps(true);
            tipoCasa = local.getText().toString();
            tipoCasa = tipoCasa.toUpperCase();
            numero = numeroET.getText().toString();
            setarEnd.setAllCaps(false);
            setarEnd.setTextColor(Color.BLACK);
            // setarEnd.setClickable(false);
            setarEnd.setGravity(0);
            setarEnd.setText("\n\t" + "\tEndereço adicionado: \n" + "    " + tipoCasa + " - " + nomeRua + ", " + numero + "\n");
            ((cadastro) getActivity()).irCad(0);
        }else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
            dialog.create();
            dialog.setMessage("Preencha todos os campos para prosseguir!");
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRetornar:
                retornar();
                break;
            case R.id.btnCep:
                retornarCep();
                break;
        }
    }
}
