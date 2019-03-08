package me.uoken.haiku.gui;

import me.uoken.haiku.Haiku;
import me.uoken.haiku.util.ConfigUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;

public class HaikuGuiScreen extends GuiScreen {
    public void drawScreen(int i, int j, float f){
        drawDefaultBackground();

        super.drawScreen(i, j, f);
    }

    public void initGui() {
        this.buttonList.add(new GuiButton(0, this.width / 2 + 5, this.height / 2 - 34,
                "Buff Counter: " + (Haiku.getInstance().isShowBuffCounter() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height / 2 - 10,
                "Ranking Counter: " + (Haiku.getInstance().isShowRankingCounter() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 5, this.height / 2 + 14,
                "Gigantic Counter: " + (Haiku.getInstance().isShowGiganticCounter() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 100, this.height / 2 - 84, 0, 0,
                "Chat Settings"));

        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 2 - 84, 0, 0,
                "Gigantic List"));

        this.buttonList.add(new GuiButton(5, this.width / 2 - 140, this.height / 2 - 48, 0, 0,
                "Apollo: " + Haiku.getInstance().getHitApollo()));
        this.buttonList.add(new GuiButton(6, this.width / 2 - 140, this.height / 2 - 24, 0, 0,
                "Icarus: " + Haiku.getInstance().getHitIcarus()));
        this.buttonList.add(new GuiButton(7, this.width / 2 - 140, this.height / 2, 0, 0,
                "Nemesis: " + Haiku.getInstance().getHitNemesis()));
        this.buttonList.add(new GuiButton(8, this.width / 2 - 140, this.height / 2 + 24, 0, 0,
                "Hercules: " + Haiku.getInstance().getHitHercules()));
        this.buttonList.add(new GuiButton(9, this.width / 2 - 140, this.height / 2 + 48, 0, 0,
                "Arthur: " + Haiku.getInstance().getHitArthur()));

        this.buttonList.add(new GuiButton(10, this.width / 2 - 60, this.height / 2 - 48, 0, 0,
                "Thanatos: " + Haiku.getInstance().getHitThanatos()));
        this.buttonList.add(new GuiButton(11, this.width / 2 - 60, this.height / 2 - 24, 0, 0,
                "Gaea: " + Haiku.getInstance().getHitGaea()));
        this.buttonList.add(new GuiButton(12, this.width / 2 - 60, this.height / 2, 0, 0,
                "Pluto: " + Haiku.getInstance().getHitPluto()));
        this.buttonList.add(new GuiButton(13, this.width / 2 - 60, this.height / 2 + 24, 0, 0,
                "Titan: " + Haiku.getInstance().getHitTitan()));
        this.buttonList.add(new GuiButton(14, this.width / 2 - 60, this.height / 2 + 48, 0, 0,
                "Artemis: " + Haiku.getInstance().getHitArtemis()));

        this.buttonList.add(new GuiButton(15, this.width / 2 + 150, this.height / 2 + 110, 0, 0,
                "Haiku by uoken"));

        this.buttonList.add(new GuiButton(16, this.width / 2 + 180, this.height / 2 + 80, 20, 20, ">"));
    }

    protected void actionPerformed(GuiButton guiButton){
        if(guiButton.enabled){
            switch (guiButton.id){
                case 0:
                    Haiku.getInstance().setShowBuffCounter(!Haiku.getInstance().isShowBuffCounter());

                    guiButton.displayString = ("Buff Counter: " + (Haiku.getInstance().isShowBuffCounter() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 1:
                    Haiku.getInstance().setShowRankingCounter(!Haiku.getInstance().isShowRankingCounter());

                    guiButton.displayString = ("Ranking Counter: " + (Haiku.getInstance().isShowRankingCounter() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 2:
                    Haiku.getInstance().setShowGiganticCounter(!Haiku.getInstance().isShowGiganticCounter());

                    guiButton.displayString = ("Gigantic Counter: " + (Haiku.getInstance().isShowGiganticCounter() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));
                    break;
                case 16:
                    Haiku.getInstance().setShowGuiSecond(true);

                    Haiku.getInstance().getMc().thePlayer.closeScreen();
            }
        }
    }

    public void onGuiClosed(){
        ConfigUtil.saveConfig();
    }
}
