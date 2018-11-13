package movietheatersystem;

import java.util.Scanner;

public class ListaPeliculas {

    Pelicula inicio, fin;
    Metodos m = new Metodos();
    
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
        String nombre = "", genero = "", director = "";
        int duracion = 0;
        System.out.print("Nombre");
        nombre = m.entradaTexto();
        if (this.buscarPorNombre(nombre) == null) {
            System.out.print("Genero");
            genero = m.entradaTexto();
            System.out.print("Director");
            director = m.entradaTexto();
            System.out.print("duracion");
            duracion = m.entradaEntero();
            this.agregarFinal(new Pelicula(nombre, genero, director, duracion));
        } else {
            System.out.println("Esa pelicula ya existe.");
        }
    }

    public void eliminarPelicula() {
        String nombre;
        Pelicula eliminar;
        System.out.print("Nombre");
        nombre = m.entradaTexto();
        if ((eliminar = this.buscarPorNombre(nombre)) != null) {
            eliminar.getAtras().setSigue(eliminar.getSigue());
            eliminar.getSigue().setAtras(eliminar.getAtras());
        }
        System.out.println("Eliminado");
    }
    public void mostrarPeliculas() {
        if (this.vacia()) {
            System.out.println("No hay peliculas registradas.");
        } else {
            Pelicula aux = this.inicio;
            System.out.printf("%-20s", "Nombre");
            System.out.printf("%-20s", "Director");
            System.out.printf("%-10s", "Genero");
            System.out.printf("%-4s", "Duración");
            System.out.println();
            while (aux != null) {
                System.out.printf("%-20s", aux.getNombre());
                System.out.printf("%-20s", aux.getDirector());
                System.out.printf("%-10s", aux.getGenero());
                System.out.printf("%-4s", aux.getDuracion());
                System.out.println();
                aux = aux.getSigue();
            }
        }
    }

    public boolean vacia() {
        return this.inicio == null;
    }

}
