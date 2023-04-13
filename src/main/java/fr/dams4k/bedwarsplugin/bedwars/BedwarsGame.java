package fr.dams4k.bedwarsplugin.bedwars;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.dams4k.bedwarsplugin.Plugin;

public class BedwarsGame implements Listener {
    private Plugin plugin;

    private String name;
    private World world;
    private List<BedwarsTeam> teams = new ArrayList<>();

    public BedwarsGame(Plugin plugin, World world) {
        this.plugin = plugin;
        this.world = world;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (!event.getEntityType().equals(EntityType.PLAYER)) {
            return;   
        }
        
        Player player = (Player) event.getEntity();
        boolean succeed = false;
        for (BedwarsTeam team : teams) {
            succeed = team.killPlayer(player) || succeed; // If succeed one time, succeed all the time
        }
        event.setCancelled(succeed);
    }

    public World getWorld() {
        return world;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public BedwarsTeam getTeam(String name) {
        for (BedwarsTeam team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }

        return null;
    }
    public void addTeam(BedwarsTeam team) {
        this.teams.add(team);
    }
}
