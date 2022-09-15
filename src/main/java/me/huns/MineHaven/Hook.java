package me.huns.MineHaven;

import me.huns.MineHaven.commands.CheckVoteCommand;
import me.huns.MineHaven.commands.ConfigReloadCommand;
import me.huns.MineHaven.commands.VoteCommand;
import me.huns.MineHaven.listeners.HookHandler;
import me.huns.MineHaven.listeners.HookListener;
import me.huns.MineHaven.managers.API;
import me.huns.MineHaven.managers.Messages;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public final class Hook extends JavaPlugin {

    private static Hook instance;
    private API api;
    private List<String> commands;
    private List<String> knownVoters;

    @Override
    public void onEnable() {
        createConfig();
        createInstances();
        loadData();
        loadData();
        registerCommands();
        registerHooks();
    }

    @Override
    public void onDisable() {
        saveData();
    }

    private void createInstances() {
        instance = this;
        api = new API();
    }

    private void createConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void loadData() {
        commands = getConfig().getStringList("perform-commands");
        knownVoters = getConfig().getStringList("known-voters");
        new Messages();
    }

    private void registerCommands() {
        this.getCommand("hcheckvote").setExecutor(new CheckVoteCommand());
        this.getCommand("hvote").setExecutor(new VoteCommand());
        this.getCommand("hreloadconfig").setExecutor(new ConfigReloadCommand());
    }

    private void registerHooks() {
        getServer().getPluginManager().registerEvents(new HookHandler(), this);
        new HookListener().runTaskTimer(this, 0L, 60L);
    }
    private void saveData() {
        getConfig().set("known-voters", knownVoters);
        saveConfig();
    }

    public static Hook getInstance() {
        return instance;
    }

    public API getApi() {
        return api;
    }

    public List<String> getCommands() {
        return commands;
    }

    public List<String> getKnownVoters() {
        return knownVoters;
    }
}
