package io.github.wreed12345;

public class MessagePasser {
	/**
	 * A mostly static class to pass things from the main plugin class to the
	 * IRC server class. May change dramatically WIP
	 * 
	 * @author William Reed
	 * */
	
	static void messageProcessor(String message){
		//add the message to the command
		//minecraft is the channel that this will use
		String command = "/MSG #minecraft " + message; 
	}
	
	//on player join innitate new IRC connection.
}
