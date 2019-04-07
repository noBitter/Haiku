package me.uoken.haiku.gui;

import me.uoken.haiku.Haiku;
import me.uoken.haiku.util.ConfigUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;

public class HaikuGuiScreenSecond extends GuiScreen {
    public void drawScreen(int i, int j, float f){
        drawDefaultBackground();

        super.drawScreen(i, j, f);
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0,this.width / 2 - 205, this.height / 2 - 58,
                "[" + TextFormatting.AQUA + "Tips" + TextFormatting.WHITE + "]: " + (Haiku.getInstance().isShowTipsChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(1,this.width / 2 - 200, this.height / 2 + 80,20,20,
                "<"));
        this.buttonList.add(new GuiButton(2,this.width / 2 - 205, this.height / 2 - 34,
                TextFormatting.GOLD + "[ClearLag]" + TextFormatting.WHITE + ": " + (Haiku.getInstance().isShowClearLagChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(3,this.width / 2 - 205, this.height / 2 + 14,
                "Hit & Great Hit: " + (Haiku.getInstance().isShowCommonHitChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(4,this.width / 2 - 205, this.height / 2 + 38,
                "Gigantic Hit(You): " + (Haiku.getInstance().isShowGiganticHitChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(5,this.width / 2 + 5, this.height / 2 + 38,
                "Unlimited Flying: " + (Haiku.getInstance().isShowFlyChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(6,this.width / 2 + 5, this.height / 2 + 14,
                "Player Login: " + (Haiku.getInstance().isShowLoggedInChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(7,this.width / 2 , this.height / 2 - 84, 0, 0,
                "Mute Settings"));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 170, this.height / 2 + 110, 0, 0,
                TextFormatting.GRAY + "Haiku by uoken"));
        this.buttonList.add(new GuiButton(9,this.width / 2 + 5, this.height / 2 - 58,
                "Gigantic Hit(Other Player): " + (Haiku.getInstance().isShowOtherGiganticHit() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(10,this.width / 2 + 5, this.height / 2 - 34,
                "Save & Backup: " + (Haiku.getInstance().isShowSaveChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(11, this.width / 2 - 205, this.height / 2 - 10,
                "Gacha Count: " + (Haiku.getInstance().isShowGachaCountChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(12, this.width / 2 + 5, this.height / 2 - 10,
                "Buff: " + (Haiku.getInstance().isShowBuffChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(13, this.width / 2 + 190, this.height / 2 - 115, 20, 20,
                "x"));
    }

    public void actionPerformed(GuiButton guiButton){
        if(guiButton.enabled)
            switch (guiButton.id){
                case 0:
                    Haiku.getInstance().setShowTipsChat(!Haiku.getInstance().isShowTipsChat());

                    guiButton.displayString = (
                            "[" + TextFormatting.AQUA + "Tips" + TextFormatting.WHITE + "]: " + (Haiku.getInstance().isShowTipsChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 1:
                    Haiku.getInstance().setShowGui(true);

                    break;
                case 2:
                    Haiku.getInstance().setShowClearLagChat(!Haiku.getInstance().isShowClearLagChat());

                    guiButton.displayString = (
                            TextFormatting.YELLOW + "[ClearLag]" + TextFormatting.WHITE + ": " + (Haiku.getInstance().isShowClearLagChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 3:
                    Haiku.getInstance().setShowCommonHitChat(!Haiku.getInstance().isShowCommonHitChat());

                    guiButton.displayString = ("Hit & Great Hit: " + (Haiku.getInstance().isShowCommonHitChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 4:
                    Haiku.getInstance().setShowGiganticHitChat(!Haiku.getInstance().isShowGiganticHitChat());

                    guiButton.displayString = ("Gigantic Hit(You): " + (Haiku.getInstance().isShowGiganticHitChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 5:
                    Haiku.getInstance().setShowFlyChat(!Haiku.getInstance().isShowFlyChat());

                    guiButton.displayString = ("Unlimited Flying: " + (Haiku.getInstance().isShowFlyChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 6:
                    Haiku.getInstance().setShowLoggedInChat(!Haiku.getInstance().isShowLoggedInChat());

                    guiButton.displayString = ("Player Login: " + (Haiku.getInstance().isShowLoggedInChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 9:
                    Haiku.getInstance().setShowOtherGiganticHit(!Haiku.getInstance().isShowOtherGiganticHit());

                    guiButton.displayString = ("Gigantic Hit (Other Player): " + (Haiku.getInstance().isShowOtherGiganticHit() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 10:
                    Haiku.getInstance().setShowSaveChat(!Haiku.getInstance().isShowSaveChat());

                    guiButton.displayString = ("Save Data: " + (Haiku.getInstance().isShowSaveChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 11:
                    Haiku.getInstance().setShowGachaCountChat(!Haiku.getInstance().isShowGachaCountChat());

                    guiButton.displayString = ("Gacha Count: " + (Haiku.getInstance().isShowGachaCountChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 12:
                    Haiku.getInstance().setShowBuffChat(!Haiku.getInstance().isShowBuffChat());

                    guiButton.displayString = ("Buff: " + (Haiku.getInstance().isShowBuffChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));

                    break;
                case 13:
                    Haiku.getInstance().getMc().thePlayer.closeScreen();
            }
    }

    @Override
    public void onGuiClosed() {
        ConfigUtil.saveConfig();
    }
}
