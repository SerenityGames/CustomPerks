package me.willie27.CustomPerks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class CPListener implements Listener{
	
	@EventHandler
	public void PlayerLogin(PlayerLoginEvent event){
		Player player = event.getPlayer();
		
		try {
			CPFiles.mkfile(player.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
