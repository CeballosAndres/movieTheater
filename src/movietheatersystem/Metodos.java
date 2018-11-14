package movietheatersystem;

import java.util.Scanner;

public class Metodos {

    public String entradaTexto() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" > ");
        return sc.nextLine();
    }

    public int entradaEntero() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" > ");
        String entrada = sc.next();
        return Integer.valueOf(entrada);
    }
}
