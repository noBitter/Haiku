package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeSaveWorld extends MuteBase {
    private boolean enabled = true;
    private boolean showFollowed = true;

    private Pattern savingWorldPattern = Pattern.compile("ワールドセーブ中\\.\\.\\.\\.");
    private Pattern savedWorldPattern = Pattern.compile("ワールドセーブ完了");
    private Pattern[] followedPattern = {};

    @Override
    public String getName() {
        return "Save World";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.savingWorldPattern.matcher(message).matches() || this.savedWorldPattern.matcher(message).matches();
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
        return  asLinked("§9ワールドセーブ中....",
                "§9ワールドセーブ完了", "");
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
