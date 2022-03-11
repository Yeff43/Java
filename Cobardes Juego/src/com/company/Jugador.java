package com.company;

public class Jugador {
    private int[] cartas = {0,1,2,3,4,5,6};
    private int numVictorias;
    private boolean corona = false;

    public Jugador(){
    }

    public Jugador(int[] cartas, int numVictorias, boolean corona) {
        this.cartas = cartas;
        this.numVictorias = numVictorias;
        this.corona = corona;
    }

    public int[] getCartas() {
        return cartas;
    }
    public void setCartas(int[] cartas) {
        this.cartas = cartas;
    }

    public int getNumVictorias() {
        return numVictorias;
    }
    public void setNumVictorias(int numVictorias) {
        this.numVictorias = numVictorias;
    }

    public boolean isCorona() {
        return corona;
    }
    public void setCorona(boolean corona) {
        this.corona = corona;
    }

    public void imprimirMano(){
        System.out.print("[ ");
        for (int i = 0; i < cartas.length; i++) {
            System.out.print(cartas[i]);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public void restarCarta(int carta) {
        if (carta >= 0 && carta <= cartas.length) {
            cartas[carta] -= carta;
        } else {
            System.out.println("Seleccion invalida");
        }
    }
}
