package movietheatersystem;

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
        this.cantidadSalas = 0;
        this.folio = " ";
        this.numeracionFolio = 1;
    }

    public ListaSalas() {
        this.inicio = null;
        this.fin = null;
        this.cantidadSalas = 0;
        this.folio = " ";
        this.numeracionFolio = 1;
    }

    // METODOS PARA MOVIE THEATER SYSTEM
    // Configiracion cine Asientos Salas
    //
    //
    public void configuracionInicial(int salas, int asientos) {
        //System.out.print("¿Cuántas asientos en salas?");
        //int num = util.inputInteger();
        this.cantidadSalas = salas;
        agregarSalas();
        agregarAsientos(asientos);
    }

    public void configuracionAsientos() {
        int salas = cantidadSalas;
        vaciar();
        System.out.print("¿Cuántas asientos en salas?");
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

    public void agregarAsientosYSala(int asientos, int salas) {
        cantidadSalas = salas;
        agregarSalas();
        agregarAsientos(asientos);
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

    private void agregarFinal(Sala nuevo) {
        if (this.vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setNext(nuevo);
            this.fin = nuevo;
        }
    }

    public void datosSalasAsientos() {
        System.out.println("Salas: " + cantidadSalas + "\nAsientos: " + inicio.capacidadSala);
    }

    //Folio para boletos 
    //
    //
    public String obtenerFolio(int numSala) {
        char[] alphabet = " abcdefghijklmnopqrstuvwxyz".toCharArray();
        folio = alphabet[numSala] + Integer.toString(numeracionFolio);
        numeracionFolio++;
        return folio;
    }

    // cantidades boletos
    //
    //
    public int obtenerCantBoletosSalas() {
        Sala aux = this.inicio;
        int i = 0;
        while (aux != null) {

            i += aux.getTicketList().obtenerCantidadBoletos();
            aux = aux.getNext();
        }
        return i;
    }

    public int obtenerCantidadBoletos(String pelicula) {
        Sala aux = this.inicio;
        int i = 0;
        while (aux != null) {
            if (aux.pelicula != null && aux.pelicula.getNombre().equalsIgnoreCase(pelicula)) {
                i += aux.getTicketList().obtenerCantidadBoletos();
            }
            aux = aux.getNext();
        }
        return i;
    }
     public int obtenerCantidadBoletos(int formato) {
        Sala aux = this.inicio;
        int i = 0;
        while (aux != null) {
            if ( aux.pelicula!=null && aux.getTipoFormato() == formato ) {
                i += aux.getTicketList().obtenerCantidadBoletos();
            }
            aux = aux.getNext();
        }
        return i;
    }

    //configuracion funciones sala
    //
    //
    public void modificarFuncionesSala(ListaPeliculas peliculas) {
        if (algunaSalaConPelicula()) {
            util.label("Salas");
            mostrarSalasConPelicula();
            int numSala = 0;
            do {
                System.out.print("Ingrese el número de la sala");
                numSala = util.inputInteger();
            } while (!(numSala <= cantidadSalas && numSala > 0
                    && buscarSalaPorPosicion(numSala).pelicula != null));

            util.label("Antigua configuración : Sala función");
            buscarSalaPorPosicion(numSala).labelFuncionesSala();
            buscarSalaPorPosicion(numSala).mostrar();
            asignarDatosSala(numSala, peliculas);
        } else {
            System.out.println("No hay sala con función");
        }

    }

    public void asignarDatosSala(int numSala, ListaPeliculas peliculas) {
        util.label("Seleccionar película");
        peliculas.mostrarPeliculasNombre();
        int numPelicula = 0;
        do {
            System.out.print("Ingresa el número de la película");
            numPelicula = util.inputInteger();
        } while (!(numPelicula <= peliculas.cantidadPeliculas() && numPelicula > 0));

        util.label("Seleccionar Formato");
        System.out.println("1 - 3D");
        System.out.println("2 - 2D");
        int numFormato = 0;
        do {
            System.out.print("Ingresa el número del formato");
            numFormato = util.inputInteger();
        } while (!(numFormato == 1 || numFormato == 2));

        buscarSalaPorPosicion(numSala).setPelicula(peliculas.buscarPorPosicion(numPelicula));
        buscarSalaPorPosicion(numSala).setTipoFormato(numFormato);
        util.label("Nueva configuración : Sala función");

        buscarSalaPorPosicion(numSala).labelFuncionesSala();
        buscarSalaPorPosicion(numSala).mostrar();
    }

    public void agregarFuncionesSala(ListaPeliculas peliculas) {
        if (!TodaSalaConPelicula()) {
            this.mostrarSalasSinPeli();
            int numSala;
            do {
                System.out.print("Ingrese el número de la sala");
                numSala = util.inputInteger();
            } while (!(numSala <= cantidadSalas && numSala > 0 && buscarSalaPorPosicion(numSala).pelicula == null));
            asignarDatosSala(numSala, peliculas);
        } else {
            System.out.println("Salas ya tiene películas");
        }

    }

    public boolean buscarFolio(String folio) {
        Sala aux = this.inicio;
        while (aux != null) {
            if (aux.getTicketList().buscarEliminarFolio(folio)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
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

    public boolean salaConBoletosVendidosPelicula() {
        Sala aux = this.inicio;
        while (aux != null) {
            if (aux.pelicula != null && aux.getTicketList().cantidadPersonas() != 0) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public boolean salaConBoletosPelicula() {
        Sala aux = this.inicio;
        while (aux != null) {
            if (aux.capacidadSala - aux.getTicketList().cantidadPersonas() != 0 && aux.pelicula != null) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
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

    public boolean vacia() {
        return this.inicio == null;
    }

    // mostrar salas
    //
    //
    public void mostrarSalasConPelicula() {
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

    public void mostrarSalasSinPeli() {
        Sala aux = this.inicio;
        int i = 1;
        util.label("Seleccionar Sala");
        System.out.println();
        while (aux != null) {
            if (aux.pelicula == null) {
                System.out.print(i + " -  Sala ");
                System.out.printf("%-20s", aux.getNumSala());
                System.out.println();
            }
            i++;
            aux = aux.getNext();
        }

    }

    public void mostrarSalasConBoletoYPeliculas() {
        Sala aux = this.inicio;
        util.label("Seleccionar Sala");
        if (aux != null) {
            aux.labelFuncionesSala();
        }

        System.out.println();
        while (aux != null) {

            if (aux.capacidadSala - aux.getTicketList().cantidadPersonas() != 0 && aux.pelicula != null) {
                aux.mostrar();
                System.out.println();
            }
            aux = aux.getNext();
        }
    }

    public void mostrarSalasConBoletoVendidosYPelicula() {
        Sala aux = this.inicio;
        if (aux != null) {
            aux.labelFuncionesSala();
        }
        System.out.println();
        while (aux != null) {
            if (aux.pelicula != null && aux.getTicketList().cantidadPersonas() != 0) {
                aux.mostrar();
                System.out.println();
            }
            aux = aux.getNext();
        }
    }
    
    public void mostrarInfSala(Ticket ticket) {
        Ticket aux =ticket;

        System.out.println(" Folio-Nombres-total");
        int i=1;
        while (aux != null) {
            System.out.print(" < "+ i+" : "+ aux.getFolio()+" : "+aux.getName()+" : "+aux.getTotal());
            i++;
            aux = aux.getNext();
        }
    
    }
    public void mostrarDatosSalaPF(int numSala) {
        System.out.println();
        util.label("Ticket ---- "+buscarSalaPorPosicion(numSala).pelicula.getNombre()+" # "+buscarSalaPorPosicion(numSala).escribirFormato(numSala));
        
    
    }
    

    // objetos para estadisticas
    //
    //
    public Ticket totalesTicketsCine() {
        Ticket totales = new Ticket();
        Sala aux = this.inicio;
        while (aux != null) {
            Ticket ticketSala = aux.getTicketList().totalesTickets();
            totales.setTicketStandard(totales.getTicketStandard() + ticketSala.getTicketStandard());
            totales.setTicketElderly(totales.getTicketElderly() + ticketSala.getTicketElderly());
            totales.setTicketKids(totales.getTicketKids() + ticketSala.getTicketKids());
            totales.setTotal(totales.getTotal() + ticketSala.getTotal());
            aux = aux.getNext();
        }
        return totales;
    }

    public Ticket totalesTicketsPelicula(String pelicula) {
        Ticket totales = new Ticket();
        Sala aux = this.inicio;
        while (aux != null) {
            if (aux.pelicula != null && aux.pelicula.getNombre().equalsIgnoreCase(pelicula)) {
                Ticket ticketSala = aux.getTicketList().totalesTickets();
                totales.setTicketStandard(totales.getTicketStandard() + ticketSala.getTicketStandard());
                totales.setTicketElderly(totales.getTicketElderly() + ticketSala.getTicketElderly());
                totales.setTicketKids(totales.getTicketKids() + ticketSala.getTicketKids());
                totales.setTotal(totales.getTotal() + ticketSala.getTotal());
            }
            aux = aux.getNext();
        }
        return totales;
    }

     public Ticket totalesTicketsFormato(int formato) {
        Ticket totales = new Ticket();
        Sala aux = this.inicio;
        while (aux != null) {
            if ( aux.pelicula!=null && aux.getTipoFormato() == formato ) {
                Ticket ticketSala = aux.getTicketList().totalesTickets();
                totales.setTicketStandard(totales.getTicketStandard() + ticketSala.getTicketStandard());
                totales.setTicketElderly(totales.getTicketElderly() + ticketSala.getTicketElderly());
                totales.setTicketKids(totales.getTicketKids() + ticketSala.getTicketKids());
                totales.setTotal(totales.getTotal() + ticketSala.getTotal());
            }
            aux = aux.getNext();
        }
        return totales;
    }
     
    public int cantidadPersonasFormato(int formato) {
        Ticket resultadosTicket = totalesTicketsFormato(formato);
        int i = resultadosTicket.getTicketKids() + resultadosTicket.getTicketElderly() + resultadosTicket.getTicketStandard();
        return i;
    }
    
    public int cantidadPersonasPelicula(String pelicula) {
        Ticket resultadosTicket = totalesTicketsPelicula(pelicula);
        int i = resultadosTicket.getTicketKids() + resultadosTicket.getTicketElderly() + resultadosTicket.getTicketStandard();
        return i;
    }

    public int cantidadPersonas() {
        Ticket resultadosTicket = totalesTicketsCine();
        int i = resultadosTicket.getTicketKids() + resultadosTicket.getTicketElderly() + resultadosTicket.getTicketStandard();
        return i;
    }

    //Otros metodos
    //
    //
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

    public void vaciar() {
        this.inicio = null;
    }

}
