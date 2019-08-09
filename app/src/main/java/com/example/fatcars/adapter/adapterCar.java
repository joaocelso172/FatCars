package com.example.fatcars.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fatcars.R;
import com.example.fatcars.model.Carro;
import com.example.fatcars.model.layout;

import org.w3c.dom.Text;

import java.util.List;

public class adapterCar extends RecyclerView.Adapter<adapterCar.MyViewHolder> {


    private List <Carro> listaCarros;
    public adapterCar(List<Carro> Lista) {
        this.listaCarros = Lista;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View CarroLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_carro, viewGroup, false);
        return new MyViewHolder(CarroLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Carro carro = listaCarros.get(i);
        myViewHolder.Marca.setText(carro.getMarca());
        myViewHolder.Modelo.setText(carro.getModelo());
        myViewHolder.Ano.setText(carro.getAno());
        myViewHolder.modeloFoto.setImageResource(carro.getModeloCar());
        //onclick
       // myViewHolder.proprietario.setText(carro.getProprietario());
        myViewHolder.local.setText(carro.getLocal());
        //myViewHolder.km.setText(carro.getKilometragem());
        myViewHolder.preco.setText("R$" + carro.getPreço());
    }

    @Override
    public int getItemCount() {
        return listaCarros.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Marca;
        TextView Modelo;
        TextView Ano;
        TextView local;
        TextView preco;
        ImageView modeloFoto;

        public MyViewHolder(View itemView) {
            super(itemView);

            Marca = itemView.findViewById(R.id.textMarca);
            Modelo = itemView.findViewById(R.id.textModelo);
            Ano = itemView.findViewById(R.id.textAno);
            modeloFoto = itemView.findViewById(R.id.imageModelo);
            local = itemView.findViewById(R.id.textLocal);
            preco = itemView.findViewById(R.id.textPreco);



        }
    }


}
