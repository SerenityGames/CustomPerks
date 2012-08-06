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
	FileConfiguration config;
	String userdata;
	
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){
		
		userdata = (getDataFolder() + "\\UserData");
		configFile = new File (getDataFolder(), "config.yml");
		try {
			firstRun();
		} catch (Exception e){
			e.printStackTrace();
		}
		config = new YamlConfiguration();
		loadYamls();
		
		log.info("[CustomPerks] has been enabled!");
	}
	
	public void onDisable(){
		log.info("[CustomPerks] has been disabled!");
	}
	
	public void firstRun() throws Exception{
		if (!configFile.exists()){
			configFile.getParentFile().mkdirs();
			copy(getResource ("config.yml"), configFile);
			new File(userdata).mkdir();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void saveYamls() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
