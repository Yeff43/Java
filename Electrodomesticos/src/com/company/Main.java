package com.company;

public class Main {

    public static void main(String[] args) {
        Electrodomestico[] mistrastos = new Electrodomestico[10];
        int contLavadora = 0;
        int contTelevision = 0;
        int contElectrodomesticos = 0;

        mistrastos[1] = new Lavadora();
        mistrastos[2] = new Television();
        mistrastos[4] = new Lavadora(400,30);
        mistrastos[5] = new Television(800,8);
        mistrastos[7] = new Lavadora("negro",'B',450,35,7);
        mistrastos[8] = new Television(900,"rojo",'C',10,"24",true);

        for (int i = 0; i < mistrastos.length; i++) {
            if(mistrastos[i] != null){
                contElectrodomesticos++;
            }
            if(mistrastos[i] instanceof Lavadora){
                contLavadora++;
                mistrastos[i].funcionalidad();
            }
            if(mistrastos[i] instanceof Television){
                contTelevision++;
                mistrastos[i].funcionalidad();
            }
        }
    }
}
