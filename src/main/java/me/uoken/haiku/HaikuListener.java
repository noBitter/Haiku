package me.uoken.haiku;

//import me.uoken.haiku.util.ConfigUtil;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//import java.util.ArrayList;

public class HaikuListener {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event){
        if(!Haiku.getInstance().isSeichiClick()){
            return;
        }

        String line = TextFormatting.getTextWithoutFormattingCodes(event.getMessage().getUnformattedText());
        char firstCharacter = line.charAt(0);


        if(line.startsWith(Reference.BUFF_LINE)){
            Haiku.getInstance().setCountBuff(Haiku.getInstance().getCountBuff() + 1);

            if(!Haiku.getInstance().isShowBuffCounter() && !Haiku.getInstance().isShowRankingCounter()){
                Haiku.getInstance().setAddChatMessage(null);
            }else if(Haiku.getInstance().isShowBuffCounter() && !Haiku.getInstance().isShowRankingCounter()){
                Haiku.getInstance().setAddChatMessage(new TextComponentString(
                        Reference.BUFF_COUNTER_MESSAGE + Haiku.getInstance().getCountBuff()
                ));
            }else if(!Haiku.getInstance().isShowBuffCounter() && Haiku.getInstance().isShowRankingCounter()){
                Haiku.getInstance().setAddChatMessage(new TextComponentString(
                        Reference.RANKING_COUNTER_MESSAGE + Haiku.getInstance().getCountRanking()
                ));
            }else if(Haiku.getInstance().isShowBuffCounter() && Haiku.getInstance().isShowRankingCounter()){
                Haiku.getInstance().setAddChatMessage(new TextComponentString(
                        Reference.BUFF_COUNTER_MESSAGE + Haiku.getInstance().getCountBuff() + "\n" + Reference.RANKING_COUNTER_MESSAGE + Haiku.getInstance().getCountRanking()
                ));
            }

            Haiku.THREAD_POOL.submit(new HaikuThread());

            if(!Haiku.getInstance().isShowBuffChat()){
                event.setCanceled(true);
            }
        }

        if(line.equals(Reference.RANKING_LINE)){
            Haiku.getInstance().setCountBuff(0);
            Haiku.getInstance().setCountRanking(Haiku.getInstance().getCountRanking() + 1);

            if(Haiku.getInstance().isShowRankingCounter()) {
                Haiku.getInstance().setAddChatMessage(new TextComponentString(
                        Reference.RANKING_COUNTER_MESSAGE + Haiku.getInstance().getCountRanking()
                ));

                Haiku.THREAD_POOL.submit(new HaikuThread());
            }
        }
        /*
        if(line.startsWith("[") && (line.endsWith("]" + Haiku.getInstance().getMc().thePlayer.getDisplayNameString() + Reference.GT_TRIGGER_LINE))){
            Haiku.getInstance().setInputGiganticNameChat(true);
        }

        if((Haiku.getInstance().isInputGiganticNameChat()) &&
                (line.startsWith("A") || line.startsWith("I") || line.startsWith("N") || line.startsWith("H") || line.startsWith("P") || line.startsWith("T") || line.startsWith("G")) &&
                line.endsWith(Reference.GT_NAME_LINE)){

            ArrayList<Character> giganticNameCh = new ArrayList<>();

            for(int i = 0; line.charAt(i) != 'を'; i++){
                giganticNameCh.add(line.charAt(i));
            }

            String giganticNameStr = Haiku.getInstance().getStringRepresentation(giganticNameCh);
            String giganticHitNumStr = null;

            switch(giganticNameStr) {
                case "APOLLO":
                    Haiku.getInstance().setHitApollo(Haiku.getInstance().getHitApollo() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitApollo());
                    break;
                case "ICARUS":
                    Haiku.getInstance().setHitIcarus(Haiku.getInstance().getHitIcarus() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitIcarus());
                    break;
                case "NEMESIS":
                    Haiku.getInstance().setHitNemesis(Haiku.getInstance().getHitNemesis() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitNemesis());
                    break;
                case "HERCULES":
                    Haiku.getInstance().setHitHercules(Haiku.getInstance().getHitHercules() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitHercules());
                    break;
                case "PLUTO":
                    Haiku.getInstance().setHitPluto(Haiku.getInstance().getHitPluto() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitPluto());
                    break;
                case "THANATOS":
                    Haiku.getInstance().setHitThanatos(Haiku.getInstance().getHitThanatos() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitThanatos());
                    break;
                case "GAEA":
                    Haiku.getInstance().setHitGaea(Haiku.getInstance().getHitGaea() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitGaea());
                    break;
                case "TITAN":
                    Haiku.getInstance().setHitTitan(Haiku.getInstance().getHitTitan() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitTitan());
                    break;
                case "ARTEMIS":
                    Haiku.getInstance().setHitArtemis(Haiku.getInstance().getHitArtemis() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitArtemis());
                    break;
                case "ARTHUR":
                    Haiku.getInstance().setHitArthur(Haiku.getInstance().getHitArthur() + 1);
                    giganticHitNumStr = String.valueOf(Haiku.getInstance().getHitArthur());
            }

            if(Haiku.getInstance().isShowGiganticCounter()) {
                Haiku.getInstance().setAddChatMessage(new TextComponentString(giganticHitNumStr + "個目の" + giganticNameStr + "を引きました。"));

                Haiku.THREAD_POOL.submit(new HaikuThread());
            }

            ConfigUtil.saveConfig();

            Haiku.getInstance().setInputGiganticNameChat(false);
        }*/

