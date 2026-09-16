package com.mycompany.tpoo2;

import java.util.Scanner;
class EcuacionLineal{
    private double a,b,c,d,e,f;

    public EcuacionLineal(double a, double b, double c,
            double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public boolean tieneSolucion(){
        return (this.a*this.d-this.b*this.c)!=0;
    }
    public double getX(){
        return(this.e*this.d-this.b*this.f)/(this.a*this.d-this.b*this.c);
    }
    public double getY(){
        return(this.a*this.f-this.e*this.c)/(this.a*this.d-this.b*this.c);
    }
}

public class Tpoo2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ingrese a b c d e f");
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
        double d=sc.nextDouble();
        double e=sc.nextDouble();
        double f=sc.nextDouble();
        
        EcuacionLineal ec=new EcuacionLineal(a ,b ,c ,d ,e ,f );
        
        if(ec.tieneSolucion()){
            System.out.println("x= "+ec.getX()+" , y= "+ec.getY());
        }else{
            System.out.println("la ecuacion no tiene solucion");
        }
    }
}
