import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterface extends Remote{
	
	/* the server interface to display all the methods available in server  to store or return a message from or to any requesting process. */
	
	
	void getClearence(String s) throws RemoteException;
	/*to make the server persistent saving the inputs taken from students into a file.
	*/
	ArrayList getClearenceRequests() throws RemoteException;
	/*to get cleareance the student process sends the string conatinaing the student name and course name.
	it takes the input and saves in a arraylist datastructure
	*/
	
	
	void setClearenceRequests(ArrayList<String> a) throws RemoteException;
	/*this function takes input a an arraylist and sets the decision to the arraylist present in the server.
	 */

	ArrayList getDecision() throws RemoteException;
	/*
	 * this is called by the notification process to display the decision for the student process.
	 */
	
	
	void persistMessages(String input) throws RemoteException,IOException;
	/*this method takes the input string from the student process and saves in the data structure and the file simultaneously
	 */
	
	
	
	void deleteMessages(ArrayList<String> a)throws RemoteException;
	/*this method takes input from the notification process, the displayed messages and deletes it from the data structure as well as in the file
	 * 
	 */

}
