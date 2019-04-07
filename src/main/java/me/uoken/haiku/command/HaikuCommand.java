package me.uoken.haiku.command;

import me.uoken.haiku.Haiku;
<<<<<<< HEAD
import me.uoken.haiku.gui.MuteGui;
import net.minecraft.client.Minecraft;
=======
>>>>>>> origin/master
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class HaikuCommand extends CommandBase {
<<<<<<< HEAD
    public String getName(){
        return "haiku";
    }

    public String getUsage(ICommandSender sender){
=======
    public String getCommandName(){
        return "haiku";
    }

    public String getCommandUsage(ICommandSender sender){
>>>>>>> origin/master
        return "/haiku";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args){
<<<<<<< HEAD
        new MuteGui(1).display();
    }

    @Override
    public int getRequiredPermissionLevel() {
=======
        Haiku.getInstance().setShowGui(true);
    }

    public int getRequiredPermissionLevel()
    {
>>>>>>> origin/master
        return 0;
    }
}
