package com.mycompany.tpoo;

public class Cronometro {
    private long inicia;
    private long finaliza;
    
    public Cronometro(){
        inicia();
    }
    //se uso current para medir en tiempo real el ordenamiento
    public void inicia(){
        this.inicia=System.currentTimeMillis();
    }
    public void detener(){
        this.finaliza=System.currentTimeMillis();
    }
    public long lapsoDeTiempo(){
        return this.finaliza-this.inicia;
    }
    public long getInicia(){
        return inicia;
    }
    public long getFinalizar(){
        return finaliza;
    }
}
