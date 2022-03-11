package com.company;

public class Intento {
    private char caracter;
    private int repeticion;
    private boolean estaEnSolucion;

    public Intento() {
    }

    public Intento(char caracter, int repeticion, boolean estaEnSolucion) {
        this.caracter = caracter;
        this.repeticion = repeticion;
        this.estaEnSolucion = estaEnSolucion;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(int repeticion) {
        this.repeticion = repeticion;
    }

    public boolean isEstaEnSolucion() {
        return estaEnSolucion;
    }

    public void setEstaEnSolucion(boolean estaEnSolucion) {
        this.estaEnSolucion = estaEnSolucion;
    }
}
