package movietheatersystem;

import java.util.Scanner;

public class ListaPeliculas {

    Pelicula inicio, fin;
    Metodos m = new Metodos();

    public ListaPeliculas(Pelicula inicio, Pelicula fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public Pelicula getInicio() {
        return inicio;
    }

    public Pelicula getFin() {
        return fin;
    }

    public void setInicio(Pelicula inicio) {
        this.inicio = inicio;
    }

    public void setFin(Pelicula fin) {
        this.fin = fin;
    }

    private void agregarFinal(Pelicula nuevo) {
        if (this.vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            nuevo.setSigue(this.inicio);
            this.inicio.setAtras(nuevo);
            this.inicio = nuevo;
        }
    }

    public Pelicula buscarPorNombre(String nombre) {
        Pelicula aux = this.inicio;
        while (aux != null) {
            if (aux.getNombre().equals(nombre)) {
                return aux;
            }
            aux = aux.getSigue();
        }
        return null;
    }

    public void agregarPelicula() {
        String nombre = m.entradaTexto();
        if (this.buscarPorNombre(nombre) != null) {
            
        }
    }

    public boolean vacia() {
        return this.inicio == null;
    }

}
