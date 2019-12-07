package com.example.fatcars;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class Login extends Fragment{

    EditText email;
    TextView cadastrar;
    Button entrar;
    public static boolean logado = false;
    public static String historicoActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_login, container, false);

        email = v.findViewById(R.id.etLog);
        cadastrar = v.findViewById(R.id.txtCadastro);
        entrar = v.findViewById(R.id.btnEntrarLog);
    //    entrar.setVisibility(View.GONE);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarCadastro();
            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logar();
            }
        });



        return v;
    }

    public void mudarCadastro (){
        Intent cadastrar = new Intent(getContext(), cadastro.class);
        startActivity(cadastrar);
    }

    public void Logar (){
      /*  if (historicoActivity.equals("")){
            Intent logar = new Intent(getContext(), telaLogin.class);
            logar.putExtra("email", email.getText().toString());
            startActivity(logar);
            Toast.makeText(getContext(), "Logado com sucesso!", Toast.LENGTH_SHORT).show();
            logado = true;
        }else {*/
     //  getActivity().getSupportFragmentManager().popBackStack();
        getActivity().getFragmentManager().popBackStack();
     //   FragmentManager fm = getFragmentManager();
       // fm.popBackStack("teste");
        // }
    }

}
