package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeUnlimitedFly extends MuteBase {
    private boolean enabled = true;
    private boolean showFollowed = true;

    private Pattern unlimitedFlyingPattern = Pattern.compile("Fly効果は無期限で継続中です");
    private Pattern unlimitedFlyingAfkPattern = Pattern.compile("放置時間中のFLYは無期限で継続中です\\(経験値は消費しません\\)");
    private Pattern[] followedPattern = {};

    @Override
    public String getName() {
        return "Unlimited Fly";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        return this.unlimitedFlyingPattern.matcher(message).matches() || this.unlimitedFlyingAfkPattern.matcher(message).matches();
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
        return  asLinked("§aFly効果は無期限で継続中です",
                "§7放置時間中のFLYは無期限で継続中です(経験値は消費しません)", "");
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
