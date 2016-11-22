package app.com.magentastudio.momapp.View;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.com.magentastudio.momapp.Model.Artista;

/**
 * Created by Diagnostifo on 22/11/2016.
 */

public class AdapterArtista {
    List<Artista> listaDeArtistas;
    Context context;


    public AdapterArtista(Context context) {
        this.context = context;
        this.listaDeArtistas = new ArrayList<>();
    }


    public List<Artista> getListaDeArtistas() {
        return listaDeArtistas;
    }

    public Context getContext() {
        return context;
    }

    public void setListaDeArtistas(List<Artista> listaDeArtistas) {
        this.listaDeArtistas = listaDeArtistas;
    }


}