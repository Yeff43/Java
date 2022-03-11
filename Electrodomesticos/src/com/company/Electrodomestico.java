package com.company;
//Esto esuna clase abstracta, NO se puede instanciar objetos de una clase ABSTRACTA
// palabra reservada abstract
public abstract class Electrodomestico {
    public static final String COLORPORDEFECTO = "blanco";
    public static final char CONSUMOPORDEFECTO = 'F';
    public static final float PRECIOPORDEFECTO = 100;
    public static final float PESOPORDEFECTO = 5;

    protected float precio;
    protected String color;
    protected char consumo;
    protected float peso;

    public Electrodomestico() {
        this.precio = PRECIOPORDEFECTO;
        this.color = COLORPORDEFECTO;
        this.consumo = CONSUMOPORDEFECTO;
        this.peso = PESOPORDEFECTO;
    }

    public Electrodomestico(float precio, float peso) {
        this.precio = precio;
        this.color = COLORPORDEFECTO;
        this.peso = peso;
        this.consumo = CONSUMOPORDEFECTO;
    }

    public Electrodomestico(float precio, String color, char consumo, float peso) {
        this.precio = comprobarPrecioBase(precio);
        this.color = comprobarColor(color);
        this.consumo = comprobarConsumoEnergetico(consumo);
        this.peso = comprobarPeso(peso);
    }

    private float comprobarPrecioBase(float precio) {
        if(precio > 0){
            return precio;
        }else{
            return PRECIOPORDEFECTO;
        }
    }

    private String comprobarColor(String color){
        String[] colores = {"blanco","negro","rojo","azul","gris"};
        for (String c : colores) {
            if (color.equalsIgnoreCase(c)) {
                return color;
            }
        }
        return COLORPORDEFECTO;
    }

    private char comprobarConsumoEnergetico(char letra){
        char[] letras = {'A','B','C','D','E','F'};
        letra = Character.toUpperCase(letra);
        for (char c : letras) {
            if (letra == c) {
                return letra;
            }
        }
        return CONSUMOPORDEFECTO;
    }

    /*comprobarColor(String color): comprueba que el color es correcto, sino lo es usa el
    color por defecto. Se invocará al crear el objeto y no será visible.
*/
    private float comprobarPeso(float peso) {
        if(peso > PESOPORDEFECTO){
            return peso;
        }else{
            return PESOPORDEFECTO;
        }
    }

    //Sobreescribir una funcion heredada de la clase principal
    //En este caso es abstracto
    public abstract void funcionalidad();

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "color='" + color + '\'' +
                ", consumo=" + consumo +
                ", precio=" + precio +
                ", peso=" + peso +
                '}';

    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
