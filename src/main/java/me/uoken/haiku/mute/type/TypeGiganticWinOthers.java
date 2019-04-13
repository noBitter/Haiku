package me.uoken.haiku.mute.type;

import me.uoken.haiku.Haiku;
import me.uoken.haiku.HaikuEvents;
import me.uoken.haiku.mute.MuteBase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class TypeGiganticWinOthers extends MuteBase {
    private boolean enabled = true;
    private static boolean showFollowed = true;

    private Pattern giganticWinOthersPattern = Pattern.compile("(?<tag>\\[.+])(?<player>\\S{1,16})がガチャでGigantic☆大当たり！");
    private Pattern[] followedPattern = {Pattern.compile("(?<gt>[A-Z]{4,8})を引きました！おめでとうございます！")};

    @Override
    public String getName() {
        return "Gigantic Win Others";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        Pattern giganticWinYourPattern = Pattern.compile("(?<tag>\\[.+])(?i)" + name + "がガチャでGigantic☆大当たり！");
        boolean isOthers = this.giganticWinOthersPattern.matcher(message).matches() && !giganticWinYourPattern.matcher(message).matches();

        TypeGiganticWinOthers.showFollowed = !isOthers;

        return isOthers;
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
        return asLinked("§6[ Lv100 ]unchama§fがガチャでGigantic☆大当たり！",
                "§b§9§l§oN§b§l§oE§a§l§oM§d§l§oE§c§l§oS§6§l§oI§e§l§oS§6を引きました！おめでとうございます！", "");
    }

    @Override
    public void checkFollowed(String message){
        TypeGiganticWinOthers.showFollowed = checkFollowedManager(followedPattern, message);
    }

    @Override
    public boolean isShowFollowed() {
        return TypeGiganticWinOthers.showFollowed;
    }
}
