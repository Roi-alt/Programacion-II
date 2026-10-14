import java.util.Random;
import java.util.Scanner;

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
//me dio flojera validar un numero random en cada clase asi que
    public int generarNumeroRandom(){
        Random ran=new Random();
        return ran.nextInt(11);
    }
    public JuegoAdivinarNumero(int vidas) {
        super(vidas);
    }
    public void juega(){
        reiniciarPartida(3);
        this.numeroAAdivinar=generarNumeroRandom();
        Scanner sc=new Scanner(System.in);
        System.out.println("Adivina el numero del 0 al 10");
        while(true){
            int num=sc.nextInt();
            if(!validarNumero(num)){
                continue;
            }
            if(num==this.numeroAAdivinar){
                System.out.println("ACERTASTE!!!");
                actualizarRecord();
                break;
            }else{
                boolean hayVidas=quitarVidas();
                if(hayVidas){
                    if(num<this.numeroAAdivinar){
                        System.out.println("El numero a adivinar es mayor");
                    }else{
                        System.out.println("El numero a adivinar es menor");
                    }
                }else{System.out.println("Te quedaste sin vidas. El numero era: "+this.numeroAAdivinar);
                    break;}
            }
        }
    }
    public boolean validarNumero(int numero){
        return numero>=0 && numero <= 10;
    }
}
class JuegoAdivinaPar extends JuegoAdivinarNumero{
    public JuegoAdivinaPar(int vidas) {
        super(vidas);
    }
    //hice metodos auxiliares
    @Override
    public int generarNumeroRandom(){
        Random ran = new Random();
        return ran.nextInt(6)*2;
    }
    @Override
    public boolean validarNumero(int numero){
        if(super.validarNumero(numero)&&numero%2==0){
            return true;
        }
        System.out.println("Error: El numero debe ser un par entre (0-10)");
        return false;
    }
}
class JuegoAdivinaImpar extends JuegoAdivinarNumero{
    public JuegoAdivinaImpar(int vidas) {
        super(vidas);
    }
    //hice metodos auxiliares
    @Override
    public int generarNumeroRandom(){
        Random ran = new Random();
        return ran.nextInt(5)*2+1;
    }
    @Override
    public boolean validarNumero(int numero){
        if(super.validarNumero(numero)&&numero%2!=0){
            return true;
        }
        System.out.println("Error: El numero debe ser un impar entre (0-10)");
        return false;
    }
}

public class ejer2 {
    public static void main(String[] args) {
        System.out.println("JUEGO ADIVINAR NUMERO");
        JuegoAdivinarNumero juego1=new JuegoAdivinarNumero(3);
        juego1.juega();
        System.out.println("JUEGO ADIVINAR PAR");
        JuegoAdivinaPar juego2=new JuegoAdivinaPar(3);
        juego2.juega();
        System.out.println("JUEGO ADIVINAR IMPAR");
        JuegoAdivinaImpar juego3=new JuegoAdivinaImpar(3);
        juego3.juega();
    }
}
