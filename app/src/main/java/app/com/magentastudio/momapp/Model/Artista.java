package app.com.magentastudio.momapp.Model;

import java.util.List;

/**
 * Created by Diagnostifo on 22/11/2016.
 */

public class Artista {
    private String name;
    private List<Obra> obrasDelArtista;

    public List<Obra> getObrasDelArtista() {
        return obrasDelArtista;
    }

    public void setObrasDelArtista(List<Obra> obrasDelArtista) {
        this.obrasDelArtista = obrasDelArtista;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Obra {

    private String title;
    private int workImage;

}
