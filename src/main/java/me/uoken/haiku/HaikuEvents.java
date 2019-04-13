package me.uoken.haiku;

import me.uoken.haiku.mute.MuteBase;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.util.regex.Pattern;

public class HaikuEvents {
    private Haiku mod = Haiku.getInstance();

    private boolean onSeichiClick = false;

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onChat(final ClientChatReceivedEvent event){
        // TODO: Return if not on the server
        if(!this.onSeichiClick){
            return;
        }

        String playerName = mod.getMc().player.getDisplayNameString();
        String line = TextFormatting.getTextWithoutFormattingCodes(event.getMessage().getUnformattedText());

        for(MuteBase type : MuteBase.getMuteMaps().values()){
            if(!type.isEnabled()){
                if(!type.isShowFollowed()){
                    type.checkFollowed(line);
                    event.setCanceled(true);
                    break;
                }

                if(type.shouldMute(line, playerName)) {
                    event.setCanceled(true);
                    break;
                }
            }
        }
    }

    @SubscribeEvent
    public void playerLoggedIn(FMLNetworkEvent.ClientConnectedToServerEvent event){
        this.onSeichiClick = (!this.mod.getMc().isSingleplayer() && event.getManager().getRemoteAddress().toString().toLowerCase().contains("play.seichi.click"));
    }
}
