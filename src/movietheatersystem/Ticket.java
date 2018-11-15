package movietheatersystem;
public class Ticket {
    private Ticket next, back;
    private String folio;
    private String name;
    private int age;
    private int ticketStandard;
    private int ticketBoy;
    private int ticketElderly;
    private float total;
    
    public Ticket(){
        this.next = null;
        this.back = null;
        this.folio = null;
        this.name = null;
        this.age = 0;
        this.ticketStandard = 0;
        this.ticketBoy = 0;
        this.ticketElderly = 0;
        this.total = 0;
    }

    public Ticket getBack() {
        return back;
    }

    public void setBack(Ticket back) {
        this.back = back;
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

    public int getAge() {
        return age;
    }

    public int getTicketStandard() {
        return ticketStandard;
    }

    public int getTicketBoy() {
        return ticketBoy;
    }

    public int getTicketElderly() {
        return ticketElderly;
    }

    public float getTotal() {
        return total;
    }

    public void setNext(Ticket next) {
        this.next = next;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTicketStandard(int ticketStandard) {
        this.ticketStandard = ticketStandard;
    }

    public void setTicketBoy(int ticketBoy) {
        this.ticketBoy = ticketBoy;
    }

    public void setTicketElderly(int ticketElderly) {
        this.ticketElderly = ticketElderly;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
    
}
