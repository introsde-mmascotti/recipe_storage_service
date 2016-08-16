package server;

import java.net.InetAddress;
import java.net.URI;

import javax.xml.ws.Endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import recipestorage.service.RecipeDB;

public class RecipeStorageServer {
	private static final Logger logger = LogManager.getFormatterLogger("RecipeStorageServer");
	private static int port = 6900;

	public static void main(String[] args) throws Exception {
		
		checkEnvironment();

		String hostname = InetAddress.getLocalHost().getHostAddress();
		if (hostname.equals("127.0.0.1"))
			hostname = "localhost";

		if (args.length >= 1)
			port  = Integer.parseInt(args[0]);
		else
			logger.info("No port specified in arguments. Using default port: " + port);
		
		String url_str = String.format("http://%s:%d/", hostname, port);
		URI baseUrl = new URI(url_str);

		Endpoint.publish(url_str, new RecipeDB());
		
		logger.info("Server started: " + baseUrl);
	}

	private static void checkEnvironment() {
		String uri_str = System.getenv("DATABASE_URL");
		if (uri_str == null) {
			logger.fatal("The system environment variable 'DATABASE_URL' is not set.");
			logger.fatal("The recipe storage service is not functional. Exiting.");
			System.exit(-1);
		}
	}
}