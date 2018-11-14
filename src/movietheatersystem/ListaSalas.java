/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movietheatersystem;

import java.util.Scanner;

/**
 *
 * @author beverly
 */
public class ListaSalas {

    Sala inicio, fin;
    Util util = new Util();
    static int cantidadSalas = 4;

    public void configuracionInicialAsientos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantas aseintos en salas:");
        Sala.capacidadSala = sc.nextInt();
        vaciar();
        agregarSala();
    }
    public void configuracionSalas() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantas  salas:");
        cantidadSalas= sc.nextInt();
        vaciar();
        agregarSala();
    }

    public ListaSalas(Sala inicio, Sala fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public ListaSalas() {
        this.inicio = null;
        this.fin = null;
    }

    private void agregarFinal(Sala nuevo) {
        if (this.vacia()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {

            this.fin.setNext(nuevo);
            this.fin = nuevo;
        }
    }

    public void agregarSala() {
        int i = 10;
        while (i <= (cantidadSalas * 10)) {
            this.agregarFinal(new Sala(i));
            i += 10;
        }

    }

    public void modificarFuncionesSala() {
        Scanner sc = new Scanner(System.in);
        System.out.println("   # Salas #  ");
        mostrarSalasNombre();
        int numSala = 0;
        do {
            System.out.print("Ingrese el numero de la sala:");
            numSala = sc.nextInt();
        } while (numSala <= cantidadSalas && numSala > 0);
        System.out.println("   # Peliculas #  ");

        new ListaPeliculas().mostrarPeliculasNombre();
        int numPelicula = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula :");
            numPelicula = sc.nextInt();
        } while (numPelicula <= ListaPeliculas.cantidadPeliculas && numPelicula > 0);
        System.out.println("   # Formato #  ");
        System.out.println("1- 3D");
        System.out.println("2- 2D");
        int numFormato = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula :");
            numFormato = sc.nextInt();
        } while (!(numFormato == 1 || numFormato == 2));

        buscarPorPosicion(numSala).setPelicula(new ListaPeliculas().buscarPorPosicion(numPelicula));
        buscarPorPosicion(numSala).setTipoFormato(numFormato);

    }
    
    /*
    public void agregarFuncionesSala() {
        if (cantidadPeliculas>0) {
            
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.println("   # Salas #  ");
  ///// le estoy 
        System.out.println("   # Peliculas #  ");

        new ListaPeliculas().mostrarPeliculasNombre();
        int numPelicula = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula :");
            numPelicula = sc.nextInt();
        } while (numPelicula <= ListaPeliculas.cantidadPeliculas && numPelicula > 0);
        System.out.println("   # Formato #  ");
        System.out.println("1- 3D");
        System.out.println("2- 2D");
        int numFormato = 0;
        do {
            System.out.print("Ingresa el numero de la pelicula :");
            numFormato = sc.nextInt();
        } while (!(numFormato == 1 || numFormato == 2));

        buscarPorPosicion(numSala).setPelicula(new ListaPeliculas().buscarPorPosicion(numPelicula));
        buscarPorPosicion(numSala).setTipoFormato(numFormato);

    }
    */


    public Sala buscarPorPosicion(int index) {
        Sala aux = this.inicio;
        int i = 1;
        while (aux != null) {
            if (i == index) {
                return aux;
            }
            i++;
            aux = aux.getNext();
        }
        return null;

    }

    public void mostrarSalasNombre() {
        Sala aux = this.inicio;
        System.out.printf("   %-20s", "Nombre");
        System.out.println();
        int i = 1;
        while (aux != null) {
            System.out.print(i + " =");
            System.out.printf("%-20s", aux.getNumSala());
            System.out.println();
            aux = aux.getNext();
            i++;

        }
    }
    public void vaciar(){
    this.inicio=null;
    }
    public boolean vacia() {
        return this.inicio == null;
    }

}
