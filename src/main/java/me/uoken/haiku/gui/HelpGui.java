package me.uoken.haiku.gui;

import me.uoken.haiku.mute.MuteBase;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;

import java.awt.*;

public class HelpGui extends GuiScreen {
    private int pageNumber;
    private int pages;

    public HelpGui(int pageNumber){
        this.pageNumber = pageNumber;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);

        drawCenteredString(this.fontRenderer, "Help", this.width / 2, this.height / 2 - 84, Color.WHITE.getRGB());

        int[] position = {this.height / 2 - 60};
        MuteBase.getMuteMaps().values().stream().skip((this.pageNumber - 1) * 3).limit(3).forEach(base -> {
            if(base.hasDescription()) {
                drawCenteredString(this.fontRenderer, "§l" + base.getName(), this.width / 2, position[0], Color.WHITE.getRGB());
                position[0] += 14;
                base.getDescription().forEach(text -> {
                    drawCenteredString(this.fontRenderer, text, this.width / 2, position[0], Color.WHITE.getRGB());
                    position[0] += 10;
                });
                position[0] += 14;
            }
        });
    }

    @Override
    public void initGui() {
        this.pages = (int) Math.ceil((double) MuteBase.getMuteMaps().size() / 3d);

        if(this.pageNumber > 1) {
            this.buttonList.add(new GuiButton(11, this.width / 2 - 210, this.height / 2 + 95, 20, 20, "◀"));
        }
        if(this.pageNumber != this.pages) {
            this.buttonList.add(new GuiButton(12, this.width / 2 + 190, this.height / 2 + 95, 20, 20, "▶"));
        }
        this.buttonList.add(new GuiButton(13, this.width / 2 + 190, this.height / 2 - 115, 20, 20, "×"));
        this.buttonList.add(new GuiButton(14, this.width / 2 - 210, this.height / 2 - 115, 30, 20, "Mute"));
    }

    public void actionPerformed(GuiButton button){
        switch (button.id){
            case 11:
                this.mc.displayGuiScreen(new HelpGui(this.pageNumber - 1));
                break;
            case 12:
                this.mc.displayGuiScreen(new HelpGui(this.pageNumber + 1));
                break;
            case 13:
                this.mc.player.closeScreen();
                break;
            case 14:
                this.mc.displayGuiScreen(new MuteGui(1));
                break;
        }
    }
}
