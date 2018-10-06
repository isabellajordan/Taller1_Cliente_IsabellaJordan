package com.example.isabellajordanb.taller1_cliente_isabellajordan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import comunicacion.Cliente;
import comunicacion.Control;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    Button arriba;
    Button derecha;
    Button izquierda;
    Button abajo;

    //Inicializacion cliente

    Cliente cliente;

    //inicializar control
    Control control;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializar cliente y control

        cliente= new Cliente("172.30.167.88",5000);
        cliente.start();

        control= new Control();

        arriba= findViewById(R.id.btn_arriba);
        derecha= findViewById(R.id.btn_derecha);
        abajo= findViewById(R.id.btn_abajo);
        izquierda= findViewById(R.id.btn_izquierda);

        arriba.setOnTouchListener(this);
        derecha.setOnTouchListener(this);
        abajo.setOnTouchListener(this);
        izquierda.setOnTouchListener(this);

    }

    public void keyPressed(View boton){

        switch (boton.getId()){

            case R.id.btn_arriba:
                control.arriba = true;
                //acutaliza los datos que envia
                cliente.enviarDatos(control);

            break;


            case R.id.btn_derecha:
                control.derecha = true;
                cliente.enviarDatos(control);

                break;


            case R.id.btn_abajo:
                control.abajo = true;
                cliente.enviarDatos(control);

                break;

            case R.id.btn_izquierda:
                control.izquierda = true;
                cliente.enviarDatos(control);

                break;

        }

    }

    public void keyReleased(View boton){

        switch (boton.getId()){

            case R.id.btn_arriba:
                control.arriba = false;
                cliente.enviarDatos(control);

                break;


            case R.id.btn_derecha:
                control.derecha = false;
                cliente.enviarDatos(control);

                break;


            case R.id.btn_abajo:
                control.abajo = false;
                cliente.enviarDatos(control);

                break;

            case R.id.btn_izquierda:
                control.izquierda = false;
                cliente.enviarDatos(control);

                break;

        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //si ha presionado
        if(event.getAction()== MotionEvent.ACTION_DOWN){
            keyPressed(v);

        }else if(event.getAction()== MotionEvent.ACTION_UP){
            keyReleased(v);

        }

        return false;
    }
}
