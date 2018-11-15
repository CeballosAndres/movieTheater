package movietheatersystem;

public class FilaCliente {

    private Cliente inicio;
    private Cliente fin;
    private int tam;

    public FilaCliente() {
        this.inicio = null;
        this.fin = null;
        this.tam = 0;
    }

    public void add(Cliente nuevo) {
        if (this.empty()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setSigue(nuevo);
            this.fin = nuevo;
        }
    }

    public Cliente remove() {
        if (this.empty()) {
            return null;
        }
        Cliente primero = this.inicio;
        this.inicio = this.inicio.getSigue();
        return primero;
    }

    public void show() {
        Cliente aux = this.inicio;
        while (aux != null) {
            aux.show();
            aux = aux.getSigue();
        }
    }

    public boolean empty() {
        return this.inicio == null;
    }
}
