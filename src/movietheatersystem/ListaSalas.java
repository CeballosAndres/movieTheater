package movietheatersystem;

import java.util.Scanner;

public class ListaSalas {

    Sala inicio, fin;
    int cantidadSalas;
    Util util = new Util();
    String folio;
    int numeracionFolio;

    // CONTRUCTORES 
    public ListaSalas(Sala inicio, Sala fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.cantidadSalas = 4;
        this.folio = " ";
        this.numeracionFolio = 1;
    }

    public ListaSalas() {
        this.inicio = null;
        this.fin = null;
        this.cantidadSalas = 4;
        this.folio = " ";
        this.numeracionFolio = 1;
    }

    // METODOS PARA MOVIE tHEATER SYSTEM
    //
    //
    public int obtenerCantBoletosTodasSalas() {

        Sala aux = this.inicio;
        int i = 0;
        while (aux != null) {
            i += aux.getTicketList().obtenerCantidadBoletos();
            aux = aux.getNext();
        }
        return i;
    }

    public String obtenerFolio(int numSala) {
        char[] alphabet = " abcdefghijklmnopqrstuvwxyz".toCharArray();
        folio = alphabet[numSala] + Integer.toString(numeracionFolio);
        numeracionFolio++;
        return folio;
    }

    public void configuracionInicial() {
        System.out.print("Cuantas asientos en salas");
        int num = util.inputInteger();
        agregarSalas();
        agregarAsientos(num);
    }

    public void configuracionAsientos() {
        int salas = cantidadSalas;
        vaciar();
        System.out.print("Cuantas asientos en salas");
        int asientos = util.inputInteger();
        agregarAsientosYSala(asientos, salas);
        datosSalasAsientos();
    }

    public void configuracionSalas() {
        int asientos = inicio.capacidadSala;
        vaciar();
        System.out.print("¿Cuántas salas?");
        int salas = util.inputInteger();
        agregarAsientosYSala(asientos, salas);
        datosSalasAsientos();

    }

    public void agregarSalas() {
        int i = 1;
        while (i <= cantidadSalas) {
            this.agregarFinal(new Sala(i));
            i++;
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
        if (algunaSalaConPelicula()) {
            util.label("Salas");
            mostrarSalasNombre(2);
            int numSala = 0;
            do {
                System.out.print("Ingrese el numero de la sala");
                numSala = util.inputInteger();
            } while (!(numSala <= cantidadSalas && numSala > 0
                    && buscarSalaPorPosicion(numSala).pelicula != null));

            util.label("Antigua configuracion : Sala funcion");
            buscarSalaPorPosicion(numSala).labelFuncionesSala();
            buscarSalaPorPosicion(numSala).mostrar();
            asignarDatosSala(numSala, peliculas);
        } else {
            System.out.println("NO hay sala con funcion");
        }

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
        util.label("Seleccionar pelicula");
        peliculas.mostrarPeliculasNombre();
        int numPelicula = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula");
            numPelicula = util.inputInteger();
        } while (!(numPelicula <= peliculas.cantidadPeliculas() && numPelicula > 0));

        util.label("Seleccionar Formato");
        System.out.println("1 - 3D");
        System.out.println("2 - 2D");
        int numFormato = 0;
        do {
            System.out.print("Ingresa el numero de el formato");
            numFormato = util.inputInteger();
        } while (!(numFormato == 1 || numFormato == 2));

        buscarSalaPorPosicion(numSala).setPelicula(peliculas.buscarPorPosicion(numPelicula));
        buscarSalaPorPosicion(numSala).setTipoFormato(numFormato);
        util.label("Nueva configuracion : Sala funcion");

        buscarSalaPorPosicion(numSala).labelFuncionesSala();
        buscarSalaPorPosicion(numSala).mostrar();
    }

    public void agregarFuncionesSala(ListaPeliculas peliculas) {
        if (!TodaSalaConPelicula()) {
            this.mostrarSalasNombre(1);
            int numSala;
            do {
                System.out.print("Ingrese el numero de la sala");
                numSala = util.inputInteger();
            } while (!(numSala <= cantidadSalas && numSala > 0 && buscarSalaPorPosicion(numSala).pelicula == null));
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
                if (aux.pelicula != null) {
                    aux.mostrar();
                }
                aux = aux.getNext();
            }
        } else {
            System.out.println("No hay todavía funciones en sala");
        }

    }

    public Sala buscarSalaPorPosicion(int index) {
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

    public void mostrarSalasNombre(int opc) {
        Sala aux = this.inicio;
        util.label("Seleccionar Sala");
        System.out.println();
        int i = 1;
        while (aux != null) {
            if (aux.pelicula == null && opc == 1) {
                System.out.print(i + " -  Sala ");
                System.out.printf("%-20s", aux.getNumSala());
                System.out.println();
            } else if (aux.pelicula != null && opc == 2) {
                System.out.print(i + " -  Sala ");
                System.out.printf("%-20s", aux.getNumSala());
                System.out.println();
            } else if (opc == 3) {
                System.out.print(i + " -  Sala ");
                System.out.printf("%-20s", aux.getNumSala());
                System.out.println();
            }
            i++;
            aux = aux.getNext();
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

    public Ticket totalesTicketsCine() {
        Ticket totales = new Ticket();
        Sala aux = this.inicio;
        while (aux != null) {
            Ticket ticketSala = this.inicio.getTicketList().totalesTickets();
            totales.setTicketStandard(totales.getTicketStandard() + ticketSala.getTicketStandard());
            totales.setTicketElderly(totales.getTicketElderly() + ticketSala.getTicketElderly());
            totales.setTicketKids(totales.getTicketKids() + ticketSala.getTicketKids());
            totales.setTotal(totales.getTotal() + ticketSala.getTotal());
            aux = aux.getNext();
        }
        return totales;
    }

    public int cantidadPersonas() {
        Ticket resultadosTicket = totalesTicketsCine();
        int i = resultadosTicket.getTicketKids() + resultadosTicket.getTicketKids() + resultadosTicket.getTicketStandard();
        return i;
    }
    
    public Ticket buscarFolio(String folio){
        Sala aux = this.inicio;
        Ticket eliminar;
        while(aux != null){
            if ((eliminar = aux.getTicketList().buscarEliminarFolio(folio)) != null) {
                return eliminar;
            }
            aux = aux.getNext();
        }
        return null;
    }
}
