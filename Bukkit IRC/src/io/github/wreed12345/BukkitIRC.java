package io.github.wreed12345;

import io.github.wreed12345.Connection.Channel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitIRC extends JavaPlugin implements Listener {

	/**
	 * @author William Reed
	 * @since 0.0.1 Alpha
	 */

	final String VERSION = "0.0.1 Alpha";

	volatile Connection ircServer;

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new MessagePasser(), this);

		// should i be worrying about layers of these threads? threads on
		// threads on threads...
		Bukkit.getServer().getScheduler()
				.runTaskAsynchronously(this, new Runnable() {
					// args = server name
					String[] args = { "applesauce" };

					public void run() {

						try {
							ServerSocket ss = new ServerSocket(6667);
							Connection.globalServerName = "apple";
							while (true) {
								Socket s = ss.accept();
								ircServer = new Connection(s);
								Thread thread = new Thread(ircServer);
								thread.start();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				});

		getLogger().info("Bukkit IRC " + VERSION + " has been enabled!");
	}

	@Override
	public void onDisable() {

		getLogger().info("Bukkit IRC " + VERSION + " has been disabled");
	}

	volatile Connection bot;

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("startbot")) {
			try {
				bot = new Connection(new Socket("69.124.183.152", 6667));
				System.out.println("bot created, although it may not work");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return true;
		}
		if (cmd.getName().equalsIgnoreCase("apples")) {
			try {
				// mainBot.send(":" + Connection.globalServerName + " NOTICE " +
				// "wreed" + " :" + "hey:D");
				bot.processLine("NICK MTC");
				bot.processLine("USER MTC");
				// ircServer.processLine("USERHOST MTC");
				//bot.processLine("JOIN #minecraft");
				// bircServer.processLine("PRIVMSG #minecraft :hey");

				System.out.println("command executed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("something went wrong");
			}
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("pears")) {
			try {
				// ircServer.processLine("MSG #minecraft :hey");
				bot
						.processLine("PRIVMSG #minecraft :hey guys its wreed");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (cmd.getName().equalsIgnoreCase("irccommand")) {
			if(args.length > 1){
				//bot.processLine(args);
			}
		}

		// if (cmd.getName().equalsIgnoreCase("autobump")) {

		return false;
	}

	// SEND MESSAGES FROM MC USERS AS "minecraft: <username> Hey guys!"
	// only requires one connection

}
