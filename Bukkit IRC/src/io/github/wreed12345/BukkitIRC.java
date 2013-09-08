package io.github.wreed12345;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitIRC extends JavaPlugin implements Listener {

	/** @author William Reed */

	final String VERSION = "0.0.1 Alpha";
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new MessagePasser(), this);
		
		//should i be worrying about layers of these threads? threads on threads on threads...
		Bukkit.getServer().getScheduler().runTaskAsynchronously(this, new Runnable() {
			//args = server name
			String[] args = {"applesauce"};
			public void run() {
				try {
					Connection.run(args);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		getLogger().info("Bukkit IRC " + VERSION + " has been enabled!");
	}

	@Override
	public void onDisable() {

		getLogger().info("Bukkit IRC " + VERSION + " has been disabled");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		// if (cmd.getName().equalsIgnoreCase("autobump")) {

		return false;
	}
	
}
