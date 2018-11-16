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

}
