package movietheatersystem;

import java.util.Scanner;

/**
 *
 * @authors Beverly Urias & José Ceballos
 */
public class MovieTheaterSystem {

    ListaPeliculas peliculas = new ListaPeliculas();
    ListaSalas salas = new ListaSalas();
    Util util = new Util();
    CustomerQueue clients = new CustomerQueue();
    TicketList tickets = new TicketList();

    public static void main(String[] args) {
        MovieTheaterSystem obj = new MovieTheaterSystem();

        obj.salas.configuracionInicial();
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
            util.label("Menú principal");
            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Salir");
            opc = util.opcion();
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
            util.label("Submenú Ventas");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
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
            util.label("Submenú Configuración");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    this.miniMenuConfiguracionCartelera();
                    break;
                case 2:
                    if (peliculas.cantidadPeliculas() == 0) {
                        System.out.println("No se puede configurar funciones sala si no hay peliculas, ingrese opcion 1 para agregar peliculas");
                    } else {
                        this.miniMenuConfiguracionFuncionesSala();
                    }
                    break;
                case 3:
                    this.miniMenuConfiguracionCostos();
                    break;
                case 4:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo que muestra las peliculas por sala y costos.");
                    break;
                case 5:

                    this.miniMenuConfiguracionCine();
                    break;
                case 6:
                    util.label(opcionesMenu[opc - 1]);
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
            util.label("Submenú Informes");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar las ganancias");
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar candidad de voletos vendidos.");
                    break;
                case 3:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar los voletos cancelados.");
                    break;
                case 4:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar estdisticas por edad(niños, adultos, a mayores");
                    break;
                case 5:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para mostrar estdisticas de preferencia por pelicula");
                    break;
                case 6:
                    util.label(opcionesMenu[opc - 1]);
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
            "Mostrar clientes formados"};
        do {
            util.label("Mini menú Ventas - Fila");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    util.label(opcionesMenu[opc - 1]);
                    clients.newClient();
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    clients.show();
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
            util.label("Mini menú Ventas - Atender");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    util.label(opcionesMenu[opc - 1]);

                    if (clients.empty()) {
                        System.out.println("No hay más clientes formados!");
                    } else {
                        Client atendido = clients.serveCustumer(); // saca al primer cliente de la cola
                        System.out.print("Bienvenido! "+ atendido.getName()+
                                " ¿Cuál es su edad?");
                        int edad = util.inputInteger();
                        
                        // Falta: 
                        //consultar salas con peliculas y mostrar espacios
                        //preguntar cuantos asientos comprara
                        //validar que en la sala queden esos espacios disponibles
                        //preguntar tipo voleto(normal, niño, adulto mayor)
                        //calcular costo total
                        //confirmar venta de boletos
                        //Sí: descontar a la sala los lugares comprados
                        //mandar datos a metodo en tickets
                        //Ticket ticketVendido = tickets.addTicket(clienteAtendido.getName, );
                    }

                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
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
            "numero de salas", "numero de asientos"

        };
        do {
            util.label("Mini menú Configuración - Cine");
            System.out.println("NOTA: Estas opciones vuelven a inicializar la lista de salas ");
            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    util.label(opcionesMenu[opc - 1]);
                    salas.configuracionSalas();
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    salas.configuracionAsientos();
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
            util.label("Mini menú Configuración - Peliculas");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    util.label(opcionesMenu[opc - 1]);
                    this.peliculas.mostrarPeliculas();
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    this.peliculas.agregarPelicula();
                    break;
                case 3:
                    util.label(opcionesMenu[opc - 1]);
                    this.peliculas.modificarPelicula();
                    break;
                case 4:
                    util.label(opcionesMenu[opc - 1]);
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
            util.label("Mini menú Configuración - peliculas a Salas");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    util.label(opcionesMenu[opc - 1]);
                    this.salas.agregarFuncionesSala(peliculas);
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    this.salas.modificarFuncionesSala(peliculas);
                    break;
                case 3:
                    util.label(opcionesMenu[opc - 1]);
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
            util.label("Mini menú Administración - Costos");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el costo de funcion tradicional.");
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el costo de funcion 3D.");
                    break;
                case 3:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("//Metodo para modificar el % de descuento a adultos mayores.");
                    break;
                case 4:
                    util.label(opcionesMenu[opc - 1]);
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
