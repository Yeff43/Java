package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    static Jugador jugador = new Jugador();
    static Jugador ordenador = new Jugador();
    static int contadorVictoriasJugador, contadorVictoriasOrdenador, aleatorio, seleccion = 0;
    static int[] repetidos = new int[7];
    static int[] arrayMano = {0, 1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        int ronda = 1;
        do {
            int opcionesRandoms = 0;

            resumen();
            System.out.println("**************************");
            System.out.println("Comienza una nueva batalla");
            System.out.println("BATALLA " + ronda + " ****************");
            System.out.println("Elige una carta para utilizar en el combate");

            //Carta de la Maquina
            aleatorio = r.nextInt(6);
            repetidos[opcionesRandoms] += aleatorio;


            //Turno Jugador y seleccion de carta
            //Controlo el scanner y limito los datos ingresados
            jugador.imprimirMano();
            try {
                seleccion = sc.nextInt();

                for (int i = 0; i < jugador.getCartas().length; i++) {
                    if(seleccion == (jugador.getCartas())[i]){
                        (jugador.getCartas())[i] -= i;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error, no ingreses letras");
            }
            sc.nextLine();

            System.out.println("El jugador ha utilizado el guerrero-> " + seleccion);
            System.out.println("El ordenador ha utilizado el guerrero-> " + aleatorio);
            //if anidados para capturar los casos donde se gana se pierde o empata o se gana la corona
            if (seleccion - aleatorio >= 2 && aleatorio != 0) {
                System.out.println("El JUGADOR gana el combate y la batalla");
                contadorVictoriasJugador++;
                jugador.setNumVictorias(contadorVictoriasJugador);
                jugador.setCorona(false);
            } else {
                if (aleatorio - seleccion >= 2 && aleatorio != 0) {
                    System.out.println("El ORDENADOR gana el combate y la batalla");
                    contadorVictoriasOrdenador++;
                    ordenador.setNumVictorias(contadorVictoriasOrdenador);
                    ordenador.setCorona(false);
                } else {
                    if (aleatorio == 0 && seleccion >= aleatorio + 2) {
                        System.out.println("El JUGADOR gana el combate y la batalla y la GUERRA");
                        contadorVictoriasJugador++;
                        jugador.setNumVictorias(contadorVictoriasJugador);
                        jugador.setCorona(true);
                        System.out.println("**************************");
                        System.out.println("RESUMEN");
                        System.out.println("EL JUGADOR GANA LA GUERRA");
                        System.out.println("JUGADOR VICTORIAS " + jugador.getNumVictorias());
                        System.out.println("ORDENADOR VICTORIAS " + ordenador.getNumVictorias());
                        break;
                    } else {
                        if (seleccion == 0 && aleatorio >= seleccion + 2) {
                            System.out.println("El ORDENADOR gana el combate y la batalla y la GUERRA");
                            contadorVictoriasOrdenador++;
                            ordenador.setNumVictorias(contadorVictoriasOrdenador);
                            ordenador.setCorona(true);
                            System.out.println("**************************");
                            System.out.println("RESUMEN");
                            System.out.println("EL ORDENADOR GANA LA GUERRA");
                            System.out.println("JUGADOR VICTORIAS " + jugador.getNumVictorias());
                            System.out.println("ORDENADOR VICTORIAS " + ordenador.getNumVictorias());
                            break;
                        } else {
                            if (seleccion - aleatorio <= 1 && seleccion != 0 || aleatorio - seleccion <= 1 && aleatorio != 0) {
                                System.out.println("Nadie ha ganado el combate, continua la batalla");
                            }
                        }
                    }
                }
            }
            //se van eliminando las cartas desde la funcion de la clase
            jugador.restarCarta(seleccion);
            ordenador.restarCarta(aleatorio);

            aleatorio = noRepetirRandom(aleatorio);
            ronda++;

        } while (ronda < 7 || ordenador.isCorona() || jugador.isCorona());

    }

    //Creo una funcion norepetirrandom para que almacene aleatorios y compare para que si se parece a algo anterior, me de otro...
    public static int noRepetirRandom(int nuevoRandom) {
        for (int repetido : repetidos) {
            for (int k : arrayMano) {
                if (repetido == k) {
                    nuevoRandom = r.nextInt(6);
                }
            }
        }
        return nuevoRandom;
    }

    public static void resumen() {
        //Creo el marcador
        if (jugador.isCorona() || ordenador.isCorona()) {
            System.out.println("**************************");
            System.out.println("RESUMEN");
            System.out.println("JUGADOR VICTORIAS " + jugador.getNumVictorias());
            System.out.println("ORDENADOR VICTORIAS " + ordenador.getNumVictorias());
        } else {
            if (ordenador.isCorona()) {
                System.out.println("**************************");
                System.out.println("RESUMEN");
                System.out.println("El ORDENADOR HA GANADO LA GUERRA");
                System.out.println("JUGADOR VICTORIAS " + jugador.getNumVictorias());
                System.out.println("ORDENADOR VICTORIAS " + ordenador.getNumVictorias());
            } else {
                if (jugador.isCorona()) {
                    System.out.println("**************************");
                    System.out.println("RESUMEN");
                    System.out.println("El JUGADOR HA GANADO LA GUERRA");
                    System.out.println("JUGADOR VICTORIAS " + jugador.getNumVictorias());
                    System.out.println("ORDENADOR VICTORIAS " + ordenador.getNumVictorias());
                }
            }
        }
    }
}