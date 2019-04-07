package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeGachaCounter extends MuteBase {
    private boolean enabled = true;

    private Pattern gachaCounterPattern = Pattern.compile("\\d{1,2}回ガチャを回しました。");

    @Override
    public String getName() {
        return "Gacha Counter";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.gachaCounterPattern.matcher(message).matches();
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
        return asLinked("§b64回ガチャを回しました。");
    }
}
