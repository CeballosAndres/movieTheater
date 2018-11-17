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

    public Client remove() {
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

   

    public void newClient() {
        System.out.print("Nombre cliente");
        this.add(new Client(util.inputText()));
        System.out.println("Alta exitosa!");
    }

}
