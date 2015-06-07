package me.tekkitcommando.PromotionEssentials;

import me.tekkitcommando.PromotionEssentials.MasterPromote;

import org.bukkit.entity.Animals;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MasterPromoteKillListener implements Listener {
	
	public static MasterPromote plugin = MasterPromote.instance;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!addPlayer(p)) setName(p);
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Entity ent = e.getEntity();
		if (ent instanceof Player) {
			Player p = (Player) ent;
			if (p.getKiller() != null) {
				Player k = p.getKiller();
				addKills(k, 1);
				for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
					if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
						int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
						MasterPromote.perms.playerAddGroup(k, s);
						if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage( plugin.messages.getString("congratulations").replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
					}
				}
			}
		}
	}
	
	public boolean isEntityEnabled(String e) {
		return plugin.getConfig().getBoolean("entities." + e);
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		Entity ent = e.getEntity();
		if (ent instanceof Zombie) {
			Zombie entity = (Zombie) ent;
			if (isEntityEnabled("zombies")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.messages.getString("congratulations").replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Skeleton) {
			Skeleton entity = (Skeleton) ent;
			if (isEntityEnabled("skeletons")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Creeper) {
			Creeper entity = (Creeper) ent;
			if (isEntityEnabled("creepers")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Spider) {
			Spider entity = (Spider) ent;
			if (isEntityEnabled("spiders")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof CaveSpider) {
			CaveSpider entity = (CaveSpider) ent;
			if (isEntityEnabled("cave-spiders")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof IronGolem) {
			IronGolem entity = (IronGolem) ent;
			if (isEntityEnabled("iron-golems")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Bat) {
			Bat entity = (Bat) ent;
			if (isEntityEnabled("bats")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Silverfish) {
			Silverfish entity = (Silverfish) ent;
			if (isEntityEnabled("silverfish")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Slime) {
			Slime entity = (Slime) ent;
			if (isEntityEnabled("slimes")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Witch) {
			Witch entity = (Witch) ent;
			if (isEntityEnabled("witches")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof PigZombie) {
			PigZombie entity = (PigZombie) ent;
			if (isEntityEnabled("pig-zombies")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Blaze) {
			Blaze entity = (Blaze) ent;
			if (isEntityEnabled("blazes")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Ghast) {
			Ghast entity = (Ghast) ent;
			if (isEntityEnabled("ghasts")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							KillRankup.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof MagmaCube) {
			MagmaCube entity = (MagmaCube) ent;
			if (isEntityEnabled("magma-cubes")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Wither) {
			Wither entity = (Wither) ent;
			if (isEntityEnabled("withers")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Giant) {
			Giant entity = (Giant) ent;
			if (isEntityEnabled("giant-zombies")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof EnderDragon) {
			EnderDragon entity = (EnderDragon) ent;
			if (isEntityEnabled("enderdragons")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		} else if (ent instanceof Animals) {
			Animals entity = (Animals) e.getEntity();
			if (isEntityEnabled("animals")) {
				if (entity.getKiller() != null) {
					Player k = entity.getKiller();
					addKills(k, 1);
					for (String s : plugin.getConfig().getConfigurationSection("ranks").getKeys(false)) {
						if (plugin.getConfig().getInt("ranks." + s + ".kills") == getKills(k)) {
							int kills = plugin.getConfig().getInt("ranks." + s + ".kills");
							MasterPromote.perms.playerAddGroup(k, s);
							if (plugin.getConfig().getBoolean("ranks." + s + ".message")) k.sendMessage(plugin.getPrefix() + plugin.getMessage().replace("%kills%", Integer.toString(kills)).replace("%rank%", s));
						}
					}
				}
			}
		}
	}
	
	public boolean addPlayer(Player p) {
		if (!plugin.getConfig().getConfigurationSection("players").contains(p.getUniqueId().toString())) {
			plugin.getConfig().set("players." + p.getUniqueId().toString() + ".name", p.getName());
			plugin.getConfig().set("players." + p.getUniqueId().toString() + ".kills", 0);
			plugin.saveConfig();
			return true;
		}
		return false;
	}
	
	public int getKills(Player p) {
		if (plugin.getConfig().getConfigurationSection("players").contains(p.getUniqueId().toString()))
			return plugin.getConfig().getInt("players." + p.getUniqueId().toString() + ".kills");
		return 0;
	}
	
	public void setName(Player p) {
		if (plugin.getConfig().getConfigurationSection("players").contains(p.getUniqueId().toString())) {
			plugin.getConfig().set("players." + p.getUniqueId().toString() + ".name", p.getName());
			plugin.saveConfig();
		}
	}
	
	public void addKills(Player p, int amount) {
		if (plugin.getConfig().getConfigurationSection("players").contains(p.getUniqueId().toString())) {
			plugin.getConfig().set("players." + p.getUniqueId().toString() + ".kills", getKills(p) + amount);
			plugin.saveConfig();
		}
	}

}
