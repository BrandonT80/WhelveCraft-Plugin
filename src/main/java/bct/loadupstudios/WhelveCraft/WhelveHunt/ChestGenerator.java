package bct.loadupstudios.WhelveCraft.WhelveHunt;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

public class ChestGenerator 
{
	private FileConfiguration config;
	Logger logger;
	
	ChestGenerator(FileConfiguration conf, Logger l)
	{
		config = conf;
		logger = l;
		logger.log(Level.INFO, "Chest Generation System Started");
	}
}
