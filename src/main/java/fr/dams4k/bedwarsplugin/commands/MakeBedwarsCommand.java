package fr.dams4k.bedwarsplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.dams4k.bedwarsplugin.Plugin;
import fr.dams4k.bedwarsplugin.bedwars.BedwarsGame;

public class MakeBedwarsCommand implements CommandExecutor {
    private Plugin plugin;

    public MakeBedwarsCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        World world = null;
        if (args.length == 0 && sender instanceof Player) {
            // Use world where player is on
            world = ((Player) sender).getWorld();
        } else {
            String worldName = args[0];
            world = Bukkit.getWorld(worldName);
        }

        if (world == null) {
            // World does not exist
            return true;
        } 

        String gameName = world.getName();
        if (args.length >= 2) {
            gameName = args[1];
        }

        BedwarsGame bedwarsGame = new BedwarsGame(plugin, world);
        bedwarsGame.setName(gameName);
        plugin.bedwarsGames.add(bedwarsGame);

        return true;
    }
}
