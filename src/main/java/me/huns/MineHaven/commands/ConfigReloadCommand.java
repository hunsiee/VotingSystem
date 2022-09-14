package me.huns.MineHaven.commands;

import me.huns.MineHaven.Hook;
import me.huns.MineHaven.managers.CC;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ConfigReloadCommand implements CommandExecutor {
    Plugin plugin = Bukkit.getPluginManager().getPlugin("HHub");
    Server s = Bukkit.getServer();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            if (p.hasPermission("votingsystem.reload")) {
                plugin.reloadConfig();
                p.sendMessage(CC.translate("&c&lConfig reloaded!"));
            } else {
                p.sendMessage(CC.translate("&c" + Hook.getInstance().getConfig().getString("no-permission")));
            }
        } else {
            s.getConsoleSender().sendMessage("Config reloaded!");
        }


        return true;
    }
}