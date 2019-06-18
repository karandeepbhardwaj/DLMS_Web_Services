package service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WebInterface {

	public String addItem(String managerID, String itemID, String itemName, int quantity);
	public String removeItem(String managerID, String itemID, int quantity, int option);
	public String listItemAvailability(String managerID);
	
	public String findItem(String userID, String itemName, boolean fromOtherServer);
	public String borrowItem(String userID, String itemID);
	public String returnItem(String userID, String itemID);
	public String waitingList(String userID, String itemID);
	public String exchangeItem(String userID, String oldItemID, String newItemID, boolean fromOtherServer);
}
