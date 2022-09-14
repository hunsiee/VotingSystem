package me.huns.MineHaven.managers;

import me.huns.MineHaven.Hook;

public class Messages {
    private final Hook hook = Hook.getInstance();

    public static String NO_PERMISSION;
    public static String PLAYER_VOTED;
    public static String PLAYER_DIDNT_VOTE;
    public static String YOU_VOTED;
    public static String VOTE_MESSAGE;
    public static String VOTE_BROADCAST;

    public Messages() {
        NO_PERMISSION = CC.translate("&") + hook.getConfig().getString("messages.no-permission");
        PLAYER_VOTED = CC.translate('&' + hook.getConfig().getString("messages.player-voted"));
        PLAYER_DIDNT_VOTE = CC.translate('&' + hook.getConfig().getString("messages.player-didnt-vote"));
        YOU_VOTED = CC.translate('&' + hook.getConfig().getString("messages.you-voted"));
        VOTE_MESSAGE = CC.translate('&' + hook.getConfig().getString("messages.vote-message"));
        VOTE_BROADCAST = CC.translate('&' +  hook.getConfig().getString("messages.player-voted-broadcast"));
    }
}
