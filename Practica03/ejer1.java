import java.util.Scanner;
import java.util.Random;
class Juego{
    private int numeroDeVidas;
    private int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }
    
    public void reiniciarPartida(int numeroDeVidas){
        this.numeroDeVidas = numeroDeVidas;
    }
    
    public void actualizarRecord(){
        this.record++;
    }
    
    public boolean quitarVidas(){
        this.numeroDeVidas--;
        return this.numeroDeVidas > 0;
    }
}
class JuegoAdivinarNumero extends Juego{
    private int numeroAAdivinar;
    public JuegoAdivinarNumero(int vidas) {
        super(vidas);
    }
    public void juega(){
        reiniciarPartida(3);
        Random ran=new Random();
        this.numeroAAdivinar=ran.nextInt(11);
        Scanner sc=new Scanner(System.in);
        System.out.println("Adivina el numero del 0 al 10");
        while(true){
            int num=sc.nextInt();
            if(num==this.numeroAAdivinar){
                System.out.println("ACERTASTE!!!");
                actualizarRecord();
                break;
            }else{
                boolean hayVidas=quitarVidas();
                if(hayVidas){
                    if(num<this.numeroAAdivinar){
                        System.out.println("El numero a adivinar es mayor");
                    }else{System.out.println("El numero a adivinar es menor");}
                }else{System.out.println("Te quedaste sin vidas. El numero era: "+this.numeroAAdivinar);
                break;}
            }
        }
    }   
}
public class ejer1 {
    public static void main(String[] args) {
        JuegoAdivinarNumero ad = new JuegoAdivinarNumero(3);
        ad.juega();
    }
}
