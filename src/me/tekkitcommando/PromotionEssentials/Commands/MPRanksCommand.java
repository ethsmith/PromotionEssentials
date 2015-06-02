package me.tekkitcommando.PromotionEssentials.Commands;

import java.util.List;

import me.tekkitcommando.PromotionEssentials.MasterPromote;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MPRanksCommand implements CommandExecutor 
{
	
	public static MasterPromote plugin = MasterPromote.instance;
	
	public boolean onCommand(CommandSender sender, Command command, String label,	String[] args) 
	{
    	if(sender instanceof Player)
    	{
    		Player player = (Player) sender;
    		if(player.hasPermission("PromotionEssentials.rank.list"))
    		{
				@SuppressWarnings("unchecked")
				List<String> ranks = (List<String>) plugin.config.getList("Ranks");
    			Object[] array =ranks.toArray();
				player.sendMessage(ChatColor.GREEN + "Buyable ranks:");
    			for(int i = 0; i<array.length;i++)
    			{
    				String[] rank = array[i].toString().split(",");
    				String group = rank[0];
    				Double price = Double.parseDouble(rank[1]);
    				if(price == 1)
    				{
    				player.sendMessage(ChatColor.BLUE + group + " " + price +  " " + plugin.economy.currencyNameSingular());
    				}
    				else
    				{
        				player.sendMessage(ChatColor.BLUE + group + " " + price + " " + plugin.economy.currencyNamePlural());
    				}
    			}
				System.out.println("[PLAYER_COMMAND] " + player.getName() + ": /ranks");
				return true;
    		}
    		else
    		{
    			player.sendMessage(plugin.messages.getString("NoPermissions").replace("&", "\u00A7"));
    			System.out.println("[PromotionEssentials]Player " + player.getName() + " tried to use /ranks");
    			return true;
    		}
    	}
    	else
    	{
			@SuppressWarnings("unchecked")
			List<String> ranks = (List<String>) plugin.config.getList("Ranks");
			Object[] array =ranks.toArray();
			System.out.println("Buyable ranks:");
			for(int i = 0; i<array.length;i++)
			{
				String[] rank = array[i].toString().split(",");
				String group = rank[i];
				Double price = Double.parseDouble(rank[1]);
				if(price == 1)
				{
					System.out.println(group + " " + price + " " +  plugin.economy.currencyNameSingular());
				}
				else
				{
				System.out.println(group + " " + price + " " + plugin.economy.currencyNamePlural());
				}
			}
			return true;
    		
    	}

	}
}
