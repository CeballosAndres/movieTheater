package movietheatersystem;

public class Client {

    private String name;
    private Client next;

    public Client(String name) {
        this.name = name;
    }

    public Client getNext() {
        return next;
    }

    public void setNext(Client next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.print(">" + this.name);
    }

}
