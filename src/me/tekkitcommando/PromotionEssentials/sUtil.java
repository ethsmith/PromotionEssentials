package me.tekkitcommando.PromotionEssentials;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class sUtil 
{
	
	public static MasterPromote plugin = MasterPromote.instance;
	
	
	
	@SuppressWarnings("unchecked")
	public static HashMap<String, Long> loadMap()
	{
		try
		{
		File file = new File(plugin.getDataFolder(), "/db.times");
		HashMap<String, Long> map = new HashMap<String, Long>();
		if(!file.exists())
		{
			file.getParentFile().mkdir();
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			oos.close();
		}
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		map = (HashMap<String, Long>) ois.readObject();
		ois.close();
		return map;
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public static void saveMap()
	{
		try
		{
		File file = new File(plugin.getDataFolder(), "/db.times");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(plugin.timepromote);
		oos.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static Boolean playerisonline(String playername)
	{
		try
		{
			@SuppressWarnings("deprecation")
			Player player = Bukkit.getPlayer(playername);
			if(player.isOnline())
			{
				return true;
			}
		}catch (Exception e) 
		{
			return false;
		}
		return false;
	}
	
	public static void log(String msg)
	{
		Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[" + plugin.getDescription().getName() + "] " + ChatColor.GRAY + msg);
	}
	
	public static void log(String msg, Boolean prefix)
	{
		if(!prefix)
		{
			Bukkit.getConsoleSender().sendMessage(msg);
		}
		else
		{
			Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[" + plugin.getDescription().getName() + "] " + ChatColor.GRAY + msg);
		}
	}

}
