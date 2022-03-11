package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    //Variables globales
    static String[][] lista = new String[][]{
            {"amor", "cariño", "afecto", "pasión"},
            {"bajo", "pequeño", "chico", "menino"},
            {"giro", "rotación", "vuelta", "desvío"},
            {"humano", "hombre", "persona", "ser"},
            {"idea", "imagen", "sensación","percepción"},
            {"joven", "adolescente", "mozo", "muchacho"},
            {"labor", "faena", "ocupación", "trabajo"}
            ,{"mirar", "ver", "observar", "contemplar"},
            {"nuevo", "reciente", "moderno", "actual"},
            {"olor", "fragancia", "aroma", "esencia"},
            {"poco", "escaso", "insuficiente", "limitado"},
            {"querer", "amar", "estimar", "adorar"},
            {"ruta", "itinerario", "rumbo", "trayecto"}};
    static String palabra="",palabraOculta, palabraAuxiliar;
    static char[] palabraOcultaArray;
    static char[] letrasPalabra = new char[palabra.length()];
    static ArrayList<Intento> intentos = new ArrayList <>();
    static int contadorIntentos = 0,contadorPistas=0;
    static final int LIMITEFALLOS=6;
    static boolean correElJuego=false,siLetraEsta=false;
    static char letraIntroducida = ' ';

    static String[] palabraPista = new String[4];

    public static void main(String[] args) {
        int seleccion=0;

        palabra = obtenerPalabra().toUpperCase();
        palabraOculta = palabraOculta(palabra);
        letrasPalabra = palabra.toCharArray();
        palabraOcultaArray = new char[palabraOculta.length()];
        correElJuego = true;
        do{
            menu();
            do{
            try {
                seleccion = sc.nextInt();
            }catch(Exception e){
                System.out.println("Has elegido una opcion invalida");
            }
            }while(seleccion >3 || seleccion<=0);

            switch(seleccion){
                case 1://
                    letraIntroducida = introducirLetra();
                    siLetraEsta = compararLetra(letraIntroducida);
                    if(siLetraEsta){
                        System.out.println("Has Acertado!!");
                        correElJuego=comprobarGanar();
                    }else{
                        System.out.println("Ups...Te has equivocado");
                    }

                    break;
                case 2:
                    darPistas();
                    break;
                case 3:
                    resumen();
                    break;
            }

            if(contadorIntentos == LIMITEFALLOS ){
                correElJuego=false;
            }

        }while(correElJuego);
    }

    private static boolean comprobarGanar(){
        boolean ganar = true;
        if(palabra.equals(palabraOculta.replace("-",""))){
            System.out.println("HAS GANADO LA PARTIDA!!");
            ganar = false;
        }
        return ganar;
    }

    private static void resumen() {
        if(intentos.size() == 0){
            System.out.println("*******************************************");
            System.out.println("Intentos Fallidos: " + intentos.size());
            System.out.println("Pistas Solicitadas: " + contadorPistas);
            System.out.println("Letras Usadas: ");
            System.out.println("Debes empezar la partida para generar un resumen completo!!");
        }else{
            char[] arraisito = new char[intentos.size()];
            for (int i = 0; i < arraisito.length ; i++) {
                arraisito[i] = intentos.get(i).getCaracter();
            }
            System.out.println("*******************************************");
            System.out.println("Intentos Fallidos: " + intentos.size());
            System.out.println("Pistas Solicitadas: " + contadorPistas);
            System.out.println("Letras Usadas: ");
            for (char c: arraisito) {
                System.out.println(c);
            }
            System.out.println("*******************************************");
        }
    }

    //Creo una funcion dar pista que reduzco en contador para que con un if decida si va una pista u otra, sino ya se usaron todas
    private static void darPistas(){
        String pista1,pista2,pista3;
        contadorPistas++;
        if(contadorPistas < 4) {
            if (contadorPistas == 1) {
                pista1 = palabraPista[1];
                System.out.println("Pista 1: " + pista1);
            }
            if (contadorPistas == 2) {
                pista2 = palabraPista[2];
                System.out.println("Pista 2: " + pista2);
            }
            if (contadorPistas == 3) {
                pista3 = palabraPista[3];
                System.out.println("Pista 3: " + pista3);
            }
        }else{
            System.out.println("Ya has usado todas tus PISTAS");
        }
    }

    //Creo una funcion para comparar la letra ingresada
    // Debo lograr que con un fori me  muestre las letras que esten y sino...ya veremos
    private static boolean compararLetra(char letraIntroducida) {
        palabraOcultaArray = palabraOculta.toCharArray();
        int vecesLetraRepetida = 0;
        intentos.add(new Intento());
        siLetraEsta = false;
        for (int i = 0; i < letrasPalabra.length; i++) {
            //Cuando la letra es igual o diferente a la letraintroducida
            if(letrasPalabra[i] == letraIntroducida){
                if(i == 0){
                    siLetraEsta = true;
                    vecesLetraRepetida++;
                    palabraOcultaArray[i] = letraIntroducida;
                }else{
                    palabraOcultaArray[i*2] = letraIntroducida;
                }
                //Doy atributos al objeto agregado al arraylist en caso que SI...
                intentos.get(contadorIntentos).setCaracter(letraIntroducida);
                intentos.get(contadorIntentos).setRepeticion(vecesLetraRepetida);
                intentos.get(contadorIntentos).setEstaEnSolucion(true);
                siLetraEsta = true;
            }else{
                //Doy atributos al objeto agregado al arraylist en caso que no...
                intentos.get(contadorIntentos).setCaracter(letraIntroducida);
                intentos.get(contadorIntentos).setRepeticion(vecesLetraRepetida);
                intentos.get(contadorIntentos).setEstaEnSolucion(false);
            }
        }
        palabraOculta = palabraOculta.valueOf(palabraOcultaArray);
        System.out.println();
        contadorIntentos++;

        return siLetraEsta;
    }

    //Creo esta funcion para introducir letra y controlar su longitud //QUITAR EL SOUT DE PALABRA
    private static char introducirLetra() {
        char letraIngresada=' ';
        String auxiliar="";
        System.out.println(palabra); // OJOOOO QUITARR
        System.out.println("Por favor introduce una letra!");
        auxiliar = sc.next();
        if(auxiliar.length() > 1){
            System.out.println("Trampaaa!...Solo debes introducir una letra");
        }else{
            letraIngresada = auxiliar.toUpperCase().charAt(0);
        }
        return letraIngresada;
    }

    //una funcion que me genera la palabra los espacios para mostrar al jugador
    private static String palabraOculta(String palabra) {
        String palabraOculta="";
        for (int i = 0; i < palabra.length() ; i++) {
            if( i+1 == palabra.length()){
                palabraOculta += "_";
            }else{
                palabraOculta+="_-";
            }
        }

        return palabraOculta;
    }

    private static String obtenerPalabra() {
        //con un fori recorro filas aleatoriamente.se elige una y se asigna a palabrapista.
        Random rand = new Random();
        int indicePalabra = rand.nextInt(13);

        for (int i = 0; i < lista.length  ; i++) {
            if(indicePalabra == i){
                palabraPista = lista[i];
            }
        }
        return palabraPista[0];
    }

    //Mostrar menu de juego
    public static void menu(){

        System.out.println("************************");
        System.out.println("**ADIVINAR LA PALABRA**");
        System.out.println("************************");

        System.out.println(palabraOculta);

        System.out.println("**************");
        System.out.println("** ACCIONES **");
        System.out.println("**************");
        System.out.println("1. Comprobar Letra");
        System.out.println("2. Pedir pista");
        System.out.println("3. Resumen resultado");
    }
}
