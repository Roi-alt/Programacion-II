package com.mycompany.tpoo3;
import java.util.Scanner;

class EcuacionCuadratica{
    private double a,b,c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminante(){
        return (b*b)-(4*a*c);
    }
    public double getRaiz1(){
        double discriminante=getDiscriminante();
        if(discriminante<0)return 0;
        return (-b+Math.sqrt(discriminante))/(2*a);
    }
    public double getRaiz2(){
        double discriminante=getDiscriminante();
        if(discriminante<0)return 0;
        return (-b-Math.sqrt(discriminante))/(2*a);
    }
}
public class Tpoo3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a,b,c;
        System.out.println("ingrese a,b,c");
        a=sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();
        EcuacionCuadratica ec=new EcuacionCuadratica(a,b,c);
        double discriminante=ec.getDiscriminante();
        if(discriminante>0){
            System.out.println("La ecuacion tiene 2 raices");
            System.out.println("Raiz 1: "+ec.getRaiz1());
            System.out.println("Raiz 2: "+ec.getRaiz2());
        }else if(discriminante==0){
            System.out.println("La ecuacion tiene una raiz: "+ec.getRaiz1());
        }else{
            System.out.println("La ecuacion no tiene Raices reales");
        }
    }
}
