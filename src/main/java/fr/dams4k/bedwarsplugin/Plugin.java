package fr.dams4k.bedwarsplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import fr.dams4k.bedwarsplugin.bedwars.BedwarsGame;
import fr.dams4k.bedwarsplugin.commands.CreateTeamCommand;
import fr.dams4k.bedwarsplugin.commands.JoinCommand;
import fr.dams4k.bedwarsplugin.commands.MakeBedwarsCommand;

public class Plugin extends JavaPlugin {
    public List<BedwarsGame> bedwarsGames = new ArrayList<>();
    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("bedwarsjoin").setExecutor(new JoinCommand(this));
        getCommand("bedwarscreate").setExecutor(new CreateTeamCommand(this));
        getCommand("bedwarsmake").setExecutor(new MakeBedwarsCommand(this));
    }

    public BedwarsGame getBedwarsGame(String gameName) {
        for (BedwarsGame bedwarsGame : bedwarsGames) {
            if (bedwarsGame.getName().equals(gameName)) {
                return bedwarsGame;
            }
        }
        return null;
    }

    public static Plugin getInstance() {
        return instance;
    }
}