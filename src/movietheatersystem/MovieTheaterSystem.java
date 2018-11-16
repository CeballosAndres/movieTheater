package movietheatersystem;

import java.util.Scanner;

/**
 *
 * @authors Beverly Urias & José Ceballos
 */
public class MovieTheaterSystem {

    ListaPeliculas peliculas = new ListaPeliculas();
    ListaSalas listaSalas = new ListaSalas();
    Util util = new Util();
    CustomerQueue customerQueue = new CustomerQueue();
    int costo2D = 20, costo3D = 30, descuentoTercera = 15, descuentoNinos = 10;

  

    public static void main(String[] args) {
        MovieTheaterSystem obj = new MovieTheaterSystem();

        obj.listaSalas.configuracionInicial();
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
            "Configurar general del cine",};
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

                case 5:

                    this.miniMenuConfiguracionCine();
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
                    customerQueue.newClient();
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    customerQueue.show();
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

                    if (customerQueue.empty()) {
                        System.out.println("No hay más clientes formados!");
                    } else {
                        customerQueue.serveCustumer(listaSalas, costo2D ,   costo3D,  descuentoTercera ,  descuentoNinos );
                        /*
                        Client atendido = clients.serveCustumer(); // saca al primer cliente de la cola
                        System.out.print("Bienvenido! "+ atendido.getName()+
                                " ¿Cuál es su edad?");
                        int edad = util.inputInteger();
                         */
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
                    listaSalas.configuracionSalas();
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    listaSalas.configuracionAsientos();
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
                    this.listaSalas.agregarFuncionesSala(peliculas);
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    this.listaSalas.modificarFuncionesSala(peliculas);
                    break;
                case 3:
                    util.label(opcionesMenu[opc - 1]);
                    this.listaSalas.mostrarSalasFunciones();
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
            "Función 2D",
            "Función 3D",
            "Descuento a adultos mayores",
            "Descuento a niños",
            "Mostrar costos actuales"
        };
        do {
            util.label("Mini menú Administración - Costos");
            System.out.println("Al cambiar costos se reconfigura el sistema :listas de salas y numero de asientos ");
            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    util.label(opcionesMenu[opc - 1]);
                    costo2D = obtenerCosto(1);

                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    costo3D = obtenerCosto(1);
                    break;
                case 3:
                    util.label(opcionesMenu[opc - 1]);
                    descuentoTercera = obtenerCosto(2);
                    break;
                case 4:
                    util.label(opcionesMenu[opc - 1]);
                    descuentoNinos = obtenerCosto(2);
                    break;
                case 5:
                    util.label(opcionesMenu[opc - 1]);
                    System.out.println("                       # Costos tradicionales # ");
                    System.out.println("costo 2D: " + costo2D
                            + " \n costo 3D: " + costo2D);
                    System.out.println("                       # Descuentos personas # ");
                    System.out.println("descuento ninos: " + descuentoNinos
                            + " \n descuento adultos tercera edad: " + descuentoTercera);
                    System.out.println("                       # Costos asociados # ");
                    System.out.println(" ninos - 2D: " + costo2D * ((100 - descuentoNinos) * 100)
                            + " \n ninos - 3D: " + costo3D * ((100 - descuentoNinos) * 100)
                            + " \n adultos - 2D: " + costo2D
                            + " \n adultos - 3D: " + costo3D
                            + " \n adultos tercera - 2D: " + costo2D * ((100 - descuentoTercera) * 100)
                            + " \n adultos tercera - 3D: " + costo3D * ((100 - descuentoTercera) * 100));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public int obtenerCosto(int opc) {
        int costo = 0;
        do {
            if (opc == 1) {
                System.out.print("Ingresa costo nuevo:");
            } else {
                System.out.print("Ingresa descuento nuevo( 0-100):");
            }

            costo = util.inputInteger();
        } while (!((costo > 0 && opc == 1)
                || (costo >= 0 && costo <= 100 && costo == 2)));
        
        int cantidadSalas = listaSalas.cantidadSalas;
        int asientos = listaSalas.inicio.capacidadSala;
        listaSalas.vaciar();
        listaSalas.agregarAsientosYSala(asientos, cantidadSalas);
        return costo;
    }

}
