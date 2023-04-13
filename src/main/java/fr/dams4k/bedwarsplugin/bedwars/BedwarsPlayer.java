package fr.dams4k.bedwarsplugin.bedwars;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
