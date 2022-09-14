package me.huns.MineHaven.commands;

import me.huns.MineHaven.managers.CC;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import me.huns.MineHaven.managers.Messages;

public class VoteCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd , String commandLabel, String[] args) {
        if (!sender.hasPermission("hook.command.vote")) {
            sender.sendMessage(Messages.NO_PERMISSION);
            return true;
        }
        sender.sendMessage(CC.translate("&chttps://namemc.com/server/minemortal.org"));
        return true;
    }
}