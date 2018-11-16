package movietheatersystem;

public class CustomerQueue {

    private Client first;
    private Client last;
    private Util util;

    public CustomerQueue() {
        this.first = null;
        this.last = null;
        this.util = new Util();
    }

    public int length() {
        Client aux = this.first;
        int i = 0;
        while (aux != null) {
            aux = aux.getNext();
            i++;
        }
        return i;
    }

    public boolean empty() {
        return this.first == null;
    }

    private void add(Client nuevo) {
        if (this.empty()) {
            this.first = nuevo;
            this.last = nuevo;
        } else {
            this.last.setNext(nuevo);
            this.last = nuevo;
        }
    }

    private Client remove() {
        Client primero = this.first;
        this.first = this.first.getNext();
        return primero;

    }

    public void show() {
        if (this.empty()) {
            System.out.println("No hay clientes en cola!");
        } else {
            Client aux = this.first;
            System.out.print("Fila: ");
            while (aux != null) {
                aux.show();
                aux = aux.getNext();
            }
        }
    }

    public void serveCustumer(ListaSalas listaSalas, int costo2D, int costo3D, int descuentoTercera, int descuentoNinos) {

        listaSalas.mostrarSalasNombre(2);
        int numSala = 0;
        do {
            System.out.print("Ingrese el numero de la sala:");
            numSala = util.opcion();
        } while (!(numSala <= listaSalas.cantidadSalas && numSala > 0
                && listaSalas.buscarSalaPorPosicion(numSala).pelicula != null));

        int boletos;
        do {
            System.out.println("Cuantos Boletos:");
            boletos = util.inputInteger();
            if (!(boletos <= (listaSalas.buscarSalaPorPosicion(numSala).capacidadSala
                    - listaSalas.buscarSalaPorPosicion(numSala).capacidadSala))) {
                System.out.println("No hay suficiente cantidad de boletos en esa sala para vender");
                System.out.println("Ingrese una cantidad <= a"
                        + (listaSalas.buscarSalaPorPosicion(numSala).capacidadSala
                        - listaSalas.buscarSalaPorPosicion(numSala).boletossVendidos
                        + listaSalas.buscarSalaPorPosicion(numSala).boletossCancelados));
            }

        } while (!(boletos > 0 && boletos
                <= (listaSalas.buscarSalaPorPosicion(numSala).capacidadSala
                - listaSalas.buscarSalaPorPosicion(numSala).boletossVendidos
                + listaSalas.buscarSalaPorPosicion(numSala).boletossCancelados)));

        int total, ticketKids, ticketStandard, ticketElderly;

        do {
            System.out.println("Cuantos ninos:");
            ticketKids = util.inputInteger();
            System.out.println("Cuantos boletos normales:");
            ticketStandard = util.inputInteger();
            System.out.println("Cuantos adultos tercera edad:");
            ticketElderly = util.inputInteger();
            total = ticketKids + ticketStandard + ticketElderly;
            if (total != boletos) {
                System.out.println("La cantidades de cada categoria no son las adecuadas para " + boletos + " boletos");
            }
        } while (!(total == boletos));

        String name = remove().getName();

        listaSalas.buscarSalaPorPosicion(numSala).getTicketList()
                .formarTicketParaAnadir(listaSalas.obtenerFolio(numSala), name, ticketStandard, ticketKids, ticketElderly);

        int costo;
        
        if (listaSalas.buscarSalaPorPosicion(numSala).getTipoFormato() == 1) {
            costo = costo3D;
        }else{
        costo=costo2D;
        }
        float totalTicket =listaSalas.buscarSalaPorPosicion(numSala).getTicketList().getFin().obtenerCostoBoleto(costo, descuentoTercera, descuentoNinos);
        listaSalas.buscarSalaPorPosicion(numSala).getTicketList().getFin().setTotal(totalTicket);
        
        listaSalas.buscarSalaPorPosicion(numSala).boletossVendidos+=boletos;

    }

    public void newClient() {
        System.out.print("Nombre cliente: ");
        this.add(new Client(util.inputText()));
        System.out.println("Alta exitosa!");
    }

}
