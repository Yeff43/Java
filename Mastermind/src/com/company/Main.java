package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        String[] colores = {"amarillo", "azul", "rojo", "verde", "naranja", "rosa", "cafe", "negro"};
        int[] combinacion = new int[5];
        String[] combinacionEnColores = new String[5];
        String[] adivinado = new String[5];
        String[] negroBlanco = {"negro", "blanco", "Vacio"};
        String[] negroBlancoGuardado = new String[5];
        int rondas = 15, contadorGanador = 0;

        //Definir la combinacion de 5 colores creando un array combinacion donde asigno valores random usando fori
        for (int i = 0; i < 5; i++) {
            combinacion[i] = (int)(Math.random()* colores.length); // para dar aleatorios a un array respecto a la cantidad de casillas de otro
        }

        //Guardo los valores random de combinacion en combinacionColores
        for (int i = 0; i < combinacion.length; i++) {
            combinacionEnColores[i] = colores[combinacion[i]];

        }
        do {
            //Jugador intenta adivinar y se guardan sus respuestas en el array adivinado
            for (int i = 0; i < combinacionEnColores.length; i++) {

                System.out.println(combinacion[0]);
                System.out.println(combinacion[1]);
                System.out.println(combinacion[2]);
                System.out.println(combinacion[3]);
                System.out.println(combinacion[4]);


                System.out.println("Adivina el color " + (i + 1) + ":");
                System.out.println("Eligelos entre: amarillo, azul, rojo, verde, naranja, rosa, negro y cafe.");
                try {
                    adivinado[i] = sc.next();
                }catch(Exception e){
                    System.out.println("Error inesperado");
                }
            }

            //Se busca comparar lo que se ha adivinado con la combinacionEnColores
            for (int i = 0; i < combinacion.length; i++) {
                //En caso de SI estar el color y estar en la misma posicion que la combinacion dará NEGRO
                if (adivinado[i].equals(combinacionEnColores[i])) {
                    negroBlancoGuardado[i] = negroBlanco[0];
                    //Sino será necesario que el ordenador diferencie cuando debe dar NEGRO, BLANCO O VACIO
                } else {
                    for (int j = 0; j < combinacion.length; j++) {
                        if (adivinado[i].equals(combinacionEnColores[j])) {
                            //i y J se han corregido de posicion
                            negroBlancoGuardado[i] = negroBlanco[1];
                            break;
                        } else {
                            negroBlancoGuardado[i] = negroBlanco[2];
                        }
                    }
                }
            }
            for (int i = 0; i < negroBlancoGuardado.length; i++) {
                System.out.println(negroBlancoGuardado[i]);
            }
            rondas -=1;

            for (int i = 0; i < negroBlancoGuardado.length; i++) {
                if(negroBlancoGuardado[i].equals(negroBlancoGuardado[0])){
                    contadorGanador++;
                    if(contadorGanador == 5){
                        System.out.println("HAS GANADO");
                        break;
                    }
                }
            }

        }while(contadorGanador<5 || rondas>0);
        System.out.println("HAS GANADO");

        if(rondas==0){
            System.out.println("Has PERDIDO");
        }
    }
}