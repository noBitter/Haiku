package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeClearLag extends MuteBase {
    private Pattern clearLagPattern = Pattern.compile("\\[ClearLag].*");

    private boolean enabled = true;

    @Override
    public String getName() {
        return "ClearLag";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.clearLagPattern.matcher(message).matches();
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
        return asLinked("§4[ClearLag] §cあと §730 §c秒で不要なエンティティを消去します");
    }
}