        if(!Haiku.getInstance().isShowCommonHitChat() &&
                line.startsWith(Reference.WINNING_LINE) ||
                (line.startsWith(Reference.GREAT_WINNING_LINE_1) || line.startsWith(Reference.GREAT_WINNING_LINE_2))){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowTipsChat() && line.startsWith(Reference.TIPS_LINE)){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowFlyChat() && line.equals(Reference.UNLIMITED_FLYING_LINE)){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowLoggedInChat() &&
                (('a' <= firstCharacter && firstCharacter <= 'z') || ('A' <= firstCharacter && firstCharacter <= 'Z') || ('0' <= firstCharacter && firstCharacter <= '9') || line.startsWith("_"))
                && line.endsWith(Reference.PLAYER_LOGGEDIN_LINE) ){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowClearLagChat() &&
                line.startsWith(Reference.CLEARLAG_LINE)){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowSaveChat() &&
                (line.equals(Reference.SAVED_WORLD_LINE) || line.equals(Reference.SAVING_WORLD_LINE) ||
                        (line.equals(Reference.SAVING_PLAYERDATA_LINE) || line.equals(Reference.SAVED_PLAYERDATA_LINE)) ||
                        (line.equals(Reference.BACKUP_LINE)))){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowGachaCountChat() &&
                ('0' <= firstCharacter && firstCharacter <= '9') &&
                (line.endsWith(Reference.GACHA_COUNT_LINE))){
            event.setCanceled(true);
        }

        if(!(Haiku.getInstance().isShowOtherGiganticHit()) &&
                !(line.endsWith("]" + Haiku.getInstance().getMc().thePlayer.getDisplayNameString() + Reference.GT_TRIGGER_LINE)) &&
                line.startsWith("[") &&(line.endsWith(Reference.GT_TRIGGER_LINE))){
            Haiku.getInstance().setRemoveGiganticNameChat(true);

            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowGiganticHitChat() &&
                line.startsWith("[") && (line.endsWith("]" + Haiku.getInstance().getMc().thePlayer.getDisplayNameString() + Reference.GT_TRIGGER_LINE))){
            Haiku.getInstance().setRemoveGiganticNameChat(true);

            event.setCanceled(true);
        }

        if(Haiku.getInstance().isRemoveGiganticNameChat() &&
                (line.startsWith("A") || line.startsWith("I") || line.startsWith("N") || line.startsWith("H") || line.startsWith("P") || line.startsWith("T") || line.startsWith("G")) &&
                (line.endsWith(Reference.GT_NAME_LINE))){
            event.setCanceled(true);

            Haiku.getInstance().setRemoveGiganticNameChat(false);
        }

        if(!Haiku.getInstance().isShowGiganticHitChat() &&
                (line.startsWith("おめでとう！！！！！Gigantic☆大当たり！"))){
            event.setCanceled(true);
        }
    }
}
