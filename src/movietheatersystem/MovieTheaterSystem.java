package movietheatersystem;

import java.util.Scanner;

/**
 *
 * @authors Beverly Urias & José Ceballos
 */
public class MovieTheaterSystem {

    public ListaPeliculas getPeliculas() {
        return peliculas;
    }

    ListaPeliculas peliculas = new ListaPeliculas();
    ListaSalas salas = new ListaSalas();
    Util metodos = new Util();

    public static void main(String[] args) {
        MovieTheaterSystem obj = new MovieTheaterSystem();
       
        obj.salas.configuracionInicialAsientos();
        obj.peliculas.peliculasEjemplo();
        obj.menu();
    }

    public void menu() {

        
        int opc;
        String[] opcionesMenu = {
            "Venta de boletos",
            "Configuración del cine",
            "Informes del cine"};
        do {
            metodos.label("Menú principal");
            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Salir");
            opc = metodos.opcion();
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
        int opc;
        String[] opcionesMenu = {
            "Fila de clientes",
            "Atención a clientes"};
        do {
            metodos.label("Submenú Ventas");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    this.miniMenuVentasFila();
                    break;
                case 2:
                    this.miniMenuVentasAtender();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuConfiguracion() {
        int opc;
        String[] opcionesMenu = {
            "Administrar peliculas",
            "Administración de funciones en salas",
            "Administración de costos",
            "Mostrar funciones y costos acutuales",
            "Configurar general del cine",
            "Mostrar configuración general actual"};
        do {
            metodos.label("Submenú Configuración");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    this.miniMenuConfiguracionCartelera();
                    break;
                case 2:
                    metodos.label(opcionesMenu[opc - 1]);
                    if (peliculas.cantidadPeliculas == 0) {
                        System.out.println("No se puede configurar funciones sala si no hay peliculas, ingrese opcion 1 para agregar peliculas");
                    } else {
                        this.miniMenuConfiguracionFuncionesSala();
                    }
                    break;
                case 3:
                    this.miniMenuConfiguracionCostos();
                    break;
                case 4:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo que muestra las peliculas por sala y costos.");
                    break;
                case 5:

                    this.miniMenuConfiguracionCine();
                    break;
                case 6:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo que muestra la configuracion general del cine, no de salas y asientos");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void subMenuInformes() {
        int opc;
        String[] opcionesMenu = {
            "Ganancias",
            "Voletos vendidos",
            "Voletos cancelados",
            "Estadisticas por edad",
            "Estadisticas de preferencia por pelicula",
            "Estadisticas de preferencia por formato"};
        do {
            metodos.label("Submenú Informes");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar las ganancias");
                    break;
                case 2:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar candidad de voletos vendidos.");
                    break;
                case 3:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar los voletos cancelados.");
                    break;
                case 4:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar estdisticas por edad(niños, adultos, a mayores");
                    break;
                case 5:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar estdisticas de preferencia por pelicula");
                    break;
                case 6:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar estdisticas de preferencia por formato (tradicional, 3D)");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void miniMenuVentasFila() {
        int opc;
        String[] opcionesMenu = {
            "Formar cliente en cola",
            "Sacar cliente de cola",
            "Mostrar clientes formados"};
        do {
            metodos.label("Mini menú Ventas - Fila");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para ingresar cliente a la cola.");
                    break;
                case 2:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para sacar cliente a la cola.");
                    break;
                case 3:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar a los clientes a la cola.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void miniMenuVentasAtender() {
        int opc;
        String[] opcionesMenu = {
            "Vender boleto",
            "Cancelación de boleto"};
        do {
            metodos.label("Mini menú Ventas - Atender");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para vender boleto (pelicula, cantidad, tipo)");
                    break;
                case 2:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para cancelar boleto(devolucion)");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void miniMenuConfiguracionCine() {
        int opc;
        String[] opcionesMenu = {
            "Número de salas",
            "Asientos en salas"};
        do {
            metodos.label("Mini menú Configuración - Cine");
            System.out.println("NOTA: Estas opciones vuelven a inicializar la lista de salas ");
            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    metodos.label(opcionesMenu[opc - 1]);
                    salas.configuracionSalas();
                    break;
                case 2:
                    metodos.label(opcionesMenu[opc - 1]);
                    salas.configuracionInicialAsientos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void miniMenuConfiguracionCartelera() {
        int opc;
        String[] opcionesMenu = {
            "Ver peliculas",
            "Agregar nueva",
            "Modificar",
            "Eliminar"
        };
        do {
            metodos.label("Mini menú Configuración - Peliculas");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    metodos.label(opcionesMenu[opc - 1]);
                    this.peliculas.mostrarPeliculas();
                    break;
                case 2:
                    metodos.label(opcionesMenu[opc - 1]);
                    this.peliculas.agregarPelicula();
                    break;
                case 3:
                    metodos.label(opcionesMenu[opc - 1]);
                    this.peliculas.modificarPelicula();
                    break;
                case 4:
                    metodos.label(opcionesMenu[opc - 1]);
                    this.peliculas.eliminarPelicula();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void miniMenuConfiguracionFuncionesSala() {
        Scanner sc = new Scanner(System.in);
        int opc;
        String[] opcionesMenu = {
            "Asignar pelicula a sala (+formato) ",
            "Modificar pelicula a sala",
            "Mostrar peliculas a sala "};
        do {
            metodos.label("Mini menú Configuración - peliculas a Salas");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    metodos.label(opcionesMenu[opc - 1]);
                    this.salas.agregarFuncionesSala();
                    break;
                case 2:
                    metodos.label(opcionesMenu[opc - 1]);
                    this.salas.modificarFuncionesSala();
                    break;
                case 3:
                    metodos.label(opcionesMenu[opc - 1]);
                    this.salas.mostrarSalasFunciones();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void miniMenuConfiguracionCostos() {
        int opc;
        String[] opcionesMenu = {
            "Función tradicional",
            "Función 3D",
            "Descuento a adultos mayores",
            "Descuento a niños"};
        do {
            metodos.label("Mini menú Administración - Costos");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = metodos.opcion();
            switch (opc) {
                case 1:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el costo de funcion tradicional.");
                    break;
                case 2:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el costo de funcion 3D.");
                    break;
                case 3:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el % de descuento a adultos mayores.");
                    break;
                case 4:
                    metodos.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el % de descuento a niños.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

}
