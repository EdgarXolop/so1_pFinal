package so.pf.data;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final Integer MAX = 10;
    private final Integer MIN = 0;
    private List<Boolean> listado = new ArrayList<>();

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
        while(getCantidad() == MAX || consumiendo){
            System.out.println("AGREGAR: CANTIDAD " + getCantidad());
        }
        agregando = true;
        listado.add(true); //seccion critica
        agregando = false;

        System.out.println("Se agrego un nuevo elemento, " + getCantidad());

    }

    public void consumirSiguiente() throws InterruptedException {

        while(getCantidad() == MIN || agregando){
            System.out.println("CONSUMIDOR: CANTIDAD " + getCantidad());
        }

        System.out.println("Se consumió un elemento, " + getCantidad());

        consumiendo = true;
        listado.remove(0); //seccion critica
        consumiendo = false;

    }

    public Integer getCantidad() {
        return listado.size();
    }
}
