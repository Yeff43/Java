package com.company;

import com.company.interfaces.Casa;
import com.company.interfaces.cocina;

public class Lavadora extends Electrodomestico implements cocina, Casa {
    public static final int CARGAPORDEFECTO = 5;
    private int carga;

    public Lavadora() {
        this.carga = CARGAPORDEFECTO;
    }

    public Lavadora(float precio, float peso) {
        super(precio, peso);
        this.carga = CARGAPORDEFECTO;
    }

    public Lavadora(String color, char consumo, float precio, float peso, int carga) {
        super(precio,color, consumo, peso);
        this.carga = carga;
    }

    public float getCarga() {
        return carga;
    }

    @Override
    public void funcionalidad() {
        System.out.println("Lavar la ropa");
    }

    @Override
    public String toString() {
        return super.toString() + "Lavadora{" +
                "carga=" + carga +
                '}';
    }

    // Esto proviene de la interface COCINA

    @Override
    public boolean necesitaAgua() {
        return true;
    }

    @Override
    public boolean esProgramable() {
        return true;
    }

    @Override
    public String lugarCasa() {
        return "cocina";
    }

    @Override
    public int anyosAntiguedad() {
        int garantia = GARANTIAPORDEFECTO;
        return 10;
    }
}
