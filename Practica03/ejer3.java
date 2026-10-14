class Sensor{
    protected static String tipo = "Generico";
    protected String id;
    protected boolean encendido;
    
    public Sensor(String id){
        this.id=id;
        this.encendido=false;
    }
    public void activar(){
        this.encendido=true;
        System.out.println("el sensor "+id+" activado");
    }
    public void desactivar(){
        this.encendido=false;
        System.out.println("el sensor "+id+" desactivado");
    }
}
class Camara extends Sensor{
    protected static String tipo = "Camara";
    protected String resolucion;

    public Camara(String id, String resolucion) {
        super(id);
        this.resolucion = resolucion;
    }
}
class SensorLuzLaser extends Sensor{
    protected static String tipo = "Luz Laser";
    protected int alcance;

    public SensorLuzLaser(String id, int alcance) {
        super(id);
        this.alcance = alcance;
    }
}
class VehiculoAutonomo extends Sensor{
    protected static String tipo = "Vehiculo Autonomo";
    private Camara camara;
    private SensorLuzLaser sensorLaser;

    public VehiculoAutonomo(String id,String resolucion,int alcance){
        super(id);
        this.camara = new Camara(id, resolucion);
        this.sensorLaser = new SensorLuzLaser(id, alcance);
    }
    public void encenderSistema(){
        super.activar();
        System.out.println(
       "Vehiculo autonomo encendido resolucion  de camara: "
        +camara.resolucion+" alcance: "+sensorLaser.alcance+" m ");
    }
    public void apagarSistema(){
        super.desactivar();
        System.out.println("Vehiculo autonomo apagado");
    }
}
public class ejer3 {
    public static void main(String[] args) {
        VehiculoAutonomo vh=new VehiculoAutonomo("VAR-1344","4K",100);
        vh.encenderSistema();
        System.out.println();
        vh.apagarSistema();
    }
}
