package me.willie27.CustomPerks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CPCommands implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd,String commandLabel, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("perk")){
			
			if (args.length > 0){
				
				if (args[0].equalsIgnoreCase("list")){
					sender.sendMessage("The current perks that are available on this server are:");
					sender.sendMessage(CustomPerks.perklist);
				}
				
				if (args[0].equalsIgnoreCase("tokens")){
					
					try {
						CPFiles.rdfile(sender.getName());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					sender.sendMessage("You currently have " + CPFiles.Tokens + " tokens!");
				}
				
				if (args[0].equalsIgnoreCase("give")){
					
					if (sender.hasPermission("customperks.give")){
						if (args.length > 1){
						
							String playername = args[1];
						
							if (args.length > 2){
							
								int amount = Integer.parseInt(args[2]);
							
								try {
									CPFiles.rdfile(playername);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
								int tokens = CPFiles.Tokens + amount;
							
								try {
									CPFiles.wrfile(playername, tokens, CPFiles.Perks , CPFiles.Time);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							
								sender.sendMessage("Gave " + playername + " " + tokens + " tokens!");
							}
						}
					}else{
						
						sender.sendMessage("You do not have permission to use that command!");
						
					}
				}
				
				if (args[0].equalsIgnoreCase("remove")){
					
				}
				
				if (args[0].equalsIgnoreCase("buy")){
					
					if (sender.hasPermission("customperks.perk.buy")){
						
						if (args.length > 1){
							
							String perk = args[1];
							
							if (CustomPerks.perklist.contains(perk)){
								
								
								
							}else{
								
								sender.sendMessage(perk + " Is not a perk!");
								
							}
							
						}
						
					}
					
				}
				
				if (args[0].equalsIgnoreCase("sell")){
					
				}
				
				if (args[0].equalsIgnoreCase("pay")){
					
				}
				
			}
			
		}
		
		return false;
	}

}
