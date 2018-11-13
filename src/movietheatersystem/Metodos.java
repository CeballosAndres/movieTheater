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
        char[] numeros = {1,2,3,4,5,6,7,8,9,0};
        System.out.print(" > ");
        String entrada = sc.next();
        return Integer.valueOf(entrada);
    }
}
