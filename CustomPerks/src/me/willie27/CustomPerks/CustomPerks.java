package me.willie27.CustomPerks;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomPerks extends JavaPlugin{
	
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		log.info("[CustomPerks] has been enabled!");
	}
	
	public void onDisable(){
		log.info("[CustomPerks] has been disabled!");
	}

}
