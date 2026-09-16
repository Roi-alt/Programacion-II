package com.mycompany.tpoo;
//se usa la libreria random para llenar el arreglo 
//de manera automatica
import java.util.Random;

public class Tpoo {

    public static void main(String[] args) {
        int n=100000;
        int[]num= new int[n];
        Random ran= new Random();
        
        for(int i=0;i<n;i++){
            num[i]=ran.nextInt(10000000);
        }
        Cronometro crono=new Cronometro();
        
        for(int i=0;i<n;i++){
            int indi=i;
            for(int j=i+1;j<n;j++){
                if(num[j]<num[indi]){
                    indi=j;
                }
            }
            int temp=num[indi];
            num[indi]=num[i];
            num[i]=temp;
        }
        crono.detener();
        System.out.println("Tiempo de seleccion (de 100k numeros): "
                +crono.lapsoDeTiempo()+" ms");
    }
}
