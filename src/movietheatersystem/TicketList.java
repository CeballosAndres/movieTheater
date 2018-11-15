package movietheatersystem;

public class TicketList {

    Util util = new Util();
    private Ticket first, end;
    int folioInc;

    public TicketList() {
        this.first = null;
        this.end = null;
        this.folioInc = 10000;
    }

    public Ticket getFirst() {
        return first;
    }

    public Ticket getEnd() {
        return end;
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
            this.end.setNext(ticket);
            this.end = ticket;
        }
        this.folioInc++;
    }
    /*
    public Ticket addTicket(String name, int sala){
        
    }
    */
}
