package movietheatersystem;

/**
 *
 * @authors Beverly Urias & José Ceballos
 */
public class MovieTheaterSystem {

    ListaPeliculas peliculas = new ListaPeliculas();
    ListaSalas listaSalas = new ListaSalas();
    Util util = new Util();
    CustomerQueue customerQueue = new CustomerQueue();
    float costo2D = 20, costo3D = 30, descuentoTercera = 15, descuentoNinos = 10;

    public static void main(String[] args) {
        MovieTheaterSystem obj = new MovieTheaterSystem();
        obj.superEtiqueta();
        System.out.println();
        obj.listaSalas.configuracionInicial(5, 35);
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
            if (opc == 0) {
                char opcDos;
                System.out.print("¿Está seguro de salir del sistema? [S/s]");
                opcDos = Character.toLowerCase(util.inputChar());
                if (opcDos != 's') {
                    opc = 555;
                }
            }
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
                case 555:
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
                    if (!customerQueue.empty()) {
                        if (!listaSalas.algunaSalaConPelicula()) {
                            System.out.println("\nTodavía no hay funciones en las salas");
                        } else {
                            this.miniMenuVentasAtender();
                        }
                    } else {
                        System.out.println("\nNo hay clientes formados en fila para compra o cancelación de boleto.");
                    }
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
                        System.out.println("No se puede configurar funciones sala si no hay películas, ingrese opción 1 para agregar peliculas");
                    } else {
                        this.miniMenuConfiguracionFuncionesSala();
                    }
                    break;
                case 3:
                    this.miniMenuConfiguracionCostos();
                    break;

