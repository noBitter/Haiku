package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeGreatWin extends MuteBase {
    private boolean enabled = true;

    private Pattern greatWinPattern1 = Pattern.compile("おめでとう‼大当たり！.*");
    private Pattern greatWinPattern2 = Pattern.compile("おめでとう！！大当たり！.*");

    @Override
    public String getName() {
        return "Great Win";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.greatWinPattern1.matcher(message).matches() ||
                this.greatWinPattern2.matcher(message).matches();
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
        return asLinked("§6おめでとう‼大当たり！");
    }
}
