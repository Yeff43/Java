package com.company;

public class Password {
    public static final int LONGITUDPORDEFECTO = 8;
    private int longitud;
    private String contrasenia;

    public Password() {
    }

    public Password(int longitud, String contrasenia) {
        if(longitud > 0){
            this.longitud = longitud;
        }else{
            this.longitud = LONGITUDPORDEFECTO;
        }
        this.contrasenia = contrasenia;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void generarPassword(int longitud) {
        int aleatorio;
        String combinacionDeCaracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        contrasenia = "";

        for (int i = 0; i < longitud; i++) {
            aleatorio = (int) (Math.random() * combinacionDeCaracteres.length());
            contrasenia = contrasenia+ combinacionDeCaracteres.charAt(aleatorio);
        }
    }

    public boolean esfuerte() {
        int contadorMayuculas = 0;
        int contadorMinusculas = 0;
        int contadorNumeros = 0;
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "1234567890                ";

        for (int i = 0; i < contrasenia.length(); i++) {
            for (int j = 0; j < contrasenia.length() ; j++) {
                if(contrasenia.charAt(i) == mayusculas.charAt(j)){
                    contadorMayuculas++;
                }
                if(contrasenia.charAt(i) == minusculas.charAt(j)){
                    contadorMinusculas++;
                }
                if(contrasenia.charAt(i) == numeros.charAt(j)){
                    contadorNumeros++;
                }
            }
        }

        if (contadorMayuculas > 2 && contadorMinusculas > 1 && contadorNumeros > 2) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        Password p = (Password) obj;

        return p.contrasenia.equals(contrasenia);
    }

    @Override
    public String toString() {
        return "Contraseña: " + contrasenia;
    }
}
