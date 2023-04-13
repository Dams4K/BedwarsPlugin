package fr.dams4k.bedwarsplugin.bedwars;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class BedwarsTeam {
    private List<BedwarsPlayer> bedwarsPlayers = new ArrayList<>();

    private String name;
    private boolean bedRemaining = true;

    private Location respawnLocation = null;

    public BedwarsTeam(String name) {
        this.name = name;
    }

    public void destroyBed() {
        this.bedRemaining = false;
    }

    public boolean isBedRemaining() {
        return bedRemaining;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(BedwarsPlayer player) {
        bedwarsPlayers.add(player);
    }
    public BedwarsPlayer popPlayer(Player player) {
        for (BedwarsPlayer bedwarsPlayer : bedwarsPlayers) {
            if (bedwarsPlayer.isPlayer(player)) {
                return bedwarsPlayer;
            }
        }
        return null;
    }

    public boolean killPlayer(Player player) {
        for (BedwarsPlayer bedwarsPlayer : bedwarsPlayers) {
            if (bedwarsPlayer.isPlayer(player)) {
                if (isBedRemaining()) {
                    bedwarsPlayer.kill(respawnLocation);
                } else {
                    bedwarsPlayer.permanentKill();
                }
                return true;
            }
        }
        return false;
    }
}
