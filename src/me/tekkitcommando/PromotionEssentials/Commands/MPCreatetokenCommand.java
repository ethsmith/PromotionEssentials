package me.tekkitcommando.PromotionEssentials.Commands;

import java.util.Random;

import me.tekkitcommando.PromotionEssentials.MPConfig;
import me.tekkitcommando.PromotionEssentials.MasterPromote;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MPCreatetokenCommand implements CommandExecutor
{

	public MasterPromote plugin = MasterPromote.instance;
	
	public boolean onCommand(CommandSender sender, Command command, String label,	String[] args) 
	{
    	if(sender instanceof Player)
    	{
    		Player player = (Player) sender;
    		if(player.hasPermission("PromotionEssentials.token.create"))
    		{
    			if(args.length == 2)
    			{
    				try
    				{
    					Integer.parseInt(args[1]);
       				 	Random r = new Random();
       				 	String token = Long.toString(Math.abs(r.nextLong()), 36);
       				 	plugin.token.set("token." + token + ".usage", args[1]);
       				 	plugin.token.set("token." + token + ".group", args[0]);
       				 	MPConfig.saveYamls();
       				 	String msg = plugin.messages.getString("CreateToken").replace("<token>", token);
       				 	String msg2 = msg.replace("<group>", args[0]);
       				 	player.sendMessage(msg2.replace("&", "\u00A7"));
						System.out.println("[PLAYER_COMMAND] " + player.getName() + ": /createtoken");
       				 	return true;
    				}
    					catch(NumberFormatException nFE) { 
    						player.sendMessage(ChatColor.RED + "Usage has to be a number!");
    						return true;
    					}

    			}
    		}
    		else
    		{
    			player.sendMessage(plugin.messages.getString("NoPermissions").replace("&", "\u00A7"));
    			System.out.println("[PromotionEssentials]Player " + player.getName() + " tried to use /createtoken");
    			return true;
    		}
    	}
    	else
    	{
			if(args.length == 2)
			{
				try
				{
					Integer.parseInt(args[1]);
   				 	Random r = new Random();
   				 	String token = Long.toString(Math.abs(r.nextLong()), 36);
   				 	plugin.token.set("token." + token + ".usage", args[1]);
   				 	plugin.token.set("token." + token + ".group", args[0]);
   					MPConfig.saveYamls();
   				 	System.out.println("[PromotionEssentials]Created token " + token + " for group " + args[0]);
   				 	return true;
				}
					catch(NumberFormatException nFE) { 
						System.out.println("Usage has to be a number!");
						return true;
					}

			}
    	}
    	return false;
	}

}
