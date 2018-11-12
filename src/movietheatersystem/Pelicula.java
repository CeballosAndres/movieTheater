package movietheatersystem;
public class Pelicula {
    private Pelicula sigue;
    private Pelicula atras;
    
    private String nombre;
    private String genero;
    private String director;
    int duracion; //minutos

    public Pelicula(String nombre, String genero, String director, int duracion) {
        this.sigue = null;
        this.atras = null;
        this.nombre = nombre;
        this.genero = genero;
        this.director = director;
        this.duracion = duracion;
    }
    
    public void setSigue(Pelicula sigue) {
        this.sigue = sigue;
    }

    public void setAtras(Pelicula atras) {
        this.atras = atras;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Pelicula getSigue() {
        return sigue;
    }

    public Pelicula getAtras() {
        return atras;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }
    
    
    
}
