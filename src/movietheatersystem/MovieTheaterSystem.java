package movietheatersystem;

import java.util.Scanner;

/**
 *
 * @authors Beverly Urias & José Ceballos
 */
public class MovieTheaterSystem {

    ListaPeliculas peliculas = new ListaPeliculas();
    Sala salas = new Sala();

    public static void main(String[] args) {
        MovieTheaterSystem obj = new MovieTheaterSystem();
        obj.menu();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Venta de boletos",
            "Configuración del cine",
            "Informes del cine"};
        do {
            this.label("Menú principal");
            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Salir");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.subMenuVentas();
                    break;
                case 2:
                    this.subMenuConfiguracion();
                    break;
                case 3:
                    this.subMenuInformes();
                    break;
                case 0:
                    System.out.println("Gracias por su preferencia. Adios.");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuVentas() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Fila de clientes",
            "Atención a clientes"};
        do {
            this.label("Submenú Ventas");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.subMenuVentasFila();
                    break;
                case 2:
                    this.subMenuVentasAtender();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuVentasFila() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Formar cliente en cola",
            "Sacar cliente de cola",
            "Mostrar clientes formados"};
        do {
            this.label("Mini menú Ventas - Fila");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para ingresar cliente a la cola.");
                    break;
                case 2:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para sacar cliente a la cola.");
                    break;
                case 3:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar a los clientes a la cola.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuVentasAtender() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Vender boleto",
            "Cancelación de boleto"};
        do {
            this.label("Mini menú Ventas - Atender");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para vender boleto (pelicula, cantidad, tipo)");
                    break;
                case 2:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para cancelar boleto(devolucion)");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuConfiguracion() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Administrar cartelera",
            "Administración de funciones en salas",
            "Administración de costos",
            "Mostrar funciones y costos acutuales",
            "Configurar general del cine",
            "Mostrar configuración general actual"};
        do {
            this.label("Submenú Configuración");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.subMenuConfiguracionCartelera();
                    break;
                case 2:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo que permita asignar una funcion a una sala.");
                    break;
                case 3:
                    this.subMenuConfiguracionCostos();
                    break;
                case 4:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo que muestra las peliculas por sala y costos.");
                    break;
                case 5:
                    this.subMenuConfiguracionCine();
                    break;
                case 6:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo que muestra la configuracion general del cine, no de salas y asientos");

                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuConfiguracionCine() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Número de salas",
            "Asientos en salas"};
        do {
            this.label("Mini menú Configuración - Cine");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo que permita definir el número de salas de cine.");
                    break;
                case 2:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo que permita definer asisentos por sala de cine.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuConfiguracionCartelera() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Agregar pelicula",
            "Eliminar pelicula",
            "Ver peliculas"};
        do {
            this.label("Mini menú Configuración - Cine");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.label(opcionesMenu[opc - 1]);
                    this.peliculas.agregarPelicula();
                    break;
                case 2:
                    this.label(opcionesMenu[opc - 1]);
                    this.peliculas.eliminarPelicula();
                    break;
                case 3:
                    this.label(opcionesMenu[opc - 1]);
                    this.peliculas.mostrarPeliculas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuConfiguracionCostos() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Función tradicional",
            "Función 3D",
            "Descuento a adultos mayores",
            "Descuento a niños"};
        do {
            this.label("Mini menú Administración - Costos");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el costo de funcion tradicional.");
                    break;
                case 2:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el costo de funcion 3D.");
                    break;
                case 3:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el % de descuento a adultos mayores.");
                    break;
                case 4:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el % de descuento a niños.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuInformes() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Ganancias",
            "Voletos vendidos",
            "Voletos cancelados",
            "Estadisticas por edad",
            "Estadisticas de preferencia por pelicula",
            "Estadisticas de preferencia por formato"};
        do {
            this.label("Submenú Informes");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = this.opcion();
            switch (opc) {
                case 1:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar las ganancias");
                    break;
                case 2:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar candidad de voletos vendidos.");
                    break;
                case 3:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar los voletos cancelados.");
                    break;
                case 4:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar estdisticas por edad(niños, adultos, a mayores");
                    break;
                case 5:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar estdisticas de preferencia por pelicula");
                    break;
                case 6:
                    this.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar estdisticas de preferencia por formato (tradicional, 3D)");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void label(String cadena) {
        int ancho = 50;
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
        return sc.nextInt();
    }

}
