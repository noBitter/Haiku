package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeCommonWin extends MuteBase {
    private boolean enabled = true;
    private boolean showFollowed = true;

    private Pattern commonWinPattern = Pattern.compile("おめでとう！当たり！.*");
    private Pattern[] followedPattern = {};

    @Override
    public String getName() {
        return "Common Win";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.commonWinPattern.matcher(message).matches();
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
        return asLinked("§eおめでとう！当たり！", "", "");
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
