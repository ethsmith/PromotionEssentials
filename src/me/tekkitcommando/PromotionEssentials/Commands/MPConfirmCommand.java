package me.tekkitcommando.PromotionEssentials.Commands;

import java.util.List;

import me.tekkitcommando.PromotionEssentials.MasterPromote;
import me.tekkitcommando.PromotionEssentials.Api.PlayerPromoteEvent.PROMOTIONTYPE;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MPConfirmCommand implements CommandExecutor 
{
	
	public MasterPromote plugin = MasterPromote.instance;
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label,	String[] args) 
	{
    	if(sender instanceof Player)
    	{
    		Player player = (Player) sender;
    		if(plugin.confirm.containsKey(player))
    		{
    			String group = plugin.confirm.get(player);
      			@SuppressWarnings("unchecked")
				List<String> ranks = (List<String>) plugin.config.getList("Ranks");
    			for(String value : ranks)
    			{
    				String[] rank = value.split(",");
    				String group1 = rank[0];
    				Double price = Double.parseDouble(rank[1]);
    				if(group.equals(group1))
    				{
    					if(plugin.economy.has(player.getName(), price))
    					{
    						plugin.economy.withdrawPlayer(player.getName(), price);
    						plugin.getPermissionsHandler().promote(player, group, PROMOTIONTYPE.BOUGHT);
    						String msg = plugin.messages.getString("BoughtRank").replace("&", "\u00A7");
    						player.sendMessage(msg.replace("<group>", group));
    						plugin.confirm.remove(player);
    						System.out.println("[PLAYER_COMMAND] " + player.getName() + ": /confirm");
    						System.out.println("[PromotionEssentials]Player " + player.getName() + " has bought " + group);
    						return true;
    					}
    					else
    					{
    						String msg = plugin.messages.getString("NoMoney").replace("&", "\u00A7");
    						player.sendMessage(msg.replace("<group>", group));
    						return true;
    					}
    				}
    			}
    		}
    	}
    	else
    	{
    		System.out.println("[PromotionEssentials]You have to be a player to use this command!");
    		return true;
    	}
		return false;
	}

}
