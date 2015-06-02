package me.tekkitcommando.PromotionEssentials.Commands;

import me.tekkitcommando.PromotionEssentials.MasterPromote;
import me.tekkitcommando.PromotionEssentials.Api.MPPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MPMPReloadCommand  implements CommandExecutor
{
	
	public MasterPromote plugin = MasterPromote.instance;

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
    	if(sender instanceof Player)
    	{
    		Player player = (Player) sender;
    		if(player.hasPermission("PromotionEssentials.reload"))
    		{
    			for(MPPlugin pl : plugin.plugins)
    			{
    				pl.reload();
    			}
    			sender.sendMessage(plugin.messages.getString("Reload").replace("&", "\u00A7"));
				System.out.println("[PLAYER_COMMAND] " + player.getName() + ": /mpreload");
    			return true;
    		}
    		else
    		{
    			player.sendMessage(plugin.messages.getString("NoPermissions").replace("&", "\u00A7"));
    			System.out.println("[PromotionEssentials]Player " + player.getName() + " tried to use /MPreload");
    			return true;
    		}
    	}
    	else // if commandsender is not a player
    	{
    	for(MPPlugin pl : plugin.plugins)
    	{
    		pl.save();
    		pl.reload();
    	}
    	System.out.println("[PromotionEssentials]Config succssesfully reloaded!");
    	return true;
    	}
	}

}
