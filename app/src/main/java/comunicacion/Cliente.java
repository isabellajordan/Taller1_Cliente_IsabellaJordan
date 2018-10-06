package comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente extends Thread{

    Socket socket;
    int puerto;
    String ip;

    public Cliente (String ip, int puerto){
        this.ip=ip;
        this.puerto=puerto;

    }

    @Override
    public void run() {
        try {
            socket= new Socket(ip,puerto);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void enviarDatos ( final Control control){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //salida= enviar datos (ruta)
                    OutputStream salida= socket.getOutputStream();

                    //objeto de salida
                    ObjectOutputStream objetoSalida= new ObjectOutputStream(salida);

                    //enviar mensaje es decir enviar la clase control
                    objetoSalida.writeObject(control);



                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();



    }



}
