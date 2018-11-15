package movietheatersystem;

public class CustomerQueue {

    private Client first;
    private Client last;
    private int length;
    private Util util;

    public CustomerQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
        this.util = new Util();
    }

    private void add(Client nuevo) {
        this.length++;
        if (this.empty()) {
            this.first = nuevo;
            this.last = nuevo;
        } else {
            this.last.setNext(nuevo);
            this.last = nuevo;
        }
    }

    public Client remove() {
        if (this.empty()) {
            return null;
        }
        Client primero = this.first;
        this.first = this.first.getNext();
        return primero;
    }

    public void show() {
        Client aux = this.first;
        System.out.println("Fila de clientes: ");
        while (aux != null) {
            aux.show();
            aux = aux.getNext();
        }
    }
    
    public Client serveCustumer(){
        Client client;
        if ((client = this.remove()) != null) {
            //llamada a metodo para atender cliente
            return client;
        }
        System.out.println("No hay más clientes.");
        return null;
    }

    public boolean empty() {
        return this.first == null;
    }
    
    public void newClient(){
        System.out.print("Nombre cliente: ");
        this.add(new Client(util.inputText()));
        System.out.println("Alta exitosa!");
    }
    
    
    
}
