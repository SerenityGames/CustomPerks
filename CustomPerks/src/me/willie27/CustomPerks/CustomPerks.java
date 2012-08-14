package me.willie27.CustomPerks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomPerks extends JavaPlugin{
	
	File configFile;
	File cptokensFile;
	FileConfiguration config;
	FileConfiguration cptokens;
	String userdata;
	
	public static String perklist;
	public static boolean Denabled;
	public static int Dvalue;
	public static boolean Dblock;
	public static boolean Ienabled;
	public static int Ivalue;
	public static boolean Iblock;
	public static boolean Genabled;
	public static int Gvalue;
	public static boolean Gblock;
	public static boolean Lenabled;
	public static int Lvalue;
	public static boolean Lblock;
	public static boolean Eenabled;
	public static int Evalue;
	public static boolean Eblock;
	
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		
		userdata = (getDataFolder() + File.separator + "UserData");
		configFile = new File (getDataFolder(), "config.yml");
		cptokensFile = new File (getDataFolder(), "CPTokens.yml");
		new File("PlayerData").mkdir();
		
		try {
			firstRun();
		} catch (Exception e){
			e.printStackTrace();
		}
		config = new YamlConfiguration();
		loadYamls();
		
		log.info("[CustomPerks] has been enabled!");
		
		perklist = getConfig().getString("Perks");
		
		Denabled = getConfig().getBoolean("Diamond.Enabled");
		Dvalue = getConfig().getInt("Diamond.Tokens");
		if (getConfig().getString("Diamond.Block").equalsIgnoreCase("on")){
			Dblock = true;
		}else{
			Dblock = false;
		}
		
		Ienabled = getConfig().getBoolean("Iron.Enabled");
		Ivalue = getConfig().getInt("Iron.Tokens");
		if (getConfig().getString("Iron.Block").equalsIgnoreCase("on")){
			Iblock = true;
		}else{
			Iblock = false;
		}
		
		Genabled = getConfig().getBoolean("Gold.Enabled");
		Gvalue = getConfig().getInt("Gold.Tokens");
		if (getConfig().getString("Gold.Block").equalsIgnoreCase("on")){
			Gblock = true;
		}else{
			Gblock = false;
		}
		
		Lenabled = getConfig().getBoolean("Lapis.Enabled");
		Lvalue = getConfig().getInt("Lapis.Tokens");
		if (getConfig().getString("Lapis.Block").equalsIgnoreCase("on")){
			Lblock = true;
		}else{
			Lblock = false;
		}
		
		Eenabled = getConfig().getBoolean("Emerald.Enabled");
		Evalue = getConfig().getInt("Emerald.Tokens");
		if (getConfig().getString("Emerald.Block").equalsIgnoreCase("on")){
			Eblock = true;
		}else{
			Eblock = false;
		}
		getCommand("CP").setExecutor(new CPCommands());
	}
	
	public void onDisable(){
		log.info("[CustomPerks] has been disabled!");
	}
	
	public void firstRun() throws Exception{
		if (!configFile.exists()){
			configFile.getParentFile().mkdirs();
			copy(getResource ("config.yml"), configFile);
		}
		if (!cptokensFile.exists()){
			cptokensFile.getParentFile().mkdirs();
			copy(getResource ("CPTokens.yml"), configFile);
			
		}
	}
	
	private void copy(InputStream in, File file){
		try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public void loadYamls() {
        try {
            config.load(configFile);
            cptokens.load(cptokensFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void saveYamls() {
        try {
            config.save(configFile);
            cptokens.save(cptokensFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
