package so.pf.data;

public class Consumidor implements Runnable{

    private Stack stack;
    private final Integer MILLISECONDS = 1000;
    private Integer timeout = 7;
    private Thread t;
    private boolean exit = false;

    public Consumidor(Stack stack){

        this.stack = stack;
    }

    public void iniciar(){

        t = new Thread(this, this.getClass().getName());

        t.start();
    }

    @Override
    public void run(){

        while (!exit){

            try {
                Thread.sleep(timeout * MILLISECONDS );

                System.out.println("Consumir elemento, ");
                stack.consumirSiguiente();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public void detener(){
        exit = true;
    }
}

