package me.willie27.CustomPerks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CPCommands implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd,String commandLabel, String[] args){
		
		if (args.length > 0){
			
			//List available perks.
			if(cmd.getName().equalsIgnoreCase("list")){
				
				
			}
			
			//Buy Perks.
			if(cmd.getName().equalsIgnoreCase("buy")){
				
			}
			
			//Sell available items for tokens.
			if(cmd.getName().equalsIgnoreCase("sell")){
				
			}
			
			//Lists amount of tokens the player has.
			if (cmd.getName().equalsIgnoreCase("tokens")){
				
			}
			
		}
		return false;
	}

}
