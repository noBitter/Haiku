package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeBuff extends MuteBase {
    private boolean enabled = true;
    private boolean showFollowed = true;

    private Pattern buffPattern = Pattern.compile("★採掘速度上昇レベルが.*");
    private Pattern[] followedPattern = {};

    @Override
    public String getName(){
        return "Buff";
    }

    @Override
    public boolean shouldMute(String message, String name){
        return this.buffPattern.matcher(message).matches();
    }

    @Override
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public LinkedList<String> getDescription() {
        return asLinked("§e★§f採掘速度上昇レベルが§e256§fになりました", "", "");
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
