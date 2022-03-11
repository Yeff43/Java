package com.company;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Contacto[] agenda;

    public static void main(String[] args) {
	/*
EJERCICIO 1: Nos piden realizar una agenda telefónica de contactos.
Un contacto está definido por un identificador (se debe poner automáticamente según el numero de contactos
que tengamos), un nombre y un teléfono.
Una agenda de contactos está formada por un conjunto de contactos. Se podrá crear de dos formas,
indicándoles nosotros el tamaño o con un tamaño por defecto (10)
Los métodos de la agenda serán los siguientes:

    • aniadirContacto(Contacto c): Añade un contacto a la agenda, sino se pueden meter más a la
        agenda se indicara por pantalla. No se pueden meter contactos que existan, es decir, no podemos
        duplicar nombres, aunque tengan distinto teléfono.
    • existeContacto(Conctacto c): indica si el contacto pasado existe o no.
    • listarContactos(): Lista toda la agenda
    • buscaContacto(String nombre): busca un contacto por su nombre y muestra su teléfono.
    • eliminarContacto(Contacto c): elimina el contacto de la agenda, indica si se ha eliminado o no por
        pantalla
    • agendaLlena(): indica si la agenda está llena.
    • huecosLibres(): indica cuantos contactos más podemos meter.
Crea un menú con opciones por consola para probar todas estas funcionalidades.
	 */
        int opcion;

        establecertamanio();

        do {
            opcion = menu();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    anadirContacto(pedirDatosContacto());
                    break;
                case 2:
                    listarAgenda();
                    break;
                case 3:// Buscar Contacto
                    buscarContacto();
                    break;
                case 4:
                    eliminarContacto(pedirDatosContacto());
                    break;
                case 5:
                    huecosLibres();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 6);
    }

    private static void eliminarContacto(Contacto c) {

        if (existeContacto(c)) {
            for (int i = 0; i < agenda.length; i++) {
                if (agenda[i] != null && agenda[i].equals(c)) {
                    agenda[i] = null;
                }
            }
        }

        System.out.println("Contacto Eliminado de la Agenda");
    }

    private static void buscarContacto() {
        String telefonoContacto;
        System.out.println("Cual es el nombre del contacto que quieres BUSCAR?");
        telefonoContacto = sc.nextLine();

        for (Contacto c : agenda) {
            if (c != null && c.getTelefono().equalsIgnoreCase(telefonoContacto)) {
                System.out.println("Contacto Encontrado!!");
                c.toString();
            } else {
                System.out.println("El contacto no existe");
            }
        }

        if (!telefonoContacto.equalsIgnoreCase("")) {
            System.out.println("El contacto es " + telefonoContacto);
        } else {
            System.out.println("El contacto no existe");
        }
    }

    private static void huecosLibres() {
        int contador = 0;
        for (Contacto c : agenda) {
            if (c == null) {
                contador++;
            }
        }
        System.out.println("Quedan " + contador + "huecos libres en la Agenda");
    }

    private static void listarAgenda() {
        for (Contacto c : agenda) {
            if (c != null) {
                System.out.println(c.toString());
            }
        }
    }

    private static void anadirContacto(Contacto c) {
        if (agendaLlena()) {
            //Si agenda esta llena el intento de crear amigo no se contabiliza
            System.out.println("AGENDA LLENA!!!!");
            Contacto.setContContacto(Contacto.getContContacto() - 1);
        } else {

            if (existeContacto(c)) {
                System.out.println("Ese amigo ya esta");
                //Si el amigo ya esta, pues nose contabiliza
                Contacto.setContContacto(Contacto.getContContacto() - 1);
            } else {
                for (int i = 0; i < agenda.length; i++) {
                    if (agenda[i] == null) {
                        agenda[i] = c;
                        break;
                    }
                }
                System.out.println("Contacto Guardado");
            }
        }
    }

    private static boolean existeContacto(Contacto c) {
        for (Contacto contacto : agenda) {
            if (contacto != null && contacto.equals(c)) {
                return true;
                //Todo objeto por defecto puede usar una clase llamada equals ( == )
            }
        }
        return false;
    }

    private static boolean agendaLlena() {
        for (Contacto c : agenda) {
            if (c == null) {
                return false;
            }
        }
        return true;
    }

    private static Contacto pedirDatosContacto() {
        Contacto c;
        String nombre, telefono;

        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Telefono: ");
        telefono = sc.nextLine();

        c = new Contacto(nombre, telefono);

        return c;
    }

    private static int menu() {
        System.out.println("***** Elige una Opcion *****");
        System.out.println("1. Añadir Contactos");
        System.out.println("2. Listar Agenda");
        System.out.println("3. Buscar Contacto");
        System.out.println("4. Eliminar Contacto");
        System.out.println("5. Huecos Libres");
        System.out.println("6. Salir");
        return sc.nextInt();
    }

    private static void establecertamanio() {
        String respuesta;
        int tamanio;
        System.out.println("Quieres poner el tamaño de la agenda");
        respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("SI")) {
            System.out.println("¿Cuantos amigos tienes?");
            tamanio = sc.nextInt();
            agenda = new Contacto[tamanio];

        } else {
            agenda = new Contacto[Contacto.LIMITE];
        }
    }
}
