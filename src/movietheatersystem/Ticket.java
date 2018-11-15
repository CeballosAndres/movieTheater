package movietheatersystem;
public class Ticket {
    Ticket next;
    String folio;
    String nameOwner;
    int ageOwner;
    int ticketStandard;
    int ticketBoy;
    int ticketElderly;
    float total;
    
    public Ticket(){
        this.next = null;
        this.folio = null;
        this.nameOwner = null;
        this.ageOwner = 0;
        this.ticketStandard = 0;
        this.ticketBoy = 0;
        this.ticketElderly = 0;
        this.total = 0;
    }
}
