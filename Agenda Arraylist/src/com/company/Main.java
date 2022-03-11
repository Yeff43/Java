package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contacto> agenda = new ArrayList<>();

    public static void main(String[] args) {
        int respuesta;
        do {
            Menu();
            respuesta = sc.nextInt();
            sc.nextLine();
            switch (respuesta){
                case 1:
                    AgregarContacto();
                    break;
                case 2:
                    ModificarContacto();
                    break;
                case 3:
                    EliminarContacto();
                    break;
                case 4:
                    ConsultarContacto();
                    break;
                case 5:
                    ListarContactos();
                    break;
                case 6:
                    OrdenarContacto();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a escoger");
                    break;
            }
        }while (respuesta != 7);
    }

    private static void OrdenarContacto() {
        Contacto c;
        for (int i = 0; i < agenda.size()-1; i++) {
            for (int j = i+1; j < agenda.size(); j++) {
                if (agenda.get(j).getNombre().compareTo(agenda.get(i).getNombre())<0){
                   c = agenda.get(i);
                   agenda.set(i,agenda.get(j));
                   agenda.set(j,c);
                }else{
                    if (agenda.get(j).getNombre().compareTo(agenda.get(i).getNombre()) == 0){
                        if (agenda.get(j).getApellidos().compareTo(agenda.get(i).getApellidos())<0){
                            c = agenda.get(i);
                            agenda.set(i,agenda.get(j));
                            agenda.set(j,c);
                        }
                    }
                }
            }
        }
    }

    private static void ConsultarContacto() {
        String nombre, apellidos;
        boolean encontrado = false;
        //Preguntar nombre y apellidos
        System.out.println("Nombre:");
        nombre = sc.nextLine();
        System.out.println("Apellidos:");
        apellidos = sc.nextLine();
        //Recorrer la lista
        for (int i = 0; i < agenda.size(); i++) {
            //en cada vuelta comprueba
            if (nombre.equalsIgnoreCase(agenda.get(i).getNombre()) && apellidos.equalsIgnoreCase(agenda.get(i).getApellidos())){
                //si coincide
                //muestra el telefono
                System.out.println("Telefono: "+agenda.get(i).getTelefono());
                encontrado = true;
            }
        }
        //si no coincide
        //avisa que no existe
        if (!encontrado){
            System.out.println("El contacto no existe");
        }
    }

    private static void EliminarContacto() {
        String nombre, apellidos;
        boolean encontrado = false;
        //Preguntar el nombre y apellido
        System.out.println("Nombre a eliminar");
        nombre = sc.nextLine();
        System.out.println("Apellidos a eliminar");
        apellidos = sc.nextLine();

        //Recorrer la agenda
        for (int i = 0; i < agenda.size(); i++) {
            //En cada vuelta comprobar si el contacto tiene ese nombre y ese apellido
            if (nombre.equalsIgnoreCase(agenda.get(i).getNombre()) && apellidos.equalsIgnoreCase(agenda.get(i).getApellidos())){
                //si coincide
                //Eliminarlo de la agenda
                agenda.remove(i);
                i--;
                //Avisar que ha sido borrado
                System.out.println("El contacto ha sido eliminado");
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("El contacto no existe");
        }
    }

    private static void ListarContactos() {
        //Recorrer la lista
        for (Contacto contacto : agenda) {
            //En cada vuelta imprimir la informacion de ese contacto
            System.out.println("---------------");
            contacto.imprimir();
            System.out.println("---------------");
        }
    }

    private static void ModificarContacto() {
        String nombre, apellidos, telefono;
        boolean encontrado =false;
        //Preguntar nombre y apellidos
        System.out.println("Que nombre quieres cambiar?");
        nombre = sc.nextLine();
        System.out.println("Que apellidos quieres cambiar?");
        apellidos = sc.nextLine();
        //Recorrer la lista
        for (Contacto c:agenda) {
                //en cada vuelta comprueba si coincide el nombre y apellido
            if (nombre.equalsIgnoreCase(c.getNombre()) && apellidos.equalsIgnoreCase(c.getApellidos())){
                //si coincide
                //cambia nombre, apellidos, telefono
                System.out.println("Dime el nombre");
                c.setNombre(sc.nextLine());
                System.out.println("Dime el apellido");
                c.setApellidos(sc.nextLine());
                System.out.println("Dime el telefono");
                c.setTelefono(sc.nextLine());
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("El contacto no existe");
        }
    }

    private static void AgregarContacto() {
        String nombre, apellidos, telefono;
        Contacto contacto;
        //Pedir informacion del contacto(nombre, apellidos, telefono)
        System.out.println("Nombre:");
        nombre = sc.nextLine();
        System.out.println("Apellidos:");
        apellidos = sc.nextLine();
        System.out.println("Telefono:");
        telefono = sc.nextLine();

        if (existeContacto(nombre, apellidos)) {
            System.out.println("El contacto ya existe");
        }else{
            //Crear un contacto con esa informacion
            contacto = new Contacto(nombre,apellidos,telefono);
            //añadir el contacto a la lista
            agenda.add(contacto);
        }
        //Crear un contacto con esa informacion
        contacto = new Contacto(nombre,apellidos,telefono);
        //Guardarlo en la lista de la agenda
        agenda.add(contacto);
    }

    //Comprobamos si el contacto existe
    private static boolean existeContacto(String nombre, String apellidos){
        for (int i = 0; i < agenda.size(); i++) {
            if(nombre.equalsIgnoreCase(agenda.get(i).getNombre()) &&
                    apellidos.equalsIgnoreCase(agenda.get(i).getApellidos())){
            }
        }
        return true;
    }

    private static void Menu() {
        System.out.println("Elige una opción:");
        System.out.println("1. Agregar Contacto");
        System.out.println("2. Modificar Contacto");
        System.out.println("3. Eliminar Contacto");
        System.out.println("4. Consultar un Contacto");
        System.out.println("5. Listar todos los Contactos");
        System.out.println("6. Ordenar por Nombre");
        System.out.println("7. Salir");
    }
}
