package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeGetPlayerData extends MuteBase {
    private boolean enabled = true;
    private boolean showFollowed = true;

    private Pattern gettingPlayerPattern = Pattern.compile("プレイヤーデータ取得中。完了まで動かずお待ち下さい…");
    private Pattern gotPlayerData = Pattern.compile("プレイヤーデータ取得完了");
    private Pattern[] followedPattern = {};

    @Override
    public String getName() {
        return "Get Player Data";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.gettingPlayerPattern .matcher(message).matches() || this.gotPlayerData.matcher(message).matches();
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public LinkedList<String> getDescription() {
        return asLinked("§eプレイヤーデータ取得中。完了まで動かずお待ち下さい…",
                "§eしばらくお待ちください…",
                "§aプレイヤーデータ取得完了");
    }

    @Override
    public void checkFollowed(String message) {
        this.showFollowed = checkFollowedManager(followedPattern, message);
    }

    @Override
    public boolean isShowFollowed() {
        return this.showFollowed;
    }
}
