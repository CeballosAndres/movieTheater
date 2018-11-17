package movietheatersystem;

public class TicketList {

    Util util = new Util();
    Ticket inicio, fin;
    int folioInc;

    public TicketList() {
        this.inicio = null;
        this.fin = null;
        this.folioInc = 0;
    }

    public Ticket getFin() {
        return fin;
    }

    public boolean vacio() {
        return this.inicio == null;
    }

    public boolean buscarEliminarFolio(String folio) {
        if (!vacio()) {
            Ticket atras, aux;
            if (folio.equalsIgnoreCase(inicio.getFolio())) {
                inicio.mostrarTicket();
                if (inicio == fin) {
                    inicio = null;
                    fin = null;
                } else {
                    inicio = inicio.getNext();
                }
                return true;
            } else {
                atras = inicio;
                aux = inicio.getNext();
                while (aux != null) {
                    if (folio.equalsIgnoreCase(aux.getFolio())) {
                        aux.mostrarTicket();
                        atras.setNext(aux.getNext());
                        if (fin == aux) {
                            fin = atras;
                        }

                        aux = null;
                        return true;
                    } else {
                        atras = aux;
                        aux = aux.getNext();
                    }
                }
            }
        }
        return false;
    }

    private void anadirALista(Ticket nuevo) {
        if (this.vacio()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {

            this.fin.setNext(nuevo);
            this.fin = nuevo;
        }

    }

    public int obtenerCantidadBoletos() {
        int i = 0;
        Ticket aux = this.inicio;
        while (aux != null) {
            i++;
            aux = aux.getNext();
        }
        return i;
    }

    public Ticket totalesTickets() {
        Ticket totales = new Ticket();
        Ticket aux = this.inicio;
        while (aux != null) {
            totales.setTicketElderly(totales.getTicketElderly() + aux.getTicketElderly());
            totales.setTicketKids(totales.getTicketKids() + aux.getTicketKids());
            totales.setTicketStandard(totales.getTicketStandard() + aux.getTicketStandard());
            totales.setTotal(totales.getTotal() + aux.getTotal());
            aux = aux.getNext();
        }
        return totales;
    }
    
   

    public int cantidadPersonas() {
        Ticket resultadosTicket = totalesTickets();
        int i = resultadosTicket.getTicketKids() + resultadosTicket.getTicketElderly() + resultadosTicket.getTicketStandard();
        return i;
    }

    public void formarTicketParaAnadir(String folio, String name, int ticketStandard, int ticketKids, int ticketElderly, float total) {
        Ticket nuevo = new Ticket(folio, name, ticketStandard, ticketKids, ticketElderly, total);
        anadirALista(nuevo);
    }

}
