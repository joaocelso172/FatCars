package com.example.fatcars;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.fatcars.Fragments.CadastroFragment;
import com.example.fatcars.Fragments.CepFragment;
import com.example.fatcars.Fragments.testFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class cadastro extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private ViewPager vPager;
    private SmartTabLayout STL;
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
    private TextInputLayout ende;
    private String ruaExport;
    private TextInputEditText etEnde;

    public String getRuaExport() {
        return ruaExport;
    }

    public void setRuaExport(String ruaExport) {
        this.ruaExport = ruaExport;
    }
    //private static final String ARQUIVO_DADOS = "ArquivoDados";
   /* public void Perfil(View view) {
        cpfdados = findViewById(R.id.inputCPF);
        Pnome = findViewById(R.id.etNome);
        Snome = findViewById(R.id.etSnome);
        CNH = findViewById(R.id.etCNH);
        Nickname = findViewById(R.id.etUser);
        Pass = findViewById(R.id.etPass);
        dataNascimento = findViewById(R.id.etDate);


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

            Intent mudarTelaLogin = new Intent(this, telaLogin.class);
            startActivity(mudarTelaLogin);
           Toast.makeText(getApplicationContext(), "Cadastro criado com sucesso!", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(getApplicationContext(), "Revise os campos", Toast.LENGTH_SHORT).show();
    }*/

   /* public void Inicio(View view){
        Intent irInicio = new Intent(this, MainActivity.class);
        startActivity(irInicio);
    }*/


   /* TextView Nome = (TextView) findViewById(R.id.editNome);
    TextView Sobrenome = (TextView) findViewById(R.id.editSobrenome);
    TextView Senha = (TextView) findViewById(R.id.editPass);
    TextView Nascimento = (TextView) findViewById(R.id.editDate);
    TextView Cpf = (TextView) findViewById(R.id.editCpf);
    TextView Cnh = (TextView) findViewById(R.id.editCnh);
    TextView Endereco = (TextView) findViewById(R.id.editEnd);
    TextView Email = (TextView) findViewById(R.id.editEmail);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Toast.makeText(getApplicationContext(), "Oncreate", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        vPager = findViewById(R.id.viewpager);
        STL = findViewById(R.id.viewpagertab);

      /*  FragmentPagerItemAdapter vAdapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Endereço", CadastroFragment.class)
                        .add("Teste", endereco.class)
                        .create()
        );*/

        FragmentPagerItemAdapter vAdapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Dados", CadastroFragment.class)
                        .add("Endereço", CepFragment.class)
                        .create()
        );

        vPager.setAdapter( vAdapter );
        STL.setViewPager(vPager);


      /*  toggleTipoPessoa = findViewById(R.id.toggleTipo);
        nome = findViewById(R.id.editNome);
        sobrenome = findViewById(R.id.editSobrenome);
       // email = findViewById(R.id.editEmail);
        user = findViewById(R.id.editUser);
        dataNasc = findViewById(R.id.editDate);
        Cpf = findViewById(R.id.editCpf);
        cnh = findViewById(R.id.editCnh);
        cad = findViewById(R.id.btnCadastrar);
        nomeEmpresa = findViewById(R.id.editNE);
        TestandoLay = findViewById(R.id.laytest);*/
       // Documento = findViewById(R.id.inputCPF);
        //etEnde = findViewById(R.id.etEnd);

       // CEP cep = new CEP();


    }

    public void irCad(int pageNumber) {
        vPager.setCurrentItem(0);
    }

    public void irCep(int pageNumber) {
        vPager.setCurrentItem(1);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }




    /*public void mudarDados(View view) {
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
    }*/

    public class dadosCadastrais{

        public dadosCadastrais(String nome, String sobrenome, String senha, String email, String dNascimento, String CPF, String CNH, String endereco){
            nome = "João Celso";
            sobrenome = "Ferraz da Silva";
            senha = "pimNota10";
            dNascimento = "23/08/1999";
            CPF = "47284302860";
            CNH = "16282815";
            endereco = "Rua Dias de Aguiar, 101";
            email = "joaocelso172@gmail.com";

        }
        public dadosCadastrais(String nome, String sobrenome,String senha, String email){
            nome = nome;
            sobrenome = sobrenome;
            senha = senha;
            email = email;
        }

    }



}
