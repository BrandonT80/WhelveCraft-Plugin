package bct.loadupstudios.WhelveCraft;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.logging.Logger;

public class EventManager implements Listener
{
	private FileConfiguration config;
    Logger logger;
    
    EventManager(FileConfiguration conf, Logger l)
	{
		config = conf;
		logger = l;
	}
    
	
	public void reload(FileConfiguration conf)
	{
		config = conf;
	}
	
	public void registerSystems()
	{

	}
	
}