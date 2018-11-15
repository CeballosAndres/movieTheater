package movietheatersystem;

public class Sala {

    //Lista doblemente enlazada con las peliculas del cine.
    Sala next;
    int numSala;
    static int capacidadSala;
    int boletosVendidos;
    int boletosCancelados;
    int tipoFormato;
    Pelicula pelicula;
    Boleto boleto;

    public Sala(int numSala) {
        this.next = null;
        this.numSala = numSala;
        this.capacidadSala = 0;
        this.boletosVendidos = 0;
        this.boletosCancelados = 0;
        this.tipoFormato = 0;
        this.pelicula = null;
        this.boleto = null;
    }

    public Sala() {
        this.next = null;
        this.capacidadSala = 0;
        this.numSala = numSala;
        this.boletosVendidos = 0;
        this.boletosCancelados = 0;
        this.tipoFormato = 0;
        this.pelicula = null;
        this.boleto = null;
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

    public void labelFuncionesSala() {
        System.out.println();
        System.out.printf("|  %-20s  ", "NumSala");
        System.out.printf("|  %-20s  ", "Pelicula");
        System.out.printf("|  %-15s  ", "Formato");
        System.out.println();
    }

    public void mostrar() {
        System.out.printf("| %-21s  ", this.numSala);
        System.out.printf("| %-21s  ", this.pelicula.getNombre());
        System.out.printf("| %-16s  ", this.escribirFormato(this.tipoFormato));
        System.out.println();
    }

    public String escribirFormato(int formato) {
        if (formato == 1) {
            return "3D";
        } else {
            return "2D";
        }

    }

}
