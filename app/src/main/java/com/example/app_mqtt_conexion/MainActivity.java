package com.example.app_mqtt_conexion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Build;//para obtener el nombre del dispositivo
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    //parametros del broker la siguiente variable con el broker de shiftr.io
    static String MQTTHOST = "broker.mqttdashboard.com"; //el broker
    static String USERNAME = "Diego";//el token de acceso
    static String PASSWORD = "hola";    //la contraceña del token
    String topicStr ="diegosci";
    MqttAndroidClient client;  //  clienteMQTT este dispositivo
    EditText e1;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       e1 = (EditText) findViewById(R.id.et1);

       //String clientId = MqttClient.generateClientId(); //MqttClient.generateClientId();//noombre del celular
       String clientId = MqttClient.generateClientId();
       client =
               new MqttAndroidClient(this.getApplicationContext(), "tcp://broker.mqttdashboard.com:1883",
                       clientId);

       try {
           IMqttToken token = client.connect();
           token.setActionCallback(new IMqttActionListener() {
               @Override
               public void onSuccess(IMqttToken asyncActionToken) {
                   // We are connected
                   Toast.makeText(getBaseContext(), "Conectado ", Toast.LENGTH_SHORT).show();

               }

               @Override
               public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                   // Something went wrong e.g. connection timeout or firewall problems
                   Toast.makeText(getBaseContext(), "Publicado", Toast.LENGTH_SHORT).show();

               }
           });
       } catch (MqttException e) {
           e.printStackTrace();
       }
    }

    public void SenderON(View view) {
        try{
            client.subscribe("Diego/Sci",0);

        }catch (MqttException e){
            e.printStackTrace();
        }
        try{
            MqttMessage message = new MqttMessage(("ON").getBytes());
            client.publish("Diego/Sci", message);
        }catch (MqttException e){
            e.printStackTrace();
        }

    }

    public void SenderOFF(View view) {
        try{
            client.subscribe("Diego/Sci",0);

        }catch (MqttException e){
            e.printStackTrace();
        }
        try{
            MqttMessage message = new MqttMessage(("OFF").getBytes());
            client.publish("Diego/Sci", message);
        }catch (MqttException e){
            e.printStackTrace();
        }

    }

    public void SenderUP(View view) {
        try{
            client.subscribe("Diego/Sci",0);

        }catch (MqttException e){
            e.printStackTrace();
        }
        try{
            MqttMessage message = new MqttMessage(("UP").getBytes());
            client.publish("Diego/Sci", message);
        }catch (MqttException e){
            e.printStackTrace();
        }

    }

    public void SenderDOWN(View view) {
        try{
            client.subscribe("Diego/Sci",0);

        }catch (MqttException e){
            e.printStackTrace();
        }
        try{
            MqttMessage message = new MqttMessage(("DOWN").getBytes());
            client.publish("Diego/Sci", message);
        }catch (MqttException e){
            e.printStackTrace();
        }

    }
}