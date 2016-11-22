package app.com.magentastudio.momapp.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import app.com.magentastudio.momapp.Controller.ArtistaController;
import app.com.magentastudio.momapp.Model.Artista;
import app.com.magentastudio.momapp.R;
import app.com.magentastudio.momapp.Util.ResultListener;
import app.com.magentastudio.momapp.View.AdapterArtista;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterArtista adapterArtista;
    SwipeRefreshLayout pullToRefresh;
    ArtistaController artistaController;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        context = this;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        pullToRefresh = (SwipeRefreshLayout) findViewById(R.id.pullToRefresh);


        adapterArtista = new AdapterArtista(getApplicationContext());
        recyclerView.setAdapter(adapterArtista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);



        ArtistaController artistaController = new ArtistaController();


        update();

    }

    pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            update();
        }
    });




    private void update() {

        pullToRefresh.setRefreshing(true);

        artistaController.getArtistasList(new ResultListener<List<Artista>>() {
            @Override
            public void finish(List<Artista> resultado) {


                adapterArtista.setListaDeArtistas(resultado);


                adapterArtista.notifyDataSetChanged();


                pullToRefresh.setRefreshing(false);
            }
        }, context);
    }
}
