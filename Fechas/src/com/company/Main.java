package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

// o todas las librerias de una bibblioteca java
    // import java.time.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //FECHAS

        //Crear Fecha con  LocalDate.now para fecha actual
        LocalDate fechaActual = LocalDate.now();

        //Crear Fecha con LocalDate.of segun la fecha que pases
        LocalDate fechaInicio = LocalDate.of(2015,10,27);

        //Crear Fecha con LocalDate.parse
        LocalDate fechaFin = LocalDate.parse("2020-05-17");

        //Comparar Fechas con compareTo
        if(fechaActual.compareTo(fechaInicio) > 0){
            System.out.println(fechaActual + " es posterior a " +fechaInicio);
        }else{
            if(fechaActual.compareTo(fechaInicio) < 0){
                System.out.println(fechaActual + " es anterior a " + fechaInicio);
            }else {
                System.out.println("Las fechas son iguales");
            }
        }

        if(fechaActual.isBefore(fechaInicio)){
            System.out.println(fechaActual + " es anterior a " + fechaInicio);
        }
        if(fechaActual.isAfter(fechaInicio)){
            System.out.println(fechaActual + " es posterior a " + fechaInicio);
        }

        //Obtener Año Mes o DIA actual, o dia del año
        System.out.println("Año Actual: " + fechaActual.getYear());
        System.out.println("Mes actual: " + fechaActual.getMonthValue());
        System.out.println("Dia actual: " + fechaActual.getDayOfMonth());
        System.out.println("Dia del año: " + fechaActual.getDayOfYear());

        //RESTAR SUMAR FECHAS
        fechaActual = fechaActual.minusDays(5);
        fechaActual.minusMonths(2);
        fechaActual.minusYears(10);

        System.out.println(fechaActual);

        //SUMAR FECHAS
        fechaActual = fechaActual.plusDays(5);
        fechaActual.plusDays(2);
        fechaActual.plusYears(10);

        //CAMBIAR FECHA
        fechaActual = fechaActual.withMonth(4);
        System.out.println(fechaActual);

        //DISTANCIA ENTRE DOS FECHAS con PERIOD
        System.out.println("CLASE PERIOD");
        Period periodoo = Period.between(fechaInicio, fechaActual);
        System.out.println("Años: "+periodoo.getYears());
        System.out.println("Meses: "+periodoo.getMonths());
        System.out.println("Dias: "+periodoo.getDays());

        //ChronoUnit -
        System.out.println("CHRONOUNIT");
        System.out.println("Años: "+ChronoUnit.YEARS.between(fechaInicio, fechaActual));
        System.out.println("Meses: "+ChronoUnit.MONTHS.between(fechaInicio, fechaActual));
        System.out.println("Dias: "+ChronoUnit.DAYS.between(fechaInicio, fechaActual));

        //FORMATOS DE FECHA
        DateTimeFormatter miFormatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(fechaActual.format(miFormatoFecha));
        System.out.println(miFormatoFecha.format(fechaActual));

        LocalDate otraFecha = LocalDate.parse("06/04/2000",miFormatoFecha);
        System.out.println(otraFecha);

        //Ejercicio 1 Fechas
        System.out.println("EJERCICIO 5 FECHAS");
        DateTimeFormatter ejercicio5 = DateTimeFormatter.ofPattern("dd/MM/yy");

        try {
            System.out.println("Ingresa tu Fecha de nacimiento(dd/MM/yy");
            String fechaaa = sc.nextLine();
            LocalDate fechaNacimiento = LocalDate.parse(fechaaa,ejercicio5);
            switch(fechaNacimiento.getDayOfWeek()){
                case MONDAY:
                    System.out.println("Naciste un dia LUNES");
                    break;
                case TUESDAY:
                    System.out.println("Naciste un dia MARTES");
                    break;
                case WEDNESDAY:
                    System.out.println("Naciste un dia MIERCOLES");
                    break;
                case THURSDAY:
                    System.out.println("Naciste un dia JUEVES");
                    break;
                case FRIDAY:
                    System.out.println("Naciste el dia VIERNES");
                    break;

            }
        }catch(Exception e){
            System.out.println("Error al introducir Fecha");
        }

        //Ejercicio 2 Fechas
        final int SEMANAS=16;
        System.out.println("EJERCICIO 2 FECHAS");
        DateTimeFormatter ejercicio2 = DateTimeFormatter.ofPattern("dd/MM/yy");

        System.out.println("Ingresa la Fecha de nacimiento del bebe (dd/MM/yy");
        LocalDate fechaNacimientoBebe = LocalDate.parse(sc.nextLine(),ejercicio2);

        fechaNacimientoBebe = fechaNacimientoBebe.plusWeeks(SEMANAS);
        System.out.println("Fecha Reintegro: " + fechaNacimientoBebe.format(ejercicio2));

        //Ejercicio 3 Fechas
        System.out.println("EJERCICIO 3 FECHAS");



        //Ejercicio 4 Fechas
        System.out.println("EJERCICIO 3 FECHAS");
        System.out.println("************");
        System.out.println("****MENU****");
        System.out.println("************");
        System.out.println("ELIGE UNA ESTACION");
        System.out.println("1. Primavera");
        System.out.println("2. Verano");
        System.out.println("3. Otoño");
        System.out.println("4. Invierno");

        int estacion = sc.nextInt();
        int periodo = 0;
        DateTimeFormatter ejercicio3 = DateTimeFormatter.ofPattern("dd/MM/yy");
        fechaActual = LocalDate.now();
        LocalDate inicioPrimavera = LocalDate.parse("20/03/22",ejercicio3);
        LocalDate inicioVerano = LocalDate.parse("21/06/22",ejercicio3);
        LocalDate inicioOtonio = LocalDate.parse("23/09/22",ejercicio3);
        LocalDate inicioInvierno = LocalDate.parse("21/12/22",ejercicio3);

        switch(estacion) {
            case 1:
                periodo = (int)ChronoUnit.DAYS.between(fechaActual,inicioPrimavera);
                break;
            case 2:
                periodo = (int)ChronoUnit.DAYS.between(fechaActual, inicioVerano);
                break;
            case 3:
                periodo = (int)ChronoUnit.DAYS.between(fechaActual, inicioOtonio);
                break;
            case 4:
                periodo = (int)ChronoUnit.DAYS.between(fechaActual, inicioInvierno);
                break;
            default:
                System.out.println("Ingresaste una opcion No Valida");
                break;
        }

        System.out.println("Faltan " + periodo + " para que empiece la estacion");

        //Ejercicio 5 Fechas
        System.out.println("EJERCICIO 5 FECHAS");

        ArrayList<LocalDate> lunes1 = new ArrayList<>();
        LocalDate diaInicio = LocalDate.now();
        diaInicio = diaInicio.withDayOfMonth(1);
        LocalDate diaFinal = diaFinal.withMonth(12);
        LocalDate diaFinal = diaFinal.withDayOfMonth(31);
        LocalDate diaFinal = diaFinal.getYear()+1;
    }
}
