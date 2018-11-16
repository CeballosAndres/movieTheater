package movietheatersystem;

public class Ticket {

    private Ticket next;
    private String folio;
    private String name;
    private int boleto;
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

    public void setNext(Ticket next) {
        this.next = next;
    }

    public void mostrarTicket(float costo, int descuentoNinos, int descuentoTercera) {
        System.out.println();
        System.out.printf("|  %-20s  ", "Name");
        System.out.printf("|  %-20s  ", "Folio");
        System.out.printf("|  %-15s  ", "ticketStandard");
        System.out.printf("|  %-15s  |", "ticketKids");
        System.out.printf("|  %-15s  ", "ticketElderly");
        System.out.printf("|  %-15s  ", "total");
        System.out.println();

        System.out.printf("| %-21s  ", " ");
        System.out.printf("| %-21s  ", " ");
        System.out.printf("| %-16s  ", this.ticketStandard);
        System.out.printf("| %-16s  |", this.ticketKids);
        System.out.printf("| %-16s  |", this.ticketElderly);
        System.out.printf("|  %-15s  ", "  ");
        System.out.println();
        System.out.printf("| %-21s  ", this.name);
        System.out.printf("| %-21s  ", this.folio);
        System.out.printf("| %-16s  ", this.ticketStandard * costo);
        System.out.printf("| %-16s  |", this.ticketKids * costo * ((100 - descuentoNinos) * 100));
        System.out.printf("| %-16s  |", this.ticketElderly * costo * ((100 - descuentoTercera) * 100));
        System.out.printf("|  %-15s  ", this.total);
        System.out.println();
    }

    public Ticket getNext() {
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

    public int getBoleto() {
        return boleto;
    }

    public void setBoleto(int boleto) {
        this.boleto = boleto;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void informeEtiquetaGanancias() {
        
    }

}
