class AlgebraVectorial{
    private double[] a;
    private double[] b;

    public AlgebraVectorial() {
        this.a = new double[]{0,0};
        this.b = new double[]{0,0};
    }
    public AlgebraVectorial(double[] a, double[] b) {
        this.a = a;
        this.b = b;
    }
    public boolean perpendicular(String opsa){
        double[] suma = sumar(a,b);
        double[] resta = restar(a,b);
        return magnitud(suma) == magnitud(resta);
    }
    public boolean perpendicular(char opsb){
        double[] r1=restar(a,b);
        double[] r2=restar(b,a);
        return magnitud(r1) == magnitud(r2);
    }
    public boolean perpendicular(){
        return productoPunto(a,b) == 0;
    }
    public boolean perpendicular(boolean pit){
        double[] sum = sumar(a,b);
        double magsum = Math.pow(magnitud(sum), 2);
        double maga = Math.pow(magnitud(a), 2);
        double magb = Math.pow(magnitud(b), 2);
        return magsum == (maga + magb);
    }
    public boolean paralela(){
    if (b[0] == 0 && b[1] == 0) return false;
        double r = 0;
        boolean ini = false;
        for (int i = 0; i < a.length; i++) {
            if (b[i] != 0) {
                double razon = a[i] / b[i];
                if (!ini) {
                    r = razon;
                    ini = true;
                } else if (r != razon) {
                    return false;
                }
            } else if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public boolean paralela(double tole) {
        if (a.length >= 2 && b.length >= 2) {
            double cruz = (a[0] * b[1]) - (a[1] * b[0]);
            return Math.abs(cruz) < tole;
        }
        return false;
    }
    public double[] proyeccionDeAsobreB() {
        double dot = productoPunto(a, b);
        double magSqB = Math.pow(magnitud(b), 2);
        if (magSqB == 0) return new double[]{0, 0};
        double escalar = dot / magSqB;
        
        double[] resultado = new double[b.length];
        for (int i = 0; i < b.length; i++) {
            resultado[i] = escalar * b[i];
        }
        return resultado;
    }
    public double componenteDeAenB() {
        double dot = productoPunto(a, b);
        double magB = magnitud(b);
        if (magB == 0) return 0;
        return dot / magB;
    }
    //metodos auxiliares
    private double productoPunto(double[] v1,double[] v2){
        double sum = 0;
        for(int i=0;i<v1.length;i++)sum+=v1[i]*v2[i];
        return sum;
    }
    private double magnitud(double[] v){
        return Math.sqrt(productoPunto(v,v));
    }
    private double[] sumar(double[] v1,double[] v2){
        double[] res=new double[v1.length];
        for(int i=0;i<v1.length;i++) res[i]=v1[i]+v2[i];
        return res;
    }
    private double[] restar(double[] v1,double[] v2){
        double[] res=new double[v1.length];
        for(int i=0;i<v1.length;i++) res[i]=v1[i]-v2[i];
        return res;
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        AlgebraVectorial avDefault = new AlgebraVectorial(); 
        System.out.println("Objeto creado con constructor por defecto.");
        double[] vecA = {2.0, 4.0};
        double[] vecB = {-4.0, 2.0};
        AlgebraVectorial av = new AlgebraVectorial(vecA, vecB);
        boolean p1 = av.perpendicular("opcionA");
        System.out.println("a) |a+b| == |a-b| -> " + p1);
        boolean p2 = av.perpendicular('b');
        System.out.println("b) |a-b| == |b-a| -> " + p2);
        boolean p3 = av.perpendicular();
        System.out.println("c) a * b == 0 -> " + p3);
        boolean p4 = av.perpendicular(true);
        System.out.println("d) |a+b|^2 == |a|^2 + |b|^2 -> " + p4 + "\n");
        AlgebraVectorial avParalelo = new AlgebraVectorial(new double[]{2.0, 4.0}, new double[]{4.0, 8.0});
        boolean par1 = avParalelo.paralela();
        System.out.println("e) a = r * b -> " + par1);
        boolean par2 = avParalelo.paralela(0.0001);
        System.out.println("f) Producto cruz 2D con tolerancia -> " + par2 );
        double[] proyeccion = av.proyeccionDeAsobreB();
        System.out.println("Proyeccion de a sobre b: [" + proyeccion[0] + ", " + proyeccion[1] + "]");
        double componente = av.componenteDeAenB();
        System.out.println("Componente de a en b: " + componente);
    }
}
