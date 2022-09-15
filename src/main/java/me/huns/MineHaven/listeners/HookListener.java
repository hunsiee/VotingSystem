package me.huns.MineHaven.listeners;

import me.huns.MineHaven.Hook;
import me.huns.MineHaven.managers.PlayerVoteEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HookListener extends BukkitRunnable {
    public void run() {
        for (Player online : Bukkit.getServer().getOnlinePlayers()) {
            if (Hook.getInstance().getApi().voted(online) && !Hook.getInstance().getKnownVoters().contains(online.getUniqueId().toString())) {
                PlayerVoteEvent playerVoteEvent = new PlayerVoteEvent(online);
                Bukkit.getServer().getPluginManager().callEvent(playerVoteEvent);
            }
        }
    }
}