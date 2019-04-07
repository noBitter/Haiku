package me.uoken.haiku.mute.type;

import me.uoken.haiku.Haiku;
import me.uoken.haiku.HaikuEvents;
import me.uoken.haiku.mute.MuteBase;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class TypeGiganticWinOthers extends MuteBase {
    private Haiku mod = Haiku.getInstance();
    private HaikuEvents haikuEvents = Haiku.getInstance().getHaikuEvents();

    private boolean enabled = true;

    //private Pattern giganticWinGtPattern = Pattern.compile("(?<gt>[A-Z]{4,8})を引きました！おめでとうございます！");
    private Pattern giganticWinOthersPattern = Pattern.compile("(?<tag>\\[.+])(?<player>\\S{1,16})がガチャでGigantic☆大当たり！");

    @Override
    public String getName() {
        return "Gigantic Win Others";
    }

    @Override
    public boolean shouldMute(String message, String name) {
        Pattern giganticWinYourPattern = Pattern.compile("(?<tag>\\[.+])(?i)" + name + "がガチャでGigantic☆大当たり！");

        boolean isOthers = this.giganticWinOthersPattern.matcher(message).matches() && !giganticWinYourPattern.matcher(message).matches();

        haikuEvents.setShowNextLine(haikuEvents.isShowNextLine() &&
                !isOthers);

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
                "§b§9§l§oN§b§l§oE§a§l§oM§d§l§oE§c§l§oS§6§l§oI§e§l§oS§6を引きました！おめでとうございます！");
    }
}
