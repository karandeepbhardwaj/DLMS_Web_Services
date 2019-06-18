package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.xml.ws.Endpoint;

import constants.*;
import serverImplementation.*;

public class ConServer {

	public static void receive(ConLibImpl implementation) {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(ConstantValues.CONCORDIA_SERVER_PORT);
			System.out.println("Concordia Server Started");
			while (true) {
				byte[] buffer = new byte[1000];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				String message = new String(request.getData());
				String [] data = message.split("-");
				String userID = data[0].trim();
				String itemID = data[1].trim();
				String itemName = data[3].trim();
				String newItemID = data[4].trim();
				String responseString = "";
				switch(data[2].trim()) {
				case "1": responseString = implementation.borrowItem(userID, itemID);
				break;
				case "2": responseString = implementation.findItem(userID, itemName, true);
				break;
				case "3": responseString = implementation.returnItem(userID, itemID);
				break;
				case "4": responseString = implementation.waitingList(userID, itemID);
				break;
				case "5": responseString = implementation.exchangeItem(userID, itemID, newItemID,true);
				break;
				case "6": responseString = implementation.bookPresent(userID, itemID,newItemID);
				break;
				case "7": responseString = implementation.bookBorrowed(userID, itemID);
				break;
				}
				DatagramPacket reply = new DatagramPacket(responseString.getBytes(), responseString.length(), request.getAddress(),
						request.getPort());
				aSocket.send(reply);
			}
		}catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
	}

	public static void main(String[] args) {

		ConLibImpl conStub = new ConLibImpl();
		Runnable task = () -> {
			receive(conStub);
		};
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/comp", conStub);
		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Concordia Server Started...");
		
	}
}	
