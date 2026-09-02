package com.mycompany.tpoo4;
import java.util.Scanner;

class Estadistica{
    private double dato[];

    public Estadistica(double[] dato) {
        this.dato = dato;
    }
    public double promedio(){
        double suma=0;
        for(int i=0;i<dato.length;i++){
            suma+=dato[i];
        }
        return suma/dato.length;
    }
    public double desviacion(){
        double prom=promedio();
        double sumaCuadrado=0;
        for(int i=0;i<dato.length;i++){
            sumaCuadrado+=Math.pow(dato[i]-prom, 2);
        }
        return Math.sqrt(sumaCuadrado/(dato.length-1));
    }
}
public class Tpoo4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        double[] num=new double[10];
        System.out.println("ingrese 10 numeros");
        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextDouble();
        }
        Estadistica es=new Estadistica(num);
        System.out.println("el promedio es: "+es.promedio());
        System.out.println("la desviacion es: "+es.desviacion());
    }
}
