package io.github.wreed12345;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MessagePasser implements Listener {
	/**
	 * Pass messages from mc to irc and vise versa
	 * 
	 * @author William Reed
	 * */

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String message = "/MSG #Minecraft " + event.getMessage();
		/*
		 * Thoughts on how to do this:
		 * 1. Possibly initiate a new connection to IRC server from the MC client.
		 * 		- Simplify's messaging and stuff.
		 * 		- not sure if possible
		 * 2. Add messages to array list of messages
		 * 		- send messages as they come into the array list (while arrayList != null) {sendMessages();}
		 * 		- then remove from array list
		 * 		- need to somehow keep track of users through this
		 * 3. Poop my pants
		 * 		- easiest method to do
		 * 		- most likely method to succeed
		 */
	}
	
	

}
