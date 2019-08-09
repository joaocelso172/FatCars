package com.example.fatcars.lista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.example.fatcars.MainActivity;
import com.example.fatcars.R;
import com.example.fatcars.RecyclerItemClickListener;
import com.example.fatcars.adapter.adapterCar;
import com.example.fatcars.adapter.informCarro;
import com.example.fatcars.adapter.informLateral;
import com.example.fatcars.model.Carro;

import java.util.ArrayList;
import java.util.List;

import static com.example.fatcars.adapter.informCarro.anoFab;
import static com.example.fatcars.adapter.informCarro.fotoCarro;
import static com.example.fatcars.adapter.informCarro.montadora;
import static com.example.fatcars.adapter.informCarro.nomeCarro;
import static com.example.fatcars.adapter.informCarro.valor;

public class listaCarros extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public void informacao(View view) {
        Intent inf = new Intent(getApplicationContext(), informLateral.class);
        startActivity(inf);
        informCarro.desligarBot = false;
    }
    // public static boolean Exibir = false;

    private RecyclerView recCarros;
    private List<Carro> listaCarros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esperoq_de);
        //layoutmanager
        recCarros = findViewById(R.id.RecyclerCarros);

        //this.criarCarros();
        //config
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recCarros.setLayoutManager(layoutManager);
        //adapter
        adapterCar adapter = new adapterCar(listaCarros);
        recCarros.setAdapter(adapter);
        recCarros.setHasFixedSize(true);
        recCarros.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recCarros.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), recCarros,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Carro carrinho = listaCarros.get(position);
                                nomeCarro = carrinho.getModelo();
                                montadora = carrinho.getMarca();
                                anoFab = carrinho.getAno();
                                fotoCarro = carrinho.getModeloCar();
                                valor = carrinho.getPreço();
                                Intent fdsfs = new Intent(getApplicationContext(), informLateral.class);
                                startActivity(fdsfs);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );


        this.criarCarros();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Aqui vai o teste", Snackbar.LENGTH_LONG)
                        .setAction("OUTRO", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.esperoq_de, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
public void home (){
        Intent casa = new Intent(this, MainActivity.class);
        startActivity(casa);
}

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navHome) {
            home();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void criarCarros(){
        Carro car = new Carro("Audi", "A3", "2018", R.drawable.a32018, true, "380,00","São Paulo");
        this.listaCarros.add(car);
        car = new Carro("Fiat", "Uno Vivace", "2018", R.drawable.uno, true, "190,00", "São Paulo");
        this.listaCarros.add(car);
        car = new Carro("Honda", "New Civic", "2017", R.drawable.civic, true, "385,00", "São Paulo");
        this.listaCarros.add(car);
        car = new Carro("Honda", "Fit", "2016", R.drawable.fit, true, "235,00", "São Paulo");
        this.listaCarros.add(car);
        car = new Carro("Fiat", "Siena", "2015", R.drawable.siena, true, "210,00", "Rio de Janeiro");
        this.listaCarros.add(car);
        car = new Carro("Toyota", "Corolla", "2014", R.drawable.corolla, true, "335,00", "Rio de Janeiro");
        this.listaCarros.add(car);
    }
}
