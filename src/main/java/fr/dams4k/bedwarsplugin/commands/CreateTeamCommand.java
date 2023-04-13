package fr.dams4k.bedwarsplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.dams4k.bedwarsplugin.Plugin;
import fr.dams4k.bedwarsplugin.bedwars.BedwarsGame;
import fr.dams4k.bedwarsplugin.bedwars.BedwarsTeam;

public class CreateTeamCommand implements CommandExecutor {
    private Plugin plugin;

    public CreateTeamCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            return true;
        }

        String gameName = args[0];
        String teamName = args[1];

        BedwarsGame bedwarsGame = plugin.getBedwarsGame(gameName);
        if (bedwarsGame == null) {
            System.err.println("Game does not exist");
            return true;
        }

        BedwarsTeam team = new BedwarsTeam(teamName);
        bedwarsGame.addTeam(team);

        return true;
    }
    
}
