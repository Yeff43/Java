package com.company;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Password[] passwords;
        Password p = new Password();
        int longitud = 0;

        passwords = pedirLongitudArray(sc);
        System.out.println("Se almacenaran " + passwords.length + " contraseñas");
        rellenarArray(passwords);

    }

    private static Password[] pedirLongitudArray(Scanner sc) {
        int espaciosDelArray;
        Password[] Passwords;
        System.out.println("Cuantas contraseñas quieres almacenar?");
        espaciosDelArray = sc.nextInt();
        Passwords = new Password[espaciosDelArray];
        return Passwords;
    }

    private static void rellenarArray(Password[] passwords){
        Password p;
        int longitud;
        boolean[] fuerte = new boolean[passwords.length];

        for (int i = 0; i < passwords.length; i++) {
            p = new Password();
            System.out.println("************************************************");
            System.out.println("---- Ingresar Longitud del Password ----");
            longitud = sc.nextInt();

            p.generarPassword(longitud);

            if(existe(p,passwords)){
                System.out.println("La contraseña ya EXISTE");
                i--;
            }
            else{
                passwords[i] = p;
                fuerte[i] = p.esfuerte();
                System.out.println(p.getContrasenia()+ " "+fuerte[i]);
            }
        }
    }

    private static boolean existe(Password p, Password[] passwords) {
        for (Password pw: passwords) {
            if(pw != null && p.equals(pw)){
                return true;
            }
        }
        return false;
    }
}