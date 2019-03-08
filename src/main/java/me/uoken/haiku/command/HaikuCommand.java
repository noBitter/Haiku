package me.uoken.haiku.command;

import me.uoken.haiku.Haiku;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class HaikuCommand extends CommandBase {
    public String displaySwitch;

    public String getCommandName(){
        return "haiku";
    }

    public String getCommandUsage(ICommandSender sender){
        return "/Haiku";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args){
        Haiku.getInstance().setShowGui(true);
    }

    public int getRequiredPermissionLevel()
    {
        return 0;
    }
}
