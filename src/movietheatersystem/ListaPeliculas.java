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
            this.fin.setSigue(nuevo);
            this.fin = nuevo;
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

    public int posicion(Pelicula pelicula) {
        //regresa 0 si es unico elemento, 1 si está al inicio
        // 2 si está en medio y 3 si es el último elemento.
        if (pelicula == this.inicio && pelicula == this.fin) {
            return 0;
        }
        if (pelicula.getAtras() != null && pelicula.getSigue() != null) {
            return 2;
        }
        if (pelicula.getAtras() != null) {
            return 1;
        }
        return 3;
    }

    private void eliminarUnico() {
        this.fin = null;
        this.inicio = null;
    }

    private void elimnarInicio(Pelicula eliminar) {
        this.inicio = eliminar.getSigue();
    }

    private void eliminarEnMedio(Pelicula eliminar) {
        System.out.println("aqui");
        eliminar.getAtras().setSigue(eliminar.getSigue());
        eliminar.getSigue().setAtras(eliminar.getAtras());
    }

    private void eliminarFin(Pelicula eliminar) {
        eliminar.setAtras(null);
        this.fin.setSigue(null);
    }

    public void eliminarPelicula() {
        String nombre;
        System.out.print("Nombre");
        nombre = m.entradaTexto();
        Pelicula eliminar = this.buscarPorNombre(nombre);
        if (eliminar != null) {
            switch (this.posicion(eliminar)) {
                // Mediante metodo posicion retorna entero, 0, 1, 2 y 3
                case 0:
                    this.eliminarUnico();
                    break;
                case 1:
                    this.elimnarInicio(eliminar);
                    break;
                case 2:
                    this.eliminarEnMedio(eliminar);
                    break;
                case 3:
                    this.eliminarFin(eliminar);
            }
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
