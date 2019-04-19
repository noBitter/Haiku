package me.uoken.haiku.mute.type;

import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeJoiningChannel extends MuteBase {
    private boolean enabled = true;
    private boolean showFollowed = true;

    private Pattern buffPattern = Pattern.compile("----- 参加中のチャット -----");
    private Pattern[] followedPattern = {Pattern.compile("\\| (?<channel>\\S{1,16})\\(\\d\\/\\d\\)"),
                                        Pattern.compile("----------------------------------")};

    @Override
    public String getName(){
        return "Joining Chat";
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
        return asLinked("----- 参加中のチャット -----", // gray, aqua, gray
                                "| Channel(3/4)", // gray, white, gray, red, gray, red, gray
                                "----------------------------------"); // gray
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