                case 4:

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
            "Estadisticas ventas",
            "Estadisticas peliculas",
            "Informacion Salas de ticket (nombres,costo,folio)",
            "Informacion por formato"
        };
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
                    this.estadisticasSala();
                    break;
                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    this.estadisticasPelicula();
                    break;
                case 3:
                    util.label(opcionesMenu[opc - 1]);
                    if (listaSalas.salaConBoletosVendidosPelicula()) {
                        this.informacionSalas();
                    } else {
                        if (!listaSalas.algunaSalaConPelicula()) {
                            System.out.println("Las Salas todavia no tiene pelicula");
                        } else {
                            System.out.println("Todavia no hay boletos vendidos");
                        }
                    }
                    break;
                case 4:
                     estadisticasFormato();
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
        boolean atendido = false;
        String[] opcionesMenu = {
            "Vender boleto",
            "Cancelación de boleto"};
        do {
            util.label("Mini menú Ventas - Atender");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            int opc;
            opc = util.opcion();
            switch (opc) {
                case 1:
                    if (listaSalas.salaConBoletosPelicula()) {
                        serveCustumer();
                        atendido = true;
                    } else {
                        System.out.println("No hay salas con boletos ni funciones disponibles! ");
                    }

                    break;

                case 2:
                    util.label(opcionesMenu[opc - 1]);
                    if (listaSalas.cantidadPersonas() != 0) {
                        atendido = cancelarVenta();
                    } else {
                        System.out.println("Todavia no se ha vendido ningun boleto.");
                    }
                    break;
                case 0:
                    atendido = true;
                    break;
                default:
                    System.out.println("Opción no valida.");
            }

        } while (!atendido);
    }

    public void miniMenuConfiguracionCine() {
        int opc;
        String[] opcionesMenu = {
            "Número de salas",
            "Número de asientos",
            "Mostrar valores actuales"
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
                case 3:
                    util.label(opcionesMenu[opc - 1]);
                    listaSalas.datosSalasAsientos();
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
        int opc;
        String[] opcionesMenu = {
            "Asignar pelicula y formato a sala ",
            "Modificar sala",
            "Mostrar salas"};
        do {
            util.label("Mini menú Configuración - peliculas a Salas");

            for (int i = 0; i < opcionesMenu.length; i++) {
                System.out.println((i + 1) + " - " + opcionesMenu[i]);
            }
            System.out.println("0 - Atrás");
            opc = util.opcion();
            switch (opc) {
                case 1:
                    this.listaSalas.agregarFuncionesSala(peliculas);
                    break;
                case 2:
                    this.listaSalas.modificarFuncionesSala(peliculas);
                    break;
                case 3:
                    util.label(opcionesMenu[opc - 1]);
                    this.listaSalas.mostrarSalasConPelicula();
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
            System.out.println("Al cambiar costos se reconfigura el sistema. Listas de salas y número de asientos.");
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
                    datosCosto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }

    public void datosCosto() {
      System.out.println("\n     - Costos de peliculas tradicionales - ");
        System.out.println("                  Costo 2D: " + costo2D
                +        "\n                  Costo 3D: " + costo2D);
      System.out.println("\n     - Descuentos por tipo de personas - ");
        System.out.println("                     Ninos: " + descuentoNinos
           +             "\n      Adultos tercera edad: " + descuentoTercera);
      System.out.println("\n     - Costos asociados - ");
        System.out.println("                Niños - 2D: " + costo2D * ((100 - descuentoNinos) / 100)
                +        "\n                Niños - 3D: " + costo3D * ((100 - descuentoNinos) / 100)
                +        "\n              Adultos - 2D: " + costo2D
                +        "\n              Adultos - 3D: " + costo3D
                +        "\n Adultos tercera edad - 2D: " + costo2D * ((100 - descuentoTercera) / 100)
                +        "\n Adultos tercera edad - 3D: " + costo3D * ((100 - descuentoTercera) / 100));
    }

    public int obtenerCosto(int opc) {
        int costo = 0;
        do {
            if (opc == 1) {
                System.out.print("Ingresa costo nuevo");
            } else {
                System.out.print("Ingresa descuento nuevo(0-100)");
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

    public boolean cancelarVenta() {
        System.out.print("Ingresa folio");
        String folio = util.inputText();
        if (listaSalas.buscarFolio(folio)) {

            System.out.println("Eliminado!!");
            String name = customerQueue.remove().getName();
            System.out.println("Fue un gusto atenderle " + name);
            return true;
        } else {
            System.out.println("No se encontró elemento");
            return false;
        }

    }

    public void serveCustumer() {
        String name = customerQueue.remove().getName();

        listaSalas.mostrarSalasConBoletoYPeliculas();
        int numSala = 0;

        System.out.print("\n¡Bienvenido " + name + "!\n");
        do {
            System.out.print("Ingrese el número de la sala");
            numSala = util.inputInteger();
        } while (!(numSala <= listaSalas.cantidadSalas && numSala > 0
                && obtenerSala(numSala).pelicula != null
                && obtenerSala(numSala).capacidadSala - obtenerTicketList(numSala).cantidadPersonas() != 0));

        int boletos;
        util.label("Datos para venta");
        do {
            System.out.print("¿Cuántos lugares desea?");
            boletos = util.inputInteger();
            if (!(boletos > 0)) {
                System.out.println("Tiene que ser mayor a cero");
            } else if (!(boletos <= (obtenerSala(numSala).capacidadSala - obtenerTicketList(numSala).cantidadPersonas()))) {
                System.out.println("Ingrese una cantidad menor o igual a "
                        + (obtenerSala(numSala).capacidadSala - obtenerTicketList(numSala).cantidadPersonas()));
            }

        } while (!(boletos > 0
                && boletos <= (obtenerSala(numSala).capacidadSala - obtenerTicketList(numSala).cantidadPersonas())));

        int total, ticketKids, ticketStandard, ticketElderly;

        do {
            util.label("Desglose de boletos");
            System.out.printf("%12s", "Niños");
            ticketKids = util.inputInteger();
            System.out.printf("%12s", "Estandar");
            ticketStandard = util.inputInteger();
            System.out.printf("%12s", "Tercera edad");
            ticketElderly = util.inputInteger();
            total = ticketKids + ticketStandard + ticketElderly;
            if (total != boletos) {
                System.out.println("\nLa cantidades de cada categoria no son las adecuadas para " + boletos + " persona");
            }
        } while (!(total == boletos));

        float costo;

        if (listaSalas.buscarSalaPorPosicion(numSala).getTipoFormato() == 1) {
            costo = costo3D;
        } else {
            costo = costo2D;
        }

        float totalTicket = (ticketStandard * costo)
                + (ticketKids * costo * ((100 - descuentoNinos) / 100))
                + (ticketElderly * costo * ((100 - descuentoTercera) / 100));

        obtenerTicketList(numSala)
                .formarTicketParaAnadir(listaSalas.obtenerFolio(numSala),
                        name, ticketStandard, ticketKids, ticketElderly, totalTicket);

        listaSalas.mostrarDatosSalaPF(numSala);
        System.out.println(numSala+"-  Sala "+ obtenerSala(numSala).numSala );
        obtenerTicketList(numSala).getFin()
                .mostrarTicket(costo, descuentoNinos, descuentoTercera);

        float efectivo;
        do {
            System.out.print("¿Con cuánto paga?");
            efectivo = util.inputInteger();
        } while (!(efectivo >= totalTicket));

        System.out.println("Su cambio es: $" + (efectivo - totalTicket));

    }

    public TicketList obtenerTicketList(int numSala) {
        return listaSalas.buscarSalaPorPosicion(numSala).getTicketList();

    }

    public Sala obtenerSala(int numSala) {
        return listaSalas.buscarSalaPorPosicion(numSala);

    }

    public boolean SePuedeVenderBoletos(int numSala) {
        return (listaSalas.buscarSalaPorPosicion(numSala).capacidadSala
                - listaSalas.buscarSalaPorPosicion(numSala).getTicketList().cantidadPersonas()) != 0;

    }

    public void estadisticasSala() {
        if (this.listaSalas.cantidadSalas > 0) {
            Sala aux = this.listaSalas.inicio;
            System.out.printf("|| %-4s |", "SALA");
            System.out.printf("| %-7s ", "FORMATO");
            System.out.printf("| %-22s |", "PELICULA");
            System.out.printf("| %-8s ", "VENDIDOS");
            System.out.printf("| %-5s ", "NIÑOS");
            System.out.printf("| %-6s ", "NORMAL");
            System.out.printf("| %-7s |", "A MAYOR");
            System.out.printf("| %-6s |", "FOLIOS");
            System.out.printf("| %-8s ||", "GANANCIA");
            System.out.println();
            while (aux != null) {
                Ticket ticket = aux.getTicketList().totalesTickets();
                System.out.printf("|| %-4s |", aux.numSala);
                if (aux.pelicula != null) {
                    System.out.printf("| %-7s ", aux.escribirFormato(aux.tipoFormato));
                    System.out.printf("| %-22s |", aux.pelicula.getNombre());
                } else {
                    System.out.printf("| %-7s ", "----");
                    System.out.printf("| %-22s |", "----");
                }
                System.out.printf("| %-8s ", aux.getTicketList().cantidadPersonas());
                System.out.printf("| %-5s ", ticket.getTicketKids());
                System.out.printf("| %-6s ", ticket.getTicketStandard());
                System.out.printf("| %-7s |", ticket.getTicketElderly());
                System.out.printf("| %-6s |", aux.getTicketList().obtenerCantidadBoletos());
                System.out.printf("| %-8s ||", ticket.getTotal());
                System.out.println();
                aux = aux.getNext();
            }

            Ticket total = this.listaSalas.totalesTicketsCine();
            System.out.printf("|| %-40s |", "       T O T A L E S");
            System.out.printf("| %-8s ", listaSalas.cantidadPersonas());
            System.out.printf("| %-5s ", total.getTicketKids());
            System.out.printf("| %-6s ", total.getTicketStandard());
            System.out.printf("| %-7s |", total.getTicketElderly());
            System.out.printf("| %-6s |", listaSalas.obtenerCantBoletosSalas());
            System.out.printf("| %-8s ||", total.getTotal());
            System.out.println();
        } else {
            System.out.println("No hay información.");
        }
    }

    public void informacionSalas() {
        listaSalas.mostrarSalasConBoletoVendidosYPelicula();
        int numSala = 1;

        while (numSala <= listaSalas.cantidadSalas) {
            if (obtenerSala(numSala).pelicula != null
                    && obtenerTicketList(numSala).cantidadPersonas() != 0) {
                     util.label("Informacion Sala");
                System.out.print(" Sala " + obtenerSala(numSala).numSala+":  ");
                listaSalas.mostrarInfSala(obtenerTicketList(numSala).inicio);
                System.out.println("");
            }
            numSala++;
        }

    }

    public void estadisticasPelicula() {
        if (this.peliculas.cantidadPeliculas() <= 0) {
            System.out.println("No hay información.");
        } else {
            Pelicula aux = this.peliculas.inicio;

            System.out.printf("|| %-22s |", "     PELICULA         ");
            System.out.printf("| %-8s ", "VENDIDOS");
            System.out.printf("| %-8s ", "NIÑOS");
            System.out.printf("| %-8s ", "NORMAL");
            System.out.printf("| %-8s |", "A  MAYOR");
            System.out.printf("| %-9s |", "N BOLETOS");
            System.out.printf("| %-8s ||", "GANANCIA");
            System.out.println();
            while (aux != null) {
                Ticket ticket = listaSalas.totalesTicketsPelicula(aux.getNombre());
                System.out.printf("|| %-22s |", aux.getNombre());
                System.out.printf("| %-8s ", listaSalas.cantidadPersonasPelicula(aux.getNombre()));

                System.out.printf("| %-8s ", ticket.getTicketKids());
                System.out.printf("| %-8s ", ticket.getTicketStandard());
                System.out.printf("| %-8s |", ticket.getTicketElderly());
                System.out.printf("| %-9s |", listaSalas.obtenerCantidadBoletos(aux.getNombre()));
                System.out.printf("| %-8s ||", ticket.getTotal());
                System.out.println();
                aux = aux.getSigue();
            }

            Ticket total = this.listaSalas.totalesTicketsCine();
            System.out.printf("|| %-22s |", "      TOTALES         ");
            System.out.printf("| %-8s ", listaSalas.cantidadPersonas());
            System.out.printf("| %-8s ", total.getTicketKids());
            System.out.printf("| %-8s ", total.getTicketStandard());
            System.out.printf("| %-8s |", total.getTicketElderly());
            System.out.printf("| %-9s |", listaSalas.obtenerCantBoletosSalas());
            System.out.printf("| %-8s ||", total.getTotal());
        }
    }

    public void estadisticasFormato() {
        if (!this.listaSalas.algunaSalaConPelicula()) {
            System.out.println("No hay información.");
        } else {
            int i=1;

            System.out.printf("|| %-9s |", " Formato ");
            System.out.printf("| %-8s ", "Vendidos");
            System.out.printf("| %-8s ", "Niños");
            System.out.printf("| %-8s ", "Normal");
            System.out.printf("| %-8s |", "A. mayor");
            System.out.printf("| %-9s |", "N.Boletos");
            System.out.printf("| %-8s ||", "Ganancia");
            System.out.println();
            while (i<=2) {
                Ticket ticket = listaSalas.totalesTicketsFormato(i);
                System.out.printf("|| %-9s |",listaSalas.inicio.escribirFormato(i));
                System.out.printf("| %-8s ", listaSalas.cantidadPersonasFormato(i));

                System.out.printf("| %-8s ", ticket.getTicketKids());
                System.out.printf("| %-8s ", ticket.getTicketStandard());
                System.out.printf("| %-8s |", ticket.getTicketElderly());
                System.out.printf("| %-9s |", listaSalas.cantidadPersonasFormato(i));
                System.out.printf("| %-8s ||", ticket.getTotal());
                System.out.println();
               i++;
            }

            Ticket total = this.listaSalas.totalesTicketsCine();
            System.out.printf("|| %-9s |", " Totales ");
            System.out.printf("| %-8s ", listaSalas.cantidadPersonas());
            System.out.printf("| %-8s ", total.getTicketKids());
            System.out.printf("| %-8s ", total.getTicketStandard());
            System.out.printf("| %-8s |", total.getTicketElderly());
            System.out.printf("| %-9s |", listaSalas.obtenerCantBoletosSalas());
            System.out.printf("| %-8s ||", total.getTotal());
        }
    }

    public void superEtiqueta() {
        System.out.println("                           __^__                                      __^__");
        System.out.println("                          ( ___ )------------------------------------( ___ )");
        System.out.println("                           | / |                                      | \\ |");
        System.out.println("                           | / |      Movie Theater System 2018       | \\ |");
        System.out.println("                           |___|                                      |___|");
        System.out.print("                          (_____)------------------------------------(_____)");
    }
}
