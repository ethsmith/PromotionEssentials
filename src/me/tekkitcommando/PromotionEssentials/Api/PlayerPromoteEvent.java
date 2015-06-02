package me.tekkitcommando.PromotionEssentials.Api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class PlayerPromoteEvent extends Event
{
	
	public static final HandlerList handlers = new HandlerList();
	private PROMOTIONTYPE type;
	private Player player;
	private String group;
	private String ps;
	private Boolean canceled;
	
	
	
	public PlayerPromoteEvent(Player player,String group ,PROMOTIONTYPE type, String PermissionsSystem)
	{
		this.type = type;
		this.player = player;
		this.group = group;
		this.ps = PermissionsSystem;
		this.canceled = false;
	}

    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
	
	public String getGroup()
	{
		return group;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public PROMOTIONTYPE getType()
	{
		return type;
	}
	
	public String getPermissionsSystem()
	{
		return ps;
	}
	
	
	public Boolean isCanceled()
	{
		return canceled;
	}
	
	
	public void setCanceled(Boolean cancel)
	{
		this.canceled = cancel;
	}
	
	
	public static enum PROMOTIONTYPE
	{
		APPLY,
		
		TIME,
		
		TOKEN,
		
		SIGN,
		
		BOUGHT,
		
		OTHER,
		
		KILLS,
		
		DEATHS;
	}

}
