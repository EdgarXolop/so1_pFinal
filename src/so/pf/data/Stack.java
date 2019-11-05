package so.pf.data;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final Integer MAX = 10;
    private final Integer MIN = 0;
    private Integer cantidad = 0;

    private boolean agregando = false;
    private boolean consumiendo = false;

    public static Stack instancia = null;

    private Stack(){
    }

    public static Stack instancia(){

        if(instancia == null){
            instancia = new Stack();
        }

        return  instancia;
    }

    public void agregarSiguiente() throws InterruptedException {
        while(cantidad == MAX || consumiendo){
            System.out.println("AGREGAR: CANTIDAD " + cantidad);
        }
        agregando = true;
        cantidad ++; //seccion critica
        agregando = false;

        System.out.println("Se agrego un nuevo elemento, " + cantidad);

    }

    public void consumirSiguiente() throws InterruptedException {

        while(cantidad == MIN || agregando){
            System.out.println("CONSUMIDOR: CANTIDAD " + cantidad);
        }

        System.out.println("Se consumió un elemento, " + cantidad);

        consumiendo = true;
        cantidad--; //seccion critica
        consumiendo = false;

    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
