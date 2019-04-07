package me.uoken.haiku.command;

import me.uoken.haiku.Haiku;
import me.uoken.haiku.gui.MuteGui;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class HaikuCommand extends CommandBase {
    public String getName(){
        return "haiku";
    }

    public String getUsage(ICommandSender sender){
        return "/haiku";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args){
        new MuteGui(1).display();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
