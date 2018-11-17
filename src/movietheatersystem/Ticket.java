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

    public Ticket(String folio, String name, int ticketStandard, int ticketKids, int ticketElderly, float total) {
        this.next = null;
        this.folio = folio;
        this.name = name;
        this.ticketStandard = ticketStandard;
        this.ticketKids = ticketKids;
        this.ticketElderly = ticketElderly;
        this.total = total;
    }

    public int cantidadPersonas() {
        int i = ticketStandard + ticketKids + ticketElderly;
        return i;
    }

    public void setNext(Ticket next) {
        this.next = next;
    }

    public void mostrarTicket(float costo, float descuentoNinos, float descuentoTercera) {
        System.out.println();
        System.out.printf("|  %-11s  ", "Nombre");
        System.out.printf("|  %-7s  ", "Folio");
        System.out.printf("|  %-7s  ", "Estandar");
        System.out.printf("|  %-7s  ", "Niños");
        System.out.printf("|  %-7s  ", "A. mayor");
        System.out.printf("|  %-7s  |", "Total");
        System.out.println();

        System.out.printf("| %-12s  ", this.name);
        System.out.printf("| %-7s   ", this.folio);
        System.out.printf("| %-9s  ", this.ticketStandard);
        System.out.printf("| %-8s  ", this.ticketKids);
        System.out.printf("| %-9s  ", this.ticketElderly);
        System.out.printf("| %-8s  |", this.cantidadPersonas());

        System.out.println("\n--------------------------------------------------------------------------");
        System.out.printf("| %-24s  ", "        Totales");
        System.out.printf("| %-9s  ", this.ticketStandard * costo);
        System.out.printf("| %-8s  ", this.ticketKids * costo * ((100 - descuentoNinos) / 100));
        System.out.printf("| %-9s  ", this.ticketElderly * costo * ((100 - descuentoTercera) / 100));
        System.out.printf("| %-8s  |", this.total);
        System.out.println("\n");
    }

    public void mostrarTicket() {
        System.out.println();
        System.out.printf("| %-20s  ", "Name");
        System.out.printf("| %-20s  ", "Folio");
        System.out.printf("| %-15s  ", "ticketStandard");
        System.out.printf("| %-15s  |", "ticketKids");
        System.out.printf("| %-15s  ", "ticketElderly");
        System.out.printf("| %-15s  ", "total");
        System.out.println();

        System.out.printf("|%-21s  ", this.name);
        System.out.printf("|%-21s  ", this.folio);
        System.out.printf("|%-16s  ", this.ticketStandard);
        System.out.printf("|%-16s  |", this.ticketKids);
        System.out.printf("|%-16s  |", this.ticketElderly);
        System.out.printf("|%-15s  ", this.total);
        System.out.println();
    }

    public Ticket getNext() {
        return next;
    }

    public Ticket setNext() {
        return next;
    }

    public String getFolio() {
        return folio;
    }

    public String getName() {
        return name;
    }

    public int getTicketStandard() {
        return ticketStandard;
    }

    public int getTicketKids() {
        return ticketKids;
    }

    public int getTicketElderly() {
        return ticketElderly;
    }

    public float getTotal() {
        return total;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicketStandard(int ticketStandard) {
        this.ticketStandard = ticketStandard;
    }

    public void setTicketKids(int ticketKids) {
        this.ticketKids = ticketKids;
    }

    public void setTicketElderly(int ticketElderly) {
        this.ticketElderly = ticketElderly;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
