package bct.loadupstudios.WhelveCraft;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import bct.loadupstudios.WhelveCraft.EventManager;
import bct.loadupstudios.WhelveCraft.WhelveHunt.*;

public final class WhelveCraft extends JavaPlugin
{

	Logger logger = this.getLogger();
	FileConfiguration config = this.getConfig();
	boolean gameStarted = false;
	WhelveHunt whelveHunt;
	
	EventManager eventManager = new EventManager(config, logger);
	
    @Override
    public void onEnable() 
    {
    	saveDefaultConfig();
		getServer().getPluginManager().registerEvents(eventManager, this);
		logger.log(Level.INFO, "WhelveCraft Plugin loaded!");
    }
    
    @Override
    public void onDisable() 
    {
		saveConfig();
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
    {
    	if(command.getName().equalsIgnoreCase("whelvecraft"))
		{ 
			if(args.length > 0)
			{
				switch(args[0])
				{
					case "whelvehunt":
						if(sender.hasPermission("whelvecraft.staff"))
						{
							if(args.length >= 2 && args[1] != null)
							{
								switch(args[1])
								{
								case "begin":
									if(!gameStarted)
									{
										sender.sendMessage("Starting WhelveHunt");
										gameStarted = true;
										whelveHunt = new WhelveHunt(config, logger);
									}
									else
										sender.sendMessage("Game already started");
									return true;
								}
							}
						}
						else
							sender.sendMessage("You do not have the permission whelvecraft.staff");
						return true;
				}
			}
		}
    	else if(command.getName().equalsIgnoreCase("whelvehunt"))
    	{
    		if(sender.hasPermission("whelvecraft.staff"))
			{
	    		if(gameStarted && whelveHunt != null)
	    		{
	    			whelveHunt.whelveHuntCommand(sender, command, label, args);
	    		}
	    		else
	    		{
	    			sender.sendMessage("Game not started");
	    		}
			}
    		else
				sender.sendMessage("You do not have the permission whelvecraft.staff");
			return true;
    	}
    	return true;
    }

}
