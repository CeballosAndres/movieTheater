package movietheatersystem;

public class Sala {

    //Lista doblemente enlazada con las peliculas del cine.
    Sala next;
    int numSala;
    int capacidadSala;
    int boletossCancelados;
    int tipoFormato;
    Pelicula pelicula;
    TicketList ticketList;
    
     

    public Sala(int numSala) {
        this.next = null;
        this.numSala = numSala;
        this.capacidadSala = 4;
        this.boletossCancelados = 0;
        this.tipoFormato = 0;
        this.pelicula = null;
        this.ticketList = new TicketList();
    }

   

    public Sala() {
        this.next = null;
        this.capacidadSala = 4;
        this.numSala = 0;
        this.boletossCancelados = 0;
        this.tipoFormato = 0;
        this.pelicula = null;
    }

    public int getTipoFormato() {
        return tipoFormato;
    }

    public void setCapacidadSala(int capacidadSala) {
        this.capacidadSala = capacidadSala;
    }

    public void setTipoFormato(int tipoFormato) {
        this.tipoFormato = tipoFormato;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNext(Sala next) {
        this.next = next;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getNext() {
        return next;
    }

    public TicketList getTicketList() {
        return ticketList;
    }

    
    public void labelFuncionesSala() {
        System.out.println();
        System.out.printf("|  %-10s  ", "Núm. Sala");
        System.out.printf("|  %-20s  ", "Pelicula");
        System.out.printf("|  %-15s  ", "Formato");
        System.out.printf("|  %-19s |", "Asientos Disp.");
        System.out.println();
    }

    public void mostrar() {
        System.out.printf("| %-11s  ", this.numSala);
        System.out.printf("| %-21s  ", this.pelicula.getNombre());
        System.out.printf("| %-16s  ", this.escribirFormato(this.tipoFormato));
        System.out.printf("| %-19s  |", String.valueOf(this.capacidadSala));
        System.out.println();
    }

    public String escribirFormato(int formato) {
        if (formato == 1) {
            return "3D";
        } 
            return "2D";
    }
}
