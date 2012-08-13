package me.willie27.CustomPerks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CPFiles {
	
	public static int Tokens;
	public static String Perks;
	public static String Time;
	
	public static void mkfile(String playername) throws Exception{
		File loc = new File ("CustomPerks" + File.separator + "PlayerData" + File.separator + playername + ".txt");
		
		if (!loc.exists()){
			loc.createNewFile();
			
			FileWriter out = new FileWriter(loc);
			
			out.write("Tokens: 0");
			out.write("Perks: ");
			out.write("Time: ");
			
			out.close();
		}
	}
	
	public static void rdfile(String playername) throws Exception{
		File loc = new File ("CustomPerks" + File.separator + "PlayerData" + File.separator + playername + ".txt");
		
		if(!loc.exists()){
			mkfile(playername);
		}
		
		FileReader input = new FileReader(loc);
		BufferedReader in = new BufferedReader(input);
		
		String tokens = in.readLine().replace("Tokens: ", "");
		Tokens = Integer.parseInt(tokens);
		
		if (in.readLine().contains("Perks:")){
			Perks = in.readLine().replace("Perks:", "");
		}
		
		if (in.readLine().contains("Time:")){
			Time = in.readLine().replace("Time:", "");
		}
		
		in.close();
	}
	
	public static void wrfile(String playername, String perk, int cost, String time) throws Exception{
		File loc = new File ("CustomPerks" + File.separator + "PlayerData" + File.separator + playername + ".txt");
		
		if (!loc.exists()){
			mkfile(playername);
		}
		
		rdfile(playername);
		
		int tokens = Tokens - cost;
		String perks = Perks + ":" + perk;
		String times = Time + ":" + time;
		
		FileWriter out = new FileWriter(loc);
		
		out.write("Tokens: " + tokens + System.getProperty("line.separator"));
		out.write("Perks: " + perks + System.getProperty("line.separator"));
		out.write("Time: " + times + System.getProperty("line.separator"));
		
		out.close();
		
	}
}
