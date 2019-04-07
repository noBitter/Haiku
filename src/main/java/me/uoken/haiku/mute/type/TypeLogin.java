package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeLogin extends MuteBase {
    private boolean enabled = true;

    private Pattern loginPattern = Pattern.compile("(?<player>\\S{1,16}) がログインしました");

    @Override
    public String getName() {
        return "Login";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.loginPattern.matcher(message).matches();
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
        return asLinked("§7unchama がログインしました");
    }
}
