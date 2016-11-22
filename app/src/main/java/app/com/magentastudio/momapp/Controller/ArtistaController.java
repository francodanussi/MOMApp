package app.com.magentastudio.momapp.Controller;

import android.content.Context;

import java.util.List;

import app.com.magentastudio.momapp.DAO.ArtistaDAO;
import app.com.magentastudio.momapp.Model.Artista;
import app.com.magentastudio.momapp.Util.HTTPConnectionManager;
import app.com.magentastudio.momapp.Util.ResultListener;

/**
 * Created by Diagnostifo on 22/11/2016.
 */

public class ArtistaController {

    public void getArtistasList(final ResultListener<List<Artista>> listenerDeLaView, Context context) {
        ArtistaDAO artistaDAO = new ArtistaDAO();

        if (HTTPConnectionManager.isNetworkingOnline(context)) {
            artistaDAO.getArtistasFromWeb(new ResultListener<List<Artista>>() {
                @Override
                public void finish(List<Artista> resultado) {
                    listenerDeLaView.finish(resultado);
                }
            });
        }
       /* else{
            //CASO OFFLINE: Solicito al DAO la lista de POST que esta almacenada en la base de datos
            List<Artista> aristasList = ArtistaDAO.getAllPostsFromDatabase();

            //Le aviso al listener de la vista que ya tengo la lista.
            listenerDeLaView.finish(listaDeArtistas);
        }
    }*/
    }
}
