package movietheatersystem;
public class Sala {
    //Lista doblemente enlazada con las peliculas del cine.
    Sala next;
    
    int numSala;
    static int capacidadSala ;
    
    int boletosVendidos;
    int boletosCancelados;
    int tipoFormato;
    Pelicula pelicula;
    Boleto boleto;
   
    public Sala(int numSala) {
        this.next = null;
        this.numSala = numSala;
        this.boletosVendidos = 0;
        this.boletosCancelados = 0;
        this.tipoFormato= 0;
        this.pelicula=null;
        this.boleto=null;
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

    
    
    

    
}
