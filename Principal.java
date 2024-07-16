package com.aluracursos.conversormoneda.principal;
import com.aluracursos.conversormoneda.model.DatosMoneda;
import com.aluracursos.conversormoneda.service.ConsumoApi;
import com.aluracursos.conversormoneda.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {


    private Scanner teclado = new Scanner(System.in);
    String conversion;
    double amount;

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();



    String menu = """
            -----------------------------------------------------------------------------------------------------
            MENÙ 
            ------------------------------------------------------------------------------------------------------
            Bienvenido al Conversor de Moneda. A continuaciòn se presentan las opciones disponibles del conversor.
            Por favor elija una opcion vàlida:
            1) MXN ---> USD
            2) USD ---> MXN
            3) SALIR
            -------------------------------------------------------------------------------------------------------
           
            
            """;

    public void mostrarMenu(){

        int opcion = 0;

        do{
            System.out.println(menu);
            opcion = teclado.nextInt();

            if(opcion >0 && opcion<3){
                System.out.println("¿Cual es la cantidad que desea convertir?");
                amount = teclado.nextDouble();

            }

            switch (opcion){
                case 1: conversion = "MXN/USD/";
                break;
                case 2: conversion = "USD/MXN/";
                break;
                case 3:
                    System.out.println("Finalizando la aplicaciòn, gracias por utilizar el conversor de moneda");
                    break;
                default:
                    System.out.println("Opciòn invalida");

            }

            if (opcion >0 && opcion<3){
                var json =consumoApi.obtenerDatos("https://v6.exchangerate-api.com/v6/aff2910c091829f6a78d5e35/pair/"+ conversion + amount);
                var datos = conversor.obtenerDatos(json, DatosMoneda.class);
                System.out.println("El resultado de la conversiòn es: "+ datos.resultadoConversion());
                System.out.println("Gracias por utilizar el conversor de moneda.");
            }


        } while(opcion != 3);
        teclado.close();

    }
}

