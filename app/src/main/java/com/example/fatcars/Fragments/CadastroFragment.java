package com.example.fatcars.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.fatcars.R;
import com.example.fatcars.cadastro;
import com.example.fatcars.gravarDadosCep;
import com.example.fatcars.telaLogin;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroFragment extends Fragment implements View.OnClickListener{

    private gravarDadosCep preferencias;
    private ToggleButton toggleTipoPessoa;
    private TextInputLayout nome;
    private TextInputLayout sobrenome;
    // private TextInputLayout email;
    private TextInputLayout user;
    private TextInputLayout dataNasc;
    private TextInputLayout Cpf;
    private TextInputLayout cnh;
    private TextInputLayout nomeEmpresa;
    // private TextInputEditText Documento;
    private Button cad;
    private LinearLayout TestandoLay;
    private TextInputEditText cpfdados;
    private TextInputEditText Pnome;
    private TextInputEditText Snome;
    private TextInputEditText CNH;
    private TextInputEditText Nickname;
    private TextInputEditText Pass;
    private TextInputEditText dataNascimento;
    private TextView cep;


    public CadastroFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cadastro, container, false);

        preferencias = new gravarDadosCep(getContext());
            cpfdados = v.findViewById(R.id.inputCPF);
            Pnome = v.findViewById(R.id.etNome);
            Snome = v.findViewById(R.id.etSnome);
            CNH = v.findViewById(R.id.etCNH);
            Nickname = v.findViewById(R.id.etUser);
            Pass = v.findViewById(R.id.etPass);
            dataNascimento = v.findViewById(R.id.etDate);


        toggleTipoPessoa = v.findViewById(R.id.toggleTipo);
        nome = v.findViewById(R.id.editNome);
        sobrenome = v.findViewById(R.id.editSobrenome);
        // email = findViewById(R.id.editEmail);
        user = v.findViewById(R.id.editUser);
        dataNasc = v.findViewById(R.id.editDate);
        Cpf = v.findViewById(R.id.editCpf);
        cnh = v.findViewById(R.id.editCnh);
        cad = v.findViewById(R.id.btnCadastrar);
        nomeEmpresa = v.findViewById(R.id.editNE);
        TestandoLay = v.findViewById(R.id.laytest);
        cep = v.findViewById(R.id.btnBsc);

       cep.setOnClickListener(this);
        cad.setOnClickListener(this);
        toggleTipoPessoa.setOnClickListener(this);

        return v;
       // btnCadastrar

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        String texto = Pnome.getText().toString();
        Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        if (!texto.equals("")){
            preferencias.salvarDados(texto);
            Toast.makeText(getContext(), texto, Toast.LENGTH_SHORT).show();
        }
    }

    public void mudarDados() {
        if (toggleTipoPessoa.isChecked()) {
            TestandoLay.setVisibility(View.GONE);
            nome.setVisibility(View.GONE);
            // email.setVisibility(View.GONE);
            nomeEmpresa.setVisibility(View.VISIBLE);
            //email.setVisibility(View.VISIBLE);
            sobrenome.setVisibility(View.GONE);
            user.setHint("Nome de usuario empresarial");
            dataNasc.setVisibility(View.GONE);
            Cpf.setHint("CNPJ");
            cnh.setVisibility(View.GONE);
            cad.setText("Cadastrar empresa");
        } else {
            TestandoLay.setVisibility(View.VISIBLE);
            nomeEmpresa.setVisibility(View.GONE);
            nome.setVisibility(View.VISIBLE);
            sobrenome.setVisibility(View.VISIBLE);
            user.setHint("Nome de usuario");
            dataNasc.setVisibility(View.VISIBLE);
            Cpf.setHint("CPF");
            cnh.setVisibility(View.VISIBLE);
            cad.setText("Cadastrar usuário");
        }

    }

    public void mTela(){

    }

    public void buscar (){
       // Intent buscarCep = new Intent(getContext(), cadastro.class);
        // onDestroy();
       // startActivity(buscarCep);
        //onPause();
        ((cadastro) getActivity()).irCep(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBsc:
                buscar();
                break;
            case R.id.btnCadastrar:
                String Nome = Pnome.getText().toString();
                String SNome = Snome.getText().toString();
                String cnh = CNH.getText().toString();
                String nomeUser = Nickname.getText().toString();
                String senha = Pass.getText().toString();
                String date = dataNascimento.getText().toString();
                String CPFME = cpfdados.getText().toString();
                int dadosValidos = 0;


                if (Nome.equals("")){
                    Pnome.setError("Insira um nome válido");
                    dadosValidos = 0;
                }else dadosValidos++;
                if (SNome.equals("")){
                    Snome.setError("Insira um sobrenome válido");
                    dadosValidos = 0;
                }else dadosValidos++;
                if (cnh.equals("")){
                    CNH.setError("Insira uma CNH válida");
                    dadosValidos = 0;
                }else dadosValidos++;
                if (nomeUser.equals("")){
                    Nickname.setError("Insira um nome de usuário válido");
                    dadosValidos = 0;
                }else dadosValidos++;
                if (senha.equals("")){
                    Pass.setError("Insira uma senha válida");
                    dadosValidos = 0;
                }else dadosValidos++;
                if (CPFME.equals("")) {
                    cpfdados.setError("Insira um CPF valido");
                    dadosValidos = 0;
                }else dadosValidos++;

                if (dadosValidos == 6){

                    Intent mudarLogin = new Intent(getContext(), telaLogin.class);
                    startActivity(mudarLogin);
                    Toast.makeText(getContext(), "Cadastro criado com sucesso!", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(getContext(), "Revise os campos", Toast.LENGTH_SHORT).show();
                break;

            case R.id.toggleTipo:
                mudarDados();
                break;
        }
    }
}

