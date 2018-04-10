package jms.server;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class MySender {

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public MySender() {

    }

    public void sendMessage(String m) {

        try {
            factory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, TopicSession.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("SAMPLETOPIC");
            producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setText(m);
            producer.send(message);
            System.out.println("Sent: " + message.getText());
            if (m.equals("exit")){
                connection.close();
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MySender sender = new MySender();
        Scanner scanner = new Scanner(System.in);
        boolean scannerChecker = true;
        while (scannerChecker) {
            String message = scanner.nextLine();
            if (message.equals("exit")){
                scannerChecker=false;
            }
            sender.sendMessage(message);
        }
    }

}