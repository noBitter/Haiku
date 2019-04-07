package me.uoken.haiku.gui;

import me.uoken.haiku.Haiku;
import me.uoken.haiku.mute.MuteBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.awt.*;

public class MuteGui extends GuiScreen {
    private Haiku mod = Haiku.getInstance();
    private int pages;
    private int pageNumber;
    private boolean changed = false;

    public MuteGui(int pageNumber){
        this.pageNumber = pageNumber;
    }

    public void initGui(){
        this.pages = (int) Math.ceil((double) MuteBase.getMuteMaps().size() / 10d);

        final int[] position = {this.height / 2 - 58, this.height / 2 - 58};
        final int[] id = {1};
        MuteBase.getMuteMaps().values().stream().skip((this.pageNumber - 1) * 10).limit(10).forEach(base -> {
            if(id[0] <= 5){
                GuiButton button = new GuiButton(id[0], this.width / 2 - 205, position[0], base.getDisplayName() + (base.isEnabled() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Mute"));
                this.buttonList.add(button);
                position[0] += 24;
            }else {
                GuiButton button = new GuiButton(id[0], this.width / 2 + 5, position[1], base.getDisplayName() + (base.isEnabled() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Mute"));
                this.buttonList.add(button);
                position[1] += 24;
            }
            id[0] ++;
        });

        if(this.pageNumber > 1) {
            this.buttonList.add(new GuiButton(11, this.width / 2 - 210, this.height / 2 + 95, 20, 20, "◀"));
        }
        if(this.pageNumber != this.pages) {
            this.buttonList.add(new GuiButton(12, this.width / 2 + 190, this.height / 2 + 95, 20, 20, "▶"));
        }
        this.buttonList.add(new GuiButton(13, this.width / 2 + 190, this.height / 2 - 115, 20, 20, "×"));
        this.buttonList.add(new GuiButton(14, this.width / 2 - 210, this.height / 2 - 115, 30, 20, "Help"));
    }

    public void drawScreen(int x, int y, float ticks){
        drawDefaultBackground();

        drawCenteredString(this.fontRenderer, "Mute Settings", this.width / 2, this.height / 2 - 84, Color.WHITE.getRGB());

        super.drawScreen(x, y, ticks);
    }

    public void actionPerformed(GuiButton button){
        if(button.id <= 10) {
            final int[] id = {1};
            MuteBase.getMuteMaps().values().stream().skip((this.pageNumber - 1) * 10).limit(10).forEach(base -> {
                if (button.id == id[0]) {
                    base.setEnabled(!base.isEnabled());
                    button.displayString = base.getDisplayName() + (base.isEnabled() ? TextFormatting.GREEN + "Show" : TextFormatting.RED + "Mute");
                    this.changed = true;
                }
                id[0]++;
            });
        }

        switch (button.id){
            case 11:
                this.mc.displayGuiScreen(new MuteGui(this.pageNumber - 1));
                break;
            case 12:
                this.mc.displayGuiScreen(new MuteGui(this.pageNumber + 1));
                break;
            case 13:
                this.mc.player.closeScreen();
                break;
            case 14:
                this.mc.displayGuiScreen(new HelpGui(1));
                break;
        }
    }

    public void onGuiClosed(){
        if(this.changed) {
            this.mod.getConfigUtil().saveMute();
        }
    }

    public final void display() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public final void onTick(TickEvent.ClientTickEvent event) {
        MinecraftForge.EVENT_BUS.unregister(this);
        Minecraft.getMinecraft().displayGuiScreen(this);
    }
}
