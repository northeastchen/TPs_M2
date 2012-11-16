package TAA.TP4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import TAA.TP4.client.IClient;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "client_store.xml" });
		IClient client = (IClient) context.getBean("client");

		client.run();
	}
}
