package bct.loadupstudios.WhelveCraft.WhelveHunt;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class WhelveHunt
{
	private FileConfiguration config;
	Logger logger;
	WhelveHuntSetup setup;
	boolean setupMode = false;
	
	public WhelveHunt(FileConfiguration conf, Logger l)
	{
		config = conf;
		logger = l;
		logger.log(Level.INFO, "WhelveHunt System Started");
	}
	
    public boolean whelveHuntCommand(CommandSender sender, Command command, String label, String[] args) 
    {
		if(command.getName().equalsIgnoreCase("whelvehunt"))
		{ 
			if(sender.hasPermission("whelvehunt.staff"))
			{
				if(args.length > 0)
				{
					//Tag it command
					switch(args[0])
					{
						case "setup":
							sender.sendMessage("Setup found");
							if(setup != null)
							{
								sender.sendMessage("Setup mode already exists");
							}
							else
							{
								sender.sendMessage("Entering Setup Mode");
								setup = new WhelveHuntSetup();
								setupMode = true;
							}
							return true;
						default:
							break;
					}
				}
			}
		}
    	return false;
    }
}
