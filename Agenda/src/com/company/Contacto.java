package com.company;

public class Contacto {
    public static final int LIMITE = 10;
    private static int contContacto;
    private String nombre;
    private String telefono;
    private int identificador;

    //Segun el contador de contacto, paso a identificador lo que va contContacto
    public Contacto() {
        contContacto++;
        identificador = contContacto;
    }

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        contContacto++;
        identificador = contContacto;
    }

    public static int getContContacto() {
        return contContacto;
    }

    public static void setContContacto(int contContacto) {
        Contacto.contContacto = contContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override //Override sirve para sobreescribir la manera en la que un metodo ya existente funciona o responde
    public boolean equals(Object obj) { //En este caso se le dice que funcione de la siguiente manera
        Contacto c = (Contacto)obj; // Recibe un objeto, el bojeto se castea y se convierte en un objeto de tipo Contacto

        if(c.getNombre().equalsIgnoreCase(nombre)){
            return true;
        }
        return false;
    }

    //Funcion imprimir usando toString desde el generate, ejemplo sout.. c.toString()
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Telefono: " + telefono + ", Identificador: " + identificador;
    }
}
