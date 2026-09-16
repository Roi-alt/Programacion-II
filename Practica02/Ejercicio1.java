class MiPunto{
    private double x;
    private double y;

    public MiPunto() {
        this.x = 0;
        this.y = 0;
    }
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double distancia(MiPunto o){
        return Math.sqrt(Math.pow(this.x-o.getX(),2)+Math.pow(this.y-o.getY(),2));
    }
    public double distancia(double x,double y){
        return Math.sqrt(Math.pow(this.x-x,2)+Math.pow(this.y-y,2));
    }   
}
public class Ejercicio1 {
    public static void main(String[] args) {
        MiPunto p1 = new    MiPunto();
        MiPunto p2 = new    MiPunto(3,4);
        System.out.println("p1 ("+p1.getX()+" , "+p1.getY()+")");
        System.out.println("p2 ("+p2.getX()+" , "+p2.getY()+")");
        double d1 = p1.distancia(p2);
        System.out.println(d1);
        double d2 = p1.distancia(3,4);
        System.out.println(d2);
    }
}
