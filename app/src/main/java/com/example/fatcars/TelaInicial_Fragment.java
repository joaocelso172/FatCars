package com.example.fatcars;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class TelaInicial_Fragment extends Fragment {

    Login login;
    Button logar;
    Button encontrarCarro;


    public TelaInicial_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tela_inicial_fragment, container, false);
        logar = v.findViewById(R.id.btnLogInicial);
        encontrarCarro = v.findViewById(R.id.btnFindCarro);

        encontrarCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarTela();
            }
        });

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mudarLogin();
            }
        });


        return v;
    }

    public void mudarTela () {
        Intent Mudar = new Intent(getContext(), reservar.class);
        startActivity(Mudar);
    }

    public void mudarLogin (){
        login = new Login();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.constraintConteudo, login);
        transaction.commit();

    }

}
