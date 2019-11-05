package so.pf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import so.pf.data.Consumidor;
import so.pf.data.Productor;
import so.pf.data.Stack;

public class Controller {

    Productor productor;
    Consumidor consumidor;


    @FXML
    private TextField txtProductor;
    @FXML
    private TextField txtConsumidor;

    @FXML
    private Rectangle rect1;
    @FXML
    private Rectangle rect2;
    @FXML
    private Rectangle rect3;
    @FXML
    private Rectangle rect4;
    @FXML
    private Rectangle rect5;
    @FXML
    private Rectangle rect6;
    @FXML
    private Rectangle rect7;
    @FXML
    private Rectangle rect8;
    @FXML
    private Rectangle rect9;
    @FXML
    private Rectangle rect10;

    private Thread hiloControladorUI;

    public Controller(){

    }

    @FXML
    private void initialize()
    {
        txtProductor.setText("5");
        txtConsumidor.setText("7");


        productor = new Productor(Stack.instancia());
        consumidor = new Consumidor(Stack.instancia());

        consumidor.iniciar();
        productor.iniciar();

        hiloControladorUI = new Thread(new Runnable() {

            @Override
            public void run() {

                while (true){
                    try {
                        Thread.sleep(100);

                        if(Stack.instancia().getCantidad() >= 1){
                            rect1.setFill(Color.BLUEVIOLET);
                        }else{
                            rect1.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 2){
                            rect2.setFill(Color.BLUEVIOLET);
                        }else{
                            rect2.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 3){
                            rect3.setFill(Color.BLUEVIOLET);
                        }else{
                            rect3.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 4){
                            rect4.setFill(Color.BLUEVIOLET);
                        }else{
                            rect4.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 5){
                            rect5.setFill(Color.BLUEVIOLET);
                        }else{
                            rect5.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 6){
                            rect6.setFill(Color.BLUEVIOLET);
                        }else{
                            rect6.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 7){
                            rect7.setFill(Color.BLUEVIOLET);
                        }else{
                            rect7.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 8){
                            rect8.setFill(Color.BLUEVIOLET);
                        }else{
                            rect8.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 9){
                            rect9.setFill(Color.BLUEVIOLET);
                        }else{
                            rect9.setFill(Color.GRAY);
                        }

                        if(Stack.instancia().getCantidad() >= 10){
                            rect10.setFill(Color.BLUEVIOLET);
                        }else{
                            rect10.setFill(Color.GRAY);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        hiloControladorUI.start();

    }

    @FXML
    public void actulizarTiempos(ActionEvent event)
    {
        if(txtProductor.getText().matches("\\d")){
            productor.setTimeout(Integer.parseInt(txtProductor.getText()));
        }else{
            txtProductor.setText(productor.getTimeout().toString());
        }

        if(txtConsumidor.getText().matches("\\d")){
            consumidor.setTimeout(Integer.parseInt(txtConsumidor.getText()));
        }else{
            txtConsumidor.setText(consumidor.getTimeout().toString());
        }
    }


    public void shutdown(){

        hiloControladorUI.stop();
        productor.detener();
        consumidor.detener();
    }

}
