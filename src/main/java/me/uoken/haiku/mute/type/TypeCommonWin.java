package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeCommonWin extends MuteBase {
    private boolean enabled = true;

    private Pattern commonWinPattern = Pattern.compile("おめでとう！当たり！.*");

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
        return asLinked("§eおめでとう！当たり！");
    }
}
