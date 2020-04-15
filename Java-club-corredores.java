package TP2;

import java.util.Scanner;

public class Ejercicio10_alt {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int numCorredor=0;
        int corredorGanador=0;
        int tiempoGanador=0;
        int promedioSegundos = 0;
        int porcentajeCorredores1hora = 0;
        int totalCorredores = 0;

        numCorredor = pedirCorredor();
        while (numCorredor != 0) {
            System.out.println("Ingrese las horas que tardo en realizar la carrera el corredor N°" + numCorredor);
            int horas = Integer.parseInt(input.nextLine());
            System.out.println("Ingrese los minutos que tardo en realizar la carrera el corredor N°" + numCorredor);
            int minutos = Integer.parseInt(input.nextLine());
            System.out.println("Ingrese los segundos que tardo en realizar la carrer el corredor N°" + numCorredor);
            int segundos = Integer.parseInt(input.nextLine());
            totalCorredores++;
            if (devolverSegundos(horas, minutos, segundos) < 3600) {
                porcentajeCorredores1hora++;
            }
            if (devolverSegundos(horas, minutos, segundos) < tiempoGanador) {
                tiempoGanador = devolverSegundos(horas, minutos, segundos);
                corredorGanador = numCorredor;               
            }else if (tiempoGanador == 0)
            {
                corredorGanador = numCorredor;   
            }
            promedioSegundos += devolverSegundos(horas, minutos, segundos);
            numCorredor = pedirCorredor();           
        }
        input.close();
        System.out.println("El ganador es el corredor N° " + corredorGanador);
        System.out.println("El promedio en segundos es: " + (promedioSegundos / totalCorredores)+" segundos");
        System.out.println("El porcentaje de corredores que realizo la carrera en menos de una hora es: "
                + ((porcentajeCorredores1hora * 100) / totalCorredores)+"%");

    }

    public static int devolverSegundos(int horas, int minutos, int segundos) {
        return (horas * 3600 + minutos * 60 + segundos);
    }
    public static int pedirCorredor() {
        int num =0;
        System.out.println("Ingrese el número del corredor");
        num = Integer.parseInt(input.nextLine());
        return num;       
    }

}