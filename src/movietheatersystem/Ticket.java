package movietheatersystem;

public class Ticket {

    private Ticket next;
    private String folio;
    private String name;
    private int ticketStandard;
    private int ticketKids;
    private int ticketElderly;
    private float total;

    public Ticket() {
        this.next = null;
        this.folio = null;
        this.name = null;
        this.ticketStandard = 0;
        this.ticketKids = 0;
        this.ticketElderly = 0;
        this.total = 0;
    }

    public Ticket(String folio, String name, int ticketStandard, int ticketKids, int ticketElderly) {
        this.next = null;
        this.folio = folio;
        this.name = name;
        this.ticketStandard = ticketStandard;
        this.ticketKids = ticketKids;
        this.ticketElderly = ticketElderly;
        this.total = 0;
    }

    public void setNext(Ticket next) {
        this.next = next;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float obtenerCostoBoleto(int costo, int descuentoTercera, int descuentoNinos) {
        int total=(ticketStandard*costo)+(ticketKids*costo* ((100 - descuentoNinos) * 100))+(ticketElderly*costo* ((100 - descuentoTercera) * 100));
        return total;
    }
     public void labelTicket() {
        System.out.println();
        System.out.printf("|  %-20s  ", "Name");
        System.out.printf("|  %-20s  ", "Folio");
        System.out.printf("|  %-15s  ", "ticketStandard");
        System.out.printf("|  %-8s  |", "ticketKids");
        System.out.printf("|  %-20s  ", "Name");
        System.out.printf("|  %-20s  ", "Folio");
        System.out.println();
    }

    public void mostrar() {
        System.out.printf("| %-21s  ", this.nombre);
        System.out.printf("| %-21s  ", this.director);
        System.out.printf("| %-16s  ", this.genero);
        System.out.printf("| %-9s  |", this.duracion);
        System.out.println();
    }

}
