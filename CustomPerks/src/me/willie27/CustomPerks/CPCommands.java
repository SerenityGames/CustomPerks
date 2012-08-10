package me.willie27.CustomPerks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CPCommands implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd,String commandLabel, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("perk")){
			
			if (args.length > 1){
				
				if (args[1].equalsIgnoreCase("list")){
					sender.sendMessage("The current perks that are available on this server are:");
					sender.sendMessage(CustomPerks.perklist);
				}
				
				if (args[1].equalsIgnoreCase("tokens")){
					
				}
				
				if (args[1].equalsIgnoreCase("give")){
					
				}
				
				if (args[1].equalsIgnoreCase("remove")){
					
				}
				
				if (args[1].equalsIgnoreCase("buy")){
					
				}
				
				if (args[1].equalsIgnoreCase("sell")){
					
				}
				
				if (args[1].equalsIgnoreCase("pay")){
					
				}
				
			}
			
		}
		
		return false;
	}

}
