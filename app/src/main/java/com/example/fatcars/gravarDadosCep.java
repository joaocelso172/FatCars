package com.example.fatcars;

import android.content.Context;
import android.content.SharedPreferences;

public class gravarDadosCep {

    private Context contexto;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "cadastro.pref";
    private final String CHAVE_NOME = "nome";

    public gravarDadosCep(Context c) {
        this.contexto = c;
        pref = contexto.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = pref.edit();
    }

    public String recuperarDados(){
        return "";
    }
    public void salvarDados(String dados){
        editor.putString(CHAVE_NOME, dados);
        editor.commit();
    }
}


