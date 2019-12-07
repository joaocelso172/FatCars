package com.example.fatcars;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Login login;
    private TelaInicial_Fragment telaInicial_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


           // Intent Mudar = new Intent(this, catalogo.class);
           //startActivity(Mudar);


        //Intent intent = new Intent(this, catalogo.class);
       // startActivity(intent);

        telaInicial_fragment = new TelaInicial_Fragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.constraintConteudo, telaInicial_fragment)
                .addToBackStack("Fragment").commit();

      //  Toast.makeText(getApplicationContext(), getFragmentManager().getBackStackEntryCount(), Toast.LENGTH_SHORT).show();


    }

}
