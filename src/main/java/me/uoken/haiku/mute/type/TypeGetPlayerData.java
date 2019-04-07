package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeGetPlayerData extends MuteBase {
    private boolean enabled = true;

    private Pattern gettingPlayerPattern = Pattern.compile("プレイヤーデータ取得中。完了まで動かずお待ち下さい…"); // \u00A7e
    private Pattern gotPlayerData = Pattern.compile("プレイヤーデータ取得完了"); // \u00A7a

    @Override
    public String getName() {
        return "Get Player Data";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.gettingPlayerPattern .matcher(message).matches() ||
                this.gotPlayerData.matcher(message).matches();
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
        return asLinked("§eプレイヤーデータ取得中。完了まで動かずお待ち下さい…", "§aプレイヤーデータ取得完了");
    }
}
