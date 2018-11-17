package movietheatersystem;

import java.util.Scanner;

public class Util {

    public String inputText() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" > ");
        return sc.nextLine();
    }

    public int inputInteger() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" > ");
        String input = sc.next();
        while (!isNumeric(input)) {
            System.out.print("¡Introducir solo números! > ");
            input = sc.next();
        }
        return Integer.valueOf(input);
    }

    public char entradaChar() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" > ");
        return sc.next().charAt(0);
    }

    public void label(String cadena) {
        int ancho = 83;
        System.out.println("");
        for (int i = 0; i < (ancho - cadena.length()) / 2; i++) {
            System.out.print("=");
        }
        System.out.print(" " + cadena + " ");
        for (int i = 0; i < (ancho - cadena.length()) / 2; i++) {
            System.out.print("=");
        }
        System.out.println("");
    }

    public int opcion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Opción > ");
        String entrada = sc.next();
        while (!isNumeric(entrada)) {
            System.out.print("¡Error! Opción > ");
            entrada = sc.next();
        }
        return Integer.valueOf(entrada);
    }

    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public float outputMoney(float input){
        return input;
    }
}
