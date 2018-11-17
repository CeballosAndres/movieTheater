package movietheatersystem;

import java.util.Scanner;

public class ListaPeliculas {

    Util util = new Util();
    Pelicula inicio, fin;
    
    public int cantidadPeliculas(){
     Pelicula aux = this.inicio;
     int i = 0;
        while (aux != null) {
            i++;
            aux = aux.getSigue();
        }
        return i;
    }

    public ListaPeliculas() {
        this.inicio = null;
        this.fin = null;
      
    }

    public void setInicio(Pelicula inicio) {
        this.inicio = inicio;
    }

    private void agregarFinal(Pelicula nuevo) {
        if (this.vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            nuevo.setAtras(this.fin);
            this.fin.setSigue(nuevo);
            this.fin = nuevo;
        }
       
    }

    public Pelicula buscarPorNombre(String nombre) {
        Pelicula aux = this.inicio;
        while (aux != null) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                return aux;
            }
            aux = aux.getSigue();
        }
        return null;
    }

    public Pelicula buscarPorPosicion(int index) {
        Pelicula aux = this.inicio;
        int i = 1;
        while (aux != null) {
            if (i == index) {
                return aux;
            }
            i++;
            aux = aux.getSigue();
        }
        return null;

    }

    public void agregarPelicula() {
        String nombre = "", genero = "", director = "";
        int duracion = 0;
        System.out.print("Nombre");
        nombre = util.inputText();
        if (this.buscarPorNombre(nombre) == null) {
            System.out.print("Genero");
            genero = util.inputText();
            System.out.print("Director");
            director = util.inputText();
            System.out.print("duracion");
            duracion = util.inputInteger();
            this.agregarFinal(new Pelicula(nombre, genero, director, duracion));
        } else {
            System.out.println("Esa pelicula ya existe.");
        }
    }

    public int posicion(Pelicula pelicula) {
        //regresa 0 si es unico elemento, 1 si está al inicio
        // 2 si está en medio y 3 si es el último elemento.
        if (this.inicio == this.fin) {
            return 0;
        }
        if (pelicula == this.inicio) {
            return 1;
        }
        if (pelicula.getAtras() != null && pelicula.getSigue() != null) {
            return 2;
        }
        return 3;
    }

    private void eliminarUnico() {
        this.fin = null;
        this.inicio = null;
    }

    private void elimnarInicio() {
        this.inicio = this.inicio.getSigue();
        this.inicio.setAtras(null);
    }

    private void eliminarEnMedio(Pelicula eliminar) {
        eliminar.getAtras().setSigue(eliminar.getSigue());
        eliminar.getSigue().setAtras(eliminar.getAtras());
    }

    private void eliminarFin() {
        this.fin = this.fin.getAtras();
        this.fin.setSigue(null);
    }

    public void eliminarPelicula() {
        String nombre;
        System.out.print("Nombre de pelicula a eliminar");
        nombre = util.inputText();
        Pelicula eliminar = this.buscarPorNombre(nombre);
        if (eliminar != null) {
            System.out.println("");
            eliminar.labelPeliculas();
            eliminar.mostrar();
            System.out.print("\n¿Seguro de eliminar esta pelicula?[S/s]");
            char opc = util.entradaChar();
            if (Character.toLowerCase(opc) == 's') {
                switch (this.posicion(eliminar)) {
                    // Mediante metodo posicion retorna entero, 0, 1, 2 y 3
                    case 0:
                        this.eliminarUnico();
                        break;
                    case 1:
                        this.elimnarInicio();
                        break;
                    case 2:
                        this.eliminarEnMedio(eliminar);
                        break;
                    case 3:
                        this.eliminarFin();
                }
                
                System.out.println("Eliminada exitosamente!");
            } else {
                System.out.println("No se ha eliminado el elemento.");
            }
        } else {
            System.out.println("Pelicula no encontrada.");
        }
    }

    public void modificarPelicula() {
        System.out.print("Nombre de pelicula a modificar");
        String nombre = util.inputText();
        Pelicula modificar = this.buscarPorNombre(nombre);
        if (modificar != null) {
            boolean flag = false;
            String text;
            System.out.println("");
            modificar.labelPeliculas();
            modificar.mostrar();
            System.out.println("\nEscribir nuevos valores para modificar:");
            System.out.print(modificar.getNombre());
            text = util.inputText();
            if (!text.equalsIgnoreCase("")) {
                modificar.setNombre(text);
                flag = true;
            }
            System.out.print(modificar.getDirector());
            text = util.inputText();
            if (!text.equalsIgnoreCase("")) {
                modificar.setDirector(text);
                flag = true;
            }
            System.out.print(modificar.getGenero());
            text = util.inputText();
            if (!text.equalsIgnoreCase("")) {
                modificar.setGenero(text);
                flag = true;
            }
            System.out.print(modificar.getDuracion());
            text = util.inputText();
            if (!text.equalsIgnoreCase("")) {
                modificar.setDuracion(Integer.valueOf(text));
                flag = true;
            }
            if (flag) {
                System.out.println("\nPelicula modificada:");
                modificar.labelPeliculas();
                modificar.mostrar();
            } else {
                System.out.println("No se modifico " + modificar.getNombre());
            }
        } else {
            System.out.println("Pelicula no encontrada.");
        }
    }

    public void mostrarPeliculas() {
        if (this.vacia()) {
            System.out.println("No hay peliculas registradas.");
        } else {
            Pelicula aux = this.inicio;
            aux.labelPeliculas();
            while (aux != null) {
                aux.mostrar();
                aux = aux.getSigue();
            }
        }
    }

    public void mostrarPeliculasNombre() {
        if (this.vacia()) {
            System.out.println("No hay peliculas registradas.");
        } else {
            Pelicula aux = this.inicio;
            System.out.println();
            int i = 1;
            while (aux != null) {
                System.out.print(i + " - ");
                System.out.printf("%-20s", aux.getNombre());
                System.out.println();
                aux = aux.getSigue();
                i++;
            }
        }
    }
   
    public void peliculasEjemplo() {
        this.agregarFinal(new Pelicula("Schindler's List", "Drama", "Steven Spielberg", 195));
        this.agregarFinal(new Pelicula("The Godfather", "Crime", "Francis Ford Coppola", 175));
        this.agregarFinal(new Pelicula("Pulp Fiction", "Crime", "Quentin Tarantino", 154));
        this.agregarFinal(new Pelicula("Fight Club", "Drama", "David Fincher", 139));
        this.agregarFinal(new Pelicula("Forrest Gump", "Drama, Romance", "Robert Zemeckis", 142));
        this.agregarFinal(new Pelicula("Inception", "Action", "Christopher Nolan", 148));
    }

    public boolean vacia() {
        return this.inicio == null;
    }

}
