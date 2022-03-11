package com.company;

import com.company.interfaces.Casa;
import com.company.interfaces.Ocio;

public class Television extends Electrodomestico implements Ocio, Casa {
    private final String RESOLUCIONPORDEFECTO = "20";
    private final boolean TDTPORDEFECTO = false;

    private String resolucion;
    private boolean tdt;



    public Television() {
        resolucion = RESOLUCIONPORDEFECTO;
        tdt = TDTPORDEFECTO;
    }

    public Television(float precio, float peso) {
        super(precio, peso);
    }

    public Television(float precio,String color, char consumo, float peso, String resolucion, boolean tdt) {
        super(precio,color, consumo, peso);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }

    @Override
    public void funcionalidad() {
        System.out.println("Entretener");
    }

    @Override
    public String toString() {
        return "Television{" +
                "color='" + color + '\'' +
                ", consumo=" + consumo +
                ", precio=" + precio +
                ", peso=" + peso +
                ", resolucion='" + resolucion + '\'' +
                ", tdt=" + tdt +
                '}';
    }

    // Estas funciones provienen de la interfaz Ocio
    @Override
    public boolean tieneBateria() {
        return true;
    }

    @Override
    public void listadoAplicaciones() {
        System.out.println("Aplicacion 1");
        System.out.println("Aplicacion 2");
        System.out.println("Aplicacion 3...");
    }

    //Estas funciones provienen de la interfaz Casa
    @Override
    public String lugarCasa() {
        return "salon";
    }

    @Override
    public int anyosAntiguedad() {
        int garantia = GARANTIAPORDEFECTO;
        return 2;
    }
}
