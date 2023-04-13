package fr.dams4k.bedwarsplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.dams4k.bedwarsplugin.Plugin;
import fr.dams4k.bedwarsplugin.bedwars.BedwarsGame;
import fr.dams4k.bedwarsplugin.bedwars.BedwarsPlayer;
import fr.dams4k.bedwarsplugin.bedwars.BedwarsTeam;

public class JoinCommand implements CommandExecutor {
    private Plugin plugin;

    public JoinCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 3) {
            return true;
        }

        String gameName = args[0];
        String teamName = args[1];
        String playerName = args[2];

        BedwarsGame bedwarsGame = plugin.getBedwarsGame(gameName);
        if (bedwarsGame == null) {
            System.err.println("Game does not exist");
            return true;
        }

        BedwarsTeam team = bedwarsGame.getTeam(teamName);
        if (team == null) {
            System.err.println("Team does not exist");
            return true;
        }

        Player player = Bukkit.getPlayer(playerName);
        if (player == null) {
            System.err.println("Player does not exist");
            return true;
        }
        BedwarsPlayer bedwarsPlayer = new BedwarsPlayer(player);
        team.addPlayer(bedwarsPlayer);

        return true;
    }
}
