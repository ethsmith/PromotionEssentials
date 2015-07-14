package me.tekkitcommando.PromotionEssentials;

import java.util.Collection;

import me.tekkitcommando.PromotionEssentials.MasterPromotePermissions;
import me.tekkitcommando.PromotionEssentials.Api.PlayerPromoteEvent;
import me.tekkitcommando.PromotionEssentials.Api.PlayerPromoteEvent.PROMOTIONTYPE;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.util.player.UserManager;
import com.gmail.nossr50.api.exceptions.InvalidPlayerException;

public class mcMMO implements Listener {
	
	private MasterPromote plugin = MasterPromote.instance;
	public String activePermissions;
	private Plugin pex = Bukkit.getPluginManager().getPlugin("PermissionsEx");
	private Plugin gm = Bukkit.getPluginManager().getPlugin("GroupManager");
	private Plugin pb = Bukkit.getPluginManager().getPlugin("PermissionsBukkit");
	private Plugin bp = Bukkit.getPluginManager().getPlugin("bPermissions");
	private Plugin pr = Bukkit.getPluginManager().getPlugin("Privileges");
	private Plugin yp = Bukkit.getPluginManager().getPlugin("YAPP");
	private Plugin zp = Bukkit.getPluginManager().getPlugin("zPermissions");
	
	public void loadPermissions()
	{
		if(Bukkit.getPluginManager().isPluginEnabled(pex))
		{
			this.activePermissions = "PermissionsEx";
		}
		else if(Bukkit.getPluginManager().isPluginEnabled(gm))
		{
			this.activePermissions = "GroupManager";
		}
		else if(Bukkit.getPluginManager().isPluginEnabled(pb))
		{
			this.activePermissions = "PermissionsBukkit";
		}
	 	else if(Bukkit.getPluginManager().isPluginEnabled(bp))
		{
			this.activePermissions = "bPermissions";
		}
		else if(Bukkit.getPluginManager().isPluginEnabled(pr))
		{
			this.activePermissions = "Privileges";
		}
		else if(Bukkit.getPluginManager().isPluginEnabled(yp))
		{
			this.activePermissions = "YAPP";
		}
		else if(Bukkit.getPluginManager().isPluginEnabled(zp))
		{
			this.activePermissions = "zPermissions";
		}
		else
		{
			this.activePermissions = "none";
		}
	}
	
	@SuppressWarnings("deprecation")
	public void promote(Player player, String group, PROMOTIONTYPE type)
	{
		PlayerPromoteEvent	event = new PlayerPromoteEvent(player, group, type, activePermissions);
		Bukkit.getPluginManager().callEvent(event);
		if(event.isCanceled())
		{
			sUtil.log("PlayerPromotionEvent has been canceled");
			return;
		}
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		if(!plugin.config.getString("PromoteSyntax").equalsIgnoreCase("none"))
		{
			String command = plugin.config.getString("PromoteSyntax");
			command = command.replace("<player>", player.getName());
			command = command.replace("<group>", group);
			Bukkit.dispatchCommand(console, command);
		}
	}
	
	private static McMMOPlayer getPlayer(Player player) throws InvalidPlayerException {
		if(!UserManager.hasPlayerDataKey(player)) {
			throw new InvalidPlayerException();
		}
		
		return UserManager.getPlayer(player);
	}
	
    public static int getPowerLevel(Player player) {
        return getPlayer(player).getPowerLevel();
    }
    
    public boolean onCommand(CommandSender sender, Command command, String cmd, String args[]) {
    	Player player = (Player) sender;
    	UserManager.getPlayer(player);
    	
    	if(command.getName().equalsIgnoreCase("skillpromote")) {
    		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    		if(getPlayer(player).getPowerLevel() > 9 && getPlayer(player).getPowerLevel() < 20) {
    			if(activePermissions.equals("PermissionsEx")) {
    				Bukkit.dispatchCommand(console, "pex user " + player.getName() + " group set " + "");
    				PermissionUser pexuser = PermissionsEx.getUser(player);
    				for(PermissionGroup g : pexuser.getGroups())
    				{
    					pexuser.removeGroup(g);
    				}
    				pexuser.addGroup("");
    			}
    		}
    	}
    	return false;
    }
}
