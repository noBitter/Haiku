package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeBackup extends MuteBase {
    private boolean enabled = true;

    private Pattern backingupPattern = Pattern.compile("バックアップ中\\.\\.\\.\\.");
    private Pattern backedupPattern = Pattern.compile("バックアップ完了");

    @Override
    public String getName() {
        return "Backup";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.backingupPattern.matcher(message).matches() ||
                this.backedupPattern.matcher(message).matches();
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
        return asLinked("§bバックアップ中....", "§bバックアップ完了");
    }
}
