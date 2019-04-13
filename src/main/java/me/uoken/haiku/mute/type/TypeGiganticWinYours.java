package me.uoken.haiku.mute.type;

import me.uoken.haiku.Haiku;
import me.uoken.haiku.HaikuEvents;
import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeGiganticWinYours extends MuteBase {
    private boolean enabled = true;
    private static boolean showFollowed = true;

    private Pattern giganticWinPattern = Pattern.compile("おめでとう！！！！！Gigantic☆大当たり！");
    private Pattern[] followedPattern = {Pattern.compile("(?<gt>[A-Z]{4,8})を引きました！おめでとうございます！")};

    @Override
    public String getName() {
        return "Gigantic Win Yours";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        Pattern giganticWinYourPattern = Pattern.compile("(?<tag>\\[.+])(?i)" + name + "がガチャでGigantic☆大当たり！");

        TypeGiganticWinYours.showFollowed = !giganticWinYourPattern.matcher(message).matches();

        return this.giganticWinPattern.matcher(message).matches() || giganticWinYourPattern.matcher(message).matches();
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
        return  asLinked("§cおめでとう！！！！！Gigantic☆大当たり！",
                "§6[ Lv100 ]You§fがガチャでGigantic☆大当たり！",
                "§b§9§l§oN§b§l§oE§a§l§oM§d§l§oE§c§l§oS§6§l§oI§e§l§oS§6を引きました！おめでとうございます！");
    }

    @Override
    public void checkFollowed(String message) {
        TypeGiganticWinYours.showFollowed = checkFollowedManager(followedPattern, message);
    }

    @Override
    public boolean isShowFollowed() {
        return TypeGiganticWinYours.showFollowed;
    }
}
