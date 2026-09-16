package com.mycompany.main;
import java.util.Scanner;
public class Main {
    public static double promedio(double[] dato){
        double suma=0;
        for(int i=0;i<10;i++){
            suma+=dato[i];
        }
        return suma/10;
    }
    public static double desviacion(double[] dato){
        double prom=promedio(dato);
        double sumcua=0;
        for(int i=0;i<10;i++){
            sumcua+=Math.pow(dato[i]-prom, 2);
        }
        return Math.sqrt(sumcua/(9));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double[]num=new double[10];
        System.out.println("ingrese 10 numeros: ");
        for(int i=0;i<10;i++){
            num[i]=sc.nextDouble();
        }
        System.out.println("El promedio es: "+promedio(num));
        System.out.println("La desviacion estander es: "+desviacion(num));
    }
}    