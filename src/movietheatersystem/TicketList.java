package movietheatersystem;

public class TicketList {

    Util util = new Util();
    private Ticket first, end;

    public TicketList() {
        this.first = null;
        this.end = null;
    }

    public Util getUtil() {
        return util;
    }

    public Ticket getFirst() {
        return first;
    }

    public Ticket getEnd() {
        return end;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public void setFirst(Ticket first) {
        this.first = first;
    }

    public void setEnd(Ticket end) {
        this.end = end;
    }
    
    

    public boolean empty() {
        return this.first == null;
    }

    private void addEnd(Ticket ticket) {
        if (this.empty()) {
            this.first = ticket;
            this.end = ticket;
        } else {
            ticket.setBack(this.end);
            this.first.setFirst(nuevo);
            this.fin = nuevo;
        }
        cantidadPeliculas++;
    }
}
