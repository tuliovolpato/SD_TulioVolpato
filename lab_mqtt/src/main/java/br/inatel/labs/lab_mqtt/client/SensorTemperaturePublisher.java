package br.inatel.labs.lab_mqtt.client;
import org.eclipse.paho.client.mqttv3.*;

import java.util.Random;
import java.util.UUID;

public class SensorTemperaturePublisher {
    private static MqttMessage getTemperatureMessage() {
        Random r = new Random();
        double temperature = 80 + r.nextDouble() * 20.0;
        byte[] payload = String.format("T:%04.2f", temperature).getBytes();
        return new MqttMessage(payload);
    }

    public static void main(String[] args) {
        // Creating Publisher
        String publisherId = String.valueOf(UUID.randomUUID());
        try {

            IMqttClient publisher = new MqttClient(MyConstants.URI_BROKER,publisherId);



            // Connect into broker
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);
            publisher.connect(options);

            for (int i = 0; i < 200; i++) {
                // Creating message
                MqttMessage msg = getTemperatureMessage();
                msg.setQos(0);
                msg.setRetained(true);
                // Publishing messaging
                publisher.publish(MyConstants.TOPIC_SENSOR, msg);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


            // Disconnect
            publisher.disconnect();
            publisher.close();

        } catch (MqttException e) {
            throw new RuntimeException(e);
        }






    }

}
