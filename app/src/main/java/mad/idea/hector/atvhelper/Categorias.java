package mad.idea.hector.atvhelper;

/**
 * Created by Noelia on 02/04/2016.
 */
public class Categorias {
    public String name;
    public String descripcion;
    public String titulo;
    public int photoId;

    public Categorias(String name, String descripcion, int photoId) {
        this.name = name;
        this.descripcion = descripcion;
        this.photoId = photoId;
    }
    public Categorias(String name, String descripcion, String titulo) {
        this.name = name;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }
}

