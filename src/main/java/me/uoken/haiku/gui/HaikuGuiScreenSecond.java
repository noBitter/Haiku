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
        this.buttonList.add(new GuiButton(0,this.width / 2 - 205, this.height / 2 - 46,
                "[" + TextFormatting.AQUA + "Tips" + TextFormatting.WHITE + "]: " + (Haiku.getInstance().isShowTipsChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(1,this.width / 2 - 200, this.height / 2 + 80,20,20,
                "<"));
        this.buttonList.add(new GuiButton(2,this.width / 2 - 205, this.height / 2 - 22,
                TextFormatting.YELLOW + "[ClearLag]" + TextFormatting.WHITE + ": " + (Haiku.getInstance().isShowClearLagChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(3,this.width / 2 + 5, this.height / 2 - 46,
                "Hit: " + (Haiku.getInstance().isShowWinChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(4,this.width / 2 + 5, this.height / 2 - 22,
                "Great Hit: " + (Haiku.getInstance().isShowGreatWinChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(5,this.width / 2 + 5, this.height / 2 + 26,
                "Unlimited Flying: " + (Haiku.getInstance().isShowFlyChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(6,this.width / 2 + 5, this.height / 2 + 2,
                "Player Login: " + (Haiku.getInstance().isShowLoggedInChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(7,this.width / 2 , this.height / 2 - 84, 0, 0,
                "Mute Settings"));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 150, this.height / 2 + 110, 0, 0,
                "Haiku by uoken"));
        this.buttonList.add(new GuiButton(9,this.width / 2 - 205, this.height / 2 + 2,
                "Saving Player Data: " + (Haiku.getInstance().isShowPlayerSaveChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
        this.buttonList.add(new GuiButton(10,this.width / 2 - 205, this.height / 2 + 26,
                "Saving World Data: " + (Haiku.getInstance().isShowWorldSaveChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide ")));
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

                    Haiku.getInstance().getMc().thePlayer.closeScreen();
                    break;
                case 2:
                    Haiku.getInstance().setShowClearLagChat(!Haiku.getInstance().isShowClearLagChat());

                    guiButton.displayString = (
                            TextFormatting.YELLOW + "[ClearLag]" + TextFormatting.WHITE + ": " + (Haiku.getInstance().isShowClearLagChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));
                    break;
                case 3:
                    Haiku.getInstance().setShowWinChat(!Haiku.getInstance().isShowWinChat());

                    guiButton.displayString = ("Hit: " + (Haiku.getInstance().isShowWinChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));
                    break;
                case 4:
                    Haiku.getInstance().setShowGreatWinChat(!Haiku.getInstance().isShowGreatWinChat());

                    guiButton.displayString = ("Big Hit: " + (Haiku.getInstance().isShowGreatWinChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));
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
                    Haiku.getInstance().setShowPlayerSaveChat(!Haiku.getInstance().isShowPlayerSaveChat());

                    guiButton.displayString = ("Saving Player Data: " + (Haiku.getInstance().isShowPlayerSaveChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));
                    break;
                case 10:
                    Haiku.getInstance().setShowWorldSaveChat(!Haiku.getInstance().isShowWorldSaveChat());

                    guiButton.displayString = ("Saving World Data: " + (Haiku.getInstance().isShowWorldSaveChat() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Hide "));
            }
    }

    @Override
    public void onGuiClosed() {
        ConfigUtil.saveConfig();
    }
}
