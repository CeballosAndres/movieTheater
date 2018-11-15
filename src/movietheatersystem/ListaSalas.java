package movietheatersystem;

import java.util.Scanner;

public class ListaSalas {

    Sala inicio, fin;
    int cantidadSalas;
    Util util = new Util();

    // CONTRUCTORES 
    public ListaSalas(Sala inicio, Sala fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.cantidadSalas = 4;

    }

    public ListaSalas() {
        this.inicio = null;
        this.fin = null;
        this.cantidadSalas = 4;

    }

    // METODOS PARA MOVIE tHEATER SYSTEM
    public void configuracionInicial() {
        System.out.print("Cuantas asientos en salas:");
        int num = util.inputInteger();
        agregarSalas();
        agregarAsientos(num);
    }

    public void configuracionAsientos() {
        int salas = cantidadSalas;
        vaciar();
        System.out.print("Cuantas asientos en salas:");
        int asientos = util.inputInteger();
        agregarAsientosYSala(asientos, salas);
        datosSalasAsientos();
    }

    public void configuracionSalas() {
        int asientos = inicio.capacidadSala;
        vaciar();
        System.out.print("Cuantas  salas:");
        int salas = util.inputInteger();
        agregarAsientosYSala(asientos, salas);
        datosSalasAsientos();

    }

    public void agregarSalas() {
        int i = 10;
        while (i <= (cantidadSalas * 10)) {
            this.agregarFinal(new Sala(i));
            i += 10;
        }

    }

    public void agregarAsientos(int asientos) {
        Sala aux = this.inicio;
        while (aux != null) {
            aux.capacidadSala = asientos;
            aux = aux.getNext();
        }
    }

    public void agregarAsientosYSala(int asientos, int salas) {
        cantidadSalas = salas;
        agregarSalas();
        agregarAsientos(asientos);
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

    public void modificarFuncionesSala(ListaPeliculas peliculas) {
        System.out.println("   # Salas #  ");
        mostrarSalasNombre();
        int numSala = 0;
        do {
            System.out.print("Ingrese el numero de la sala:");
            numSala = util.opcion();
        } while (!(numSala <= cantidadSalas && numSala > 0));
        asignarDatosSala(numSala, peliculas);

    }

    public boolean TodaSalaConPelicula() {
        Sala aux = this.inicio;
        while (aux != null) {
            if (aux.pelicula == null) {
                return false;
            }
            aux = aux.next;

        }
        return true;

    }
    public boolean algunaSalaConPelicula() {
        Sala aux = this.inicio;
        while (aux != null) {
            if (aux.pelicula != null) {
                return true;
            }
            aux = aux.next;

        }
        return false;

    }

    public void asignarDatosSala(int numSala, ListaPeliculas peliculas) {
        System.out.println("   # Peliculas #  ");
        new ListaPeliculas().mostrarPeliculasNombre();
        int numPelicula = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula :");
            numPelicula = util.opcion();
        } while (numPelicula <= peliculas.cantidadPeliculas && numPelicula > 0);

        System.out.println("   # Formato #  ");
        System.out.println("1- 3D");
        System.out.println("2- 2D");
        int numFormato = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula :");
            numFormato = util.opcion();
        } while (!(numFormato == 1 || numFormato == 2));

        buscarPorPosicion(numSala).setPelicula(peliculas.buscarPorPosicion(numPelicula));
        buscarPorPosicion(numSala).setTipoFormato(numFormato);
    }

    public void agregarFuncionesSala(ListaPeliculas peliculas) {
        if (!TodaSalaConPelicula()) {
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
            asignarDatosSala(numSala, peliculas);
        } else {
            System.out.println("Salas ya tiene peliculas");
        }

    }

    public void mostrarSalasFunciones() {
        if (algunaSalaConPelicula()) {
            Sala aux = this.inicio;
            aux.labelFuncionesSala();
            while (aux != null) {
                aux.mostrar();
                aux = aux.getNext();
            }
        }else{
            System.out.println("No hay todavía funciones en sala");
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

    public void datosSalasAsientos() {
        System.out.println("salas:" + cantidadSalas + "  asientos: " + inicio.capacidadSala);
    }

    public boolean vacia() {
        return this.inicio == null;
    }

}
