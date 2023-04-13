package fr.dams4k.bedwarsplugin.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import fr.dams4k.bedwarsplugin.Plugin;

public class BedwarsPlayer {
    private Player player;

    public BedwarsPlayer(Player player) {
        this.player = player;
    }

    public void kill(Location respawnLocation) {
        player.setGameMode(GameMode.SPECTATOR);
        if (respawnLocation == null) {
            permanentKill();
            System.err.println("respawnLocation is null");
            return;
        }

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(Plugin.getInstance(), new Runnable() {
               @Override
               public void run() {
                   System.out.println("+1s");
               }
        }, 20);
    }

    public void permanentKill() {
        player.setGameMode(GameMode.CREATIVE);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPlayer(Player player) {
        return getPlayer().getUniqueId().equals(player.getUniqueId());
    }
}
