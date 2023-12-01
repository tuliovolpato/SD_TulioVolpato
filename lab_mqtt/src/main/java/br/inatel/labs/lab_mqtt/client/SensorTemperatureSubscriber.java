package br.inatel.labs.lab_mqtt.client;

import org.eclipse.paho.client.mqttv3.*;

import java.util.Arrays;
import java.util.UUID;

public class SensorTemperatureSubscriber {
    public static void main(String[] args) {
        String subscriberId = UUID.randomUUID().toString();
        try {
            IMqttClient subscriber = new MqttClient( MyConstants.URI_BROKER, subscriberId);

            // Connecting
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            subscriber.connect(options);

            // Receiving message
            subscriber.subscribe(MyConstants.TOPIC_SENSOR, (topic, msg) -> {
                byte[] payload = msg.getPayload();
                System.out.println( "Message: " + msg);
                System.out.println( "Topico recebido: " + topic );
            });


            subscriber.close();
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }


}
