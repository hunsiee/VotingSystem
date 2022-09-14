package me.huns.MineHaven.listeners;

import me.huns.MineHaven.managers.HookAPI;
import me.huns.MineHaven.managers.Messages;
import me.huns.MineHaven.managers.PlayerVoteEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HookHandler implements Listener {
    @EventHandler
    public void onVote(PlayerVoteEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(Messages.YOU_VOTED);
        Bukkit.broadcastMessage(Messages.VOTE_BROADCAST.replace("%player%", player.getName()));
        for (String commands : HookAPI.getCommands()) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commands.replace("%player%", player.getName()));
        }
    }
}
