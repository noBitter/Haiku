package me.uoken.haiku;

import me.uoken.haiku.command.HaikuCommand;
import me.uoken.haiku.mute.MuteBase;
import me.uoken.haiku.util.ConfigUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Haiku.MODID, version = Haiku.MOD_VERSION, useMetadata = true)
public class Haiku {
    private Minecraft mc = Minecraft.getMinecraft();
    private ConfigUtil configUtil = new ConfigUtil(this.mc.mcDataDir.toString());
    private HaikuEvents haikuEvents = new HaikuEvents();

    public static final String MODID = "haiku";
    public static final String MOD_NAME = "Haiku";
    public static final String MOD_VERSION = "1.1.1";

    @Mod.Instance
    private static Haiku instance;

    @Mod.Metadata
    private static ModMetadata modMetadata;

    private void loadMeta(ModMetadata modMetadata){
        modMetadata.modId = MODID;
        modMetadata.name = MOD_NAME;
        modMetadata.version = MOD_VERSION;
        modMetadata.authorList.add("uoken");
        modMetadata.description = "/haiku - Open GUI.";
        modMetadata.url = "https://github.com/noBitter/Haiku";
        modMetadata.autogenerated = false;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        loadMeta(modMetadata);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        MuteBase.remake();

        instance = this;

        MinecraftForge.EVENT_BUS.register(new HaikuEvents());
        ClientCommandHandler.instance.registerCommand(new HaikuCommand());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        configUtil.loadMute();
    }

    public static Haiku getInstance() {
        return instance;
    }

    public Minecraft getMc() {
        return mc;
    }

    public ConfigUtil getConfigUtil() {
        return configUtil;
    }

    public HaikuEvents getHaikuEvents() {
        return haikuEvents;
    }
}
