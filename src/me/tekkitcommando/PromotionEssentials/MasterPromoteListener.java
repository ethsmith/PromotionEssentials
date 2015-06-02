
package me.tekkitcommando.PromotionEssentials;

import me.tekkitcommando.PromotionEssentials.Api.PlayerPromoteEvent.PROMOTIONTYPE;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;



public class MasterPromoteListener implements Listener
{
	
	
	public static MasterPromote plugin = MasterPromote.instance;

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onSignChange(SignChangeEvent event)
    {
        Player player = event.getPlayer();
        String Line1 = event.getLine(0);
        String Line2 = event.getLine(1);
        String Line3 = event.getLine(2);
        if(Line1.equals("[Promote]") || Line1.equals(ChatColor.GREEN + "[Promote]"))
        {
            if(player.hasPermission("PromotionEssentials.sign.create") || player.hasPermission("PromotionEssentials.sign.*") || player.hasPermission("PromotionEssentials.*"))
            {
                if(!Line2.equals(""))
                {
                	if(!Line3.equals(""))
                	{
                		try
                		{
                			Double.valueOf(event.getLine(2));
                		}
                		catch(Exception e)
                		{
                			player.sendMessage(ChatColor.RED + "[PromotionEssentials] 3th line has to be an Integer");
                            ItemStack s = new ItemStack(Material.SIGN);
                            s.setAmount(1);
                            event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), s);
                            event.getBlock().setTypeId(0);
                		}
                	}
                    event.setLine(0, (ChatColor.GREEN) + "[Promote]");
                    player.sendMessage(plugin.messages.getString("CreatedSign").replace("&", "\247"));
                }
            } 
            else
            {
                player.sendMessage(plugin.messages.getString("NoPermissions").replace("&", "\247"));
                ItemStack s = new ItemStack(Material.SIGN);
                s.setAmount(1);
                event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), s);
                event.getBlock().setTypeId(0);
            }
        }
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Block clicked = event.getClickedBlock();
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
        {
	        if((clicked.getType().equals(Material.WALL_SIGN) || clicked.getType().equals(Material.SIGN_POST)))
	        {
	            Sign sign = (Sign)event.getClickedBlock().getState();
	            String group = sign.getLine(1);
	            if(sign.getLine(0).equals(ChatColor.GREEN + "[Promote]"))
	                if(player.hasPermission("PromotionEssentials.sign.use." + group) || player.hasPermission("PromotionEssentials.sign.use.all"))
	                {
	                	if(!sign.getLine(2).equals(""))
	                	{
	                		if(plugin.economy.has(player.getName(), Double.valueOf(sign.getLine(2))))
	                		{
	                			plugin.economy.withdrawPlayer(player.getName(), Double.valueOf(sign.getLine(2)));
	                		}
	                		else
	                		{
        						player.sendMessage(plugin.messages.getString("NoMoney").replace("&", "\u00A7"));
        						return;
	                		}
	                	}
	                    plugin.getPermissionsHandler().promote(player, group, PROMOTIONTYPE.SIGN);
	                    String msg = plugin.messages.getString("UsedSign").replace("&", "\247");
	                    player.sendMessage(msg.replace("<group>", group));
	                } 
	                else
	                {
	                    player.sendMessage(plugin.messages.getString("NoPermissions").replace("&", "\247"));
	                }
	        }
	    }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        if(plugin.config.getBoolean("Apply.Enabled"))
        {
            Player player = event.getPlayer();
            String pw = plugin.config.getString("Apply.Password");
            String group = plugin.config.getString("Apply.Group");
            if(!player.hasPermission("PromotionEssentials.member"))
            {
                String msg = plugin.messages.getString("Join").replace("&", "\247");
                msg = msg.replace("<group>", group);
                msg = msg.replace("<password>", pw);
                String[] msgs = msg.split("<newline>");
                for(String s : msgs)
                {
                    player.sendMessage(s);
                }

            }
        }
        
        if(plugin.config.getBoolean("Time.Enabled"))
        {
            Player player = event.getPlayer();
            if(!player.hasPermission("PromotionEssentials.member"))
            {
            	if(!plugin.timepromote.containsKey(player.getName().toLowerCase()))
            	{
            		plugin.timepromote.put(player.getName().toLowerCase(), plugin.config.getLong("Time.Time"));
            	}
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        if(plugin.config.getBoolean("Apply.Enabled"))
        {
            Player player = event.getPlayer();
            if(!player.hasPermission("PromotionEssentials.member") && plugin.config.getBoolean("Apply.Freeze"))
            {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        Player player = event.getPlayer();
        if(plugin.config.getBoolean("Apply.Enabled"))
        {
            String group = plugin.config.getString("Apply.Group");
            if(plugin.config.getBoolean("Apply.Mute") && !player.hasPermission("PromotionEssentials.member"))
            {
                event.setCancelled(true);
                String msg = plugin.messages.getString("Mute").replace("&", "\247");
                String msg1 = msg.replace("<player>", player.getName());
                String msg2 = msg1.replace("<group>", group);
                player.sendMessage(msg2);
            }
        }
        if(plugin.config.getBoolean("Apply.BlockPWinChat"))
        {
        	if(!player.hasPermission("PromotionEssentials.canwritepassword"))
        	{
        		if(event.getMessage().contains(plugin.config.getString("Apply.Password")))
        		{
        			event.setMessage(event.getMessage().replace(plugin.config.getString("Apply.Password"), "*****"));
        		}
        	}
        }
    }
    
    


}
