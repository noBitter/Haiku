package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeSavePlayerData extends MuteBase {
    private boolean enabled = true;

    private Pattern savingPlayerDataPattern = Pattern.compile("プレイヤーデータセーブ中…");
    private Pattern savedPlayerDataPattern = Pattern.compile("プレイヤーデータセーブ完了");

    @Override
    public String getName() {
        return "Save Player Data";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.savingPlayerDataPattern.matcher(message).matches() ||
                this.savedPlayerDataPattern.matcher(message).matches();
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
        return  asLinked("§bプレイヤーデータセーブ中…", "§bプレイヤーデータセーブ完了");
    }
}
