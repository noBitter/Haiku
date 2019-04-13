package me.uoken.haiku.mute;

import me.uoken.haiku.mute.type.*;

import java.util.*;
import java.util.regex.Pattern;

public abstract class MuteBase {
    private static final LinkedHashMap<String, MuteBase> muteMaps = new LinkedHashMap<>();

    public MuteBase(){ }

    public static void addMute(MuteBase muteBase){
        if(muteBase != null && muteBase.getName() != null){
            muteMaps.put(muteBase.getIdString(), muteBase);
        }
    }

    public static void remake(){
        muteMaps.clear();
        addMute(new TypeGachaCounter());
        addMute(new TypeCommonWin());
        addMute(new TypeGreatWin());
        addMute(new TypeGiganticWinYours());
        addMute(new TypeGiganticWinOthers());
        addMute(new TypeBuff());
        addMute(new TypeTips());
        addMute(new TypeClearLag());
        addMute(new TypeLogin());
        addMute(new TypeUnlimitedFly());
        addMute(new TypeGetPlayerData());
        addMute(new TypeSavePlayerData());
        addMute(new TypeSaveWorld());
        addMute(new TypeBackup());
    }

    public abstract boolean isEnabled();

    public abstract void setEnabled(boolean enabled);

    public abstract String getName();

    // In the case of the type wanna mute multiple lines, set showFollowed to reverse of matches the last pattern in the below method.
    public abstract boolean shouldMute(final String message, final String name);

    public final String getIdString(){
        return getName().toLowerCase().replace(" ",  "_");
    }

    public static LinkedHashMap<String, MuteBase> getMuteMaps(){
        LinkedHashMap<String, MuteBase> newInput = new LinkedHashMap<>();
        muteMaps.forEach(newInput::put);
        return newInput;
    }

    public String getDisplayName() {
        return getName() + ": ";
    }

    public abstract LinkedList<String> getDescription();

    public final boolean hasDescription() {
        return getDescription() != null && !getDescription().isEmpty();
    }

    @SafeVarargs
    public final <T> LinkedList<T> asLinked(T... entry){
        LinkedList<T> list = new LinkedList<>();
        list.addAll(Arrays.asList(entry));
        return list;
    }

    public abstract void checkFollowed(String message);

    public boolean checkFollowedManager(Pattern[] patterns, String message){
        for(Pattern pattern : patterns){
            if(pattern.matcher(message).matches()){
                return (pattern == patterns[patterns.length - 1]);
            }
        }

        return true;
    }

    public abstract boolean isShowFollowed();
}
