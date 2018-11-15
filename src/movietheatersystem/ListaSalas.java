package movietheatersystem;

import java.util.Scanner;

public class ListaSalas {

    ListaPeliculas peliculas = new ListaPeliculas();
    Sala inicio, fin;
    static int cantidadSalas=4;
    Util util = new Util();

    // CONTRUCTORES 
    public ListaSalas(Sala inicio, Sala fin) {
        this.inicio = inicio;
        this.fin = fin;
        

    }

    public ListaSalas() {
        this.inicio = null;
        this.fin = null;
        
    }

    // METODOS PARA MOVIE tHEATER SYSTEM
    public void configuracionInicialAsientos() {

        System.out.print("Cuantas aseintos en salas:");
        inicio.capacidadSala = util.opcion();
        vaciar();
        agregarSala();
    }

    public void configuracionSalas() {
        System.out.print("Cuantas  salas:");
        cantidadSalas = util.opcion();
        vaciar();
        agregarSala();
    }

    private void agregarFinal(Sala nuevo) {
        if (this.vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setNext(nuevo);
            this.fin = nuevo;
        }
    }

    public void agregarSala() {
        int i = 10;
        while (i <= (cantidadSalas * 10)) {
            this.agregarFinal(new Sala(i));
            i += 10;
        }

    }

    public void modificarFuncionesSala() {
        System.out.println("   # Salas #  ");
        mostrarSalasNombre();
        int numSala = 0;
        do {
            System.out.print("Ingrese el numero de la sala:");
            numSala = util.opcion();
        } while (!(numSala <= cantidadSalas && numSala > 0));
        asignarDatosSala(numSala);

    }

    public boolean salasConPelicula() {
        Sala aux = this.inicio;
        int i;
        while (aux != null) {
            if (aux.pelicula == null) {
                return false;
            }
            aux = aux.next;

        }
        return true;

    }

    public void asignarDatosSala(int numSala) {
        System.out.println("   # Peliculas #  ");
        new ListaPeliculas().mostrarPeliculasNombre();
        int numPelicula = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula :");
            numPelicula = util.opcion();
        } while (numPelicula <= ListaPeliculas.cantidadPeliculas && numPelicula > 0);

        System.out.println("   # Formato #  ");
        System.out.println("1- 3D");
        System.out.println("2- 2D");
        int numFormato = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula :");
            numFormato = util.opcion();
        } while (!(numFormato == 1 || numFormato == 2));

        buscarPorPosicion(numSala).setPelicula(new ListaPeliculas().buscarPorPosicion(numPelicula));
        buscarPorPosicion(numSala).setTipoFormato(numFormato);
    }

    public void agregarFuncionesSala() {
        if (!salasConPelicula()) {
            System.out.println("   # Salas sin Pelicula asignada #  ");
            Sala aux = this.inicio;
            int i = 0;
            while (aux != null) {
                if (aux.pelicula == null) {
                    System.out.println((i + 1) + "-" + " " + aux.numSala);
                }
                i++;
                aux = aux.getNext();
            }
            int numSala;
            do {
                System.out.print("Ingrese el numero de la sala: ");
                numSala = util.opcion();
            } while (!(numSala <= cantidadSalas && numSala > 0 && buscarPorPosicion(numSala).pelicula == null));
            asignarDatosSala(numSala);
        } else {
            System.out.println("Salas ya tiene peliculas");
        }

    }

    public void mostrarSalasFunciones() {
        Sala aux = this.inicio;
        aux.labelFuncionesSala();
        while (aux != null) {
            aux.mostrar();
            aux = aux.getNext();
        }

    }

    public Sala buscarPorPosicion(int index) {
        Sala aux = this.inicio;
        int i = 1;
        while (aux != null) {
            if (i == index) {
                return aux;
            }
            i++;
            aux = aux.getNext();
        }
        return null;
    }

    public void mostrarSalasNombre() {
        Sala aux = this.inicio;
        System.out.printf("   %-20s", "Nombre");
        System.out.println();
        int i = 1;
        while (aux != null) {
            System.out.print(i + " =");
            System.out.printf("%-20s", aux.getNumSala());
            System.out.println();
            aux = aux.getNext();
            i++;

        }
    }

    public void vaciar() {
        this.inicio = null;
    }

    public boolean vacia() {
        return this.inicio == null;
    }

}
