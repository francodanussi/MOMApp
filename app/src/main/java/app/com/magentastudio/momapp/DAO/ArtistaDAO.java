package app.com.magentastudio.momapp.DAO;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.util.List;

import app.com.magentastudio.momapp.Model.Artista;
import app.com.magentastudio.momapp.Model.ArtistaContainer;
import app.com.magentastudio.momapp.Util.DAOException;
import app.com.magentastudio.momapp.Util.HTTPConnectionManager;
import app.com.magentastudio.momapp.Util.ResultListener;

/**
 * Created by Diagnostifo on 22/11/2016.
 */

public class ArtistaDAO {

    public void getArtistasFromWeb(final ResultListener<List<Artista>> listener) {

        RetrieveArtistasTask retrieveArtistasTask = new RetrieveArtistasTask(listener);
        retrieveArtistasTask.execute();
    }

    class RetrieveArtistasTask extends AsyncTask<String, Void, List<Artista>> {

        private ResultListener<List<Artista>> listener;

        public RetrieveArtistasTask(ResultListener<List<Artista>> listener) {
            this.listener = listener;
        }

        @Override
        protected List<Artista> doInBackground(String... params) {

            HTTPConnectionManager connectionManager = new HTTPConnectionManager();
            String input = null;

            try {
                input = connectionManager.getRequestString("");
            } catch (DAOException e) {
                e.printStackTrace();
            }

           Gson gson = new Gson();
            ArtistaContainer artistaContainer = gson.fromJson(input, ArtistaContainer.class);

            return artistaContainer.getListaDeArtistas();
        }


        @Override
        protected void onPostExecute(List<Artista> listaDeArtistas) {

            this.listener.finish(listaDeArtistas);
        }
    }
}
