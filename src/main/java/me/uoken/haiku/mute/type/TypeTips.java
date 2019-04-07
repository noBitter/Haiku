package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeTips extends MuteBase {
    private boolean enabled = true;

    private Pattern tipsPattern = Pattern.compile("\\[Tips].*");

    @Override
    public String getName() {
        return "Tips";
    }

    @Override
    public boolean shouldMute(String message, String name) {
            return this.tipsPattern.matcher(message).matches();
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
        return asLinked("§6[Tips]§f接続時間はメイン・整地専用・公共施設サーバにいると増えます。");
    }
}
