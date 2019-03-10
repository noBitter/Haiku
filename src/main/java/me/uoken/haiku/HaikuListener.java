package me.uoken.haiku;

import me.uoken.haiku.util.ConfigUtil;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

public class HaikuListener {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event){
        if(!Haiku.getInstance().isSeichiClick()){
            return;
        }

        String line = TextFormatting.getTextWithoutFormattingCodes(event.getMessage().getUnformattedText());
        char firstCharacter = line.charAt(0);

        if(line.startsWith("★採掘速度上昇レベルが")){
            Haiku.getInstance().setCountBuff(Haiku.getInstance().getCountBuff() + 1);

            if(!Haiku.getInstance().isShowBuffCounter() && !Haiku.getInstance().isShowRankingCounter()){
                return;
            }else if(Haiku.getInstance().isShowBuffCounter() && !Haiku.getInstance().isShowRankingCounter()){
                Haiku.getInstance().setAddChatMessage(new TextComponentString(
                        "Buff Counter: " + Haiku.getInstance().getCountBuff()
                ));
            }else if(!Haiku.getInstance().isShowBuffCounter() && Haiku.getInstance().isShowRankingCounter()){
                Haiku.getInstance().setAddChatMessage(new TextComponentString(
                        "Ranking Counter: " + Haiku.getInstance().getCountRanking()
                ));
            }else if(Haiku.getInstance().isShowBuffCounter() && Haiku.getInstance().isShowRankingCounter()){
                Haiku.getInstance().setAddChatMessage(new TextComponentString(String.format(
                        "%s%n%s", "Buff Counter: " + Haiku.getInstance().getCountBuff(), "Ranking Counter: " + Haiku.getInstance().getCountRanking()
                )));
            }

            Haiku.THREAD_POOL.submit(new HaikuThread());
        }

        if(line.equals("--------------30分間整地ランキング--------------")){
            Haiku.getInstance().setCountBuff(0);
            Haiku.getInstance().setCountRanking(Haiku.getInstance().getCountRanking() + 1);

            if(Haiku.getInstance().isShowRankingCounter()) {
                Haiku.getInstance().setAddChatMessage(new TextComponentString(
                        "Ranking Counter: " + Haiku.getInstance().getCountRanking()
                ));

                Haiku.THREAD_POOL.submit(new HaikuThread());
            }
        }

        if(line.startsWith("[") && (line.endsWith("]" + Haiku.getInstance().getMc().thePlayer.getDisplayNameString() + "がガチャでGigantic☆大当たり！"))){
            Haiku.getInstance().setInputNextChatLine(true);
        }

        if((Haiku.getInstance().isInputNextChatLine()) &&
                (line.startsWith("A") || line.startsWith("I") || line.startsWith("N") || line.startsWith("H") || line.startsWith("P") || line.startsWith("T") || line.startsWith("G")) &&
                line.endsWith("を引きました！おめでとうございます！")){

            ArrayList<Character> giganticNameCh = new ArrayList<Character>();

            for(int i = 0; line.charAt(i) != 'を'; i++){
                giganticNameCh.add(line.charAt(i));
            }

            String giganticNameStr = Haiku.getInstance().getStringRepresentation(giganticNameCh);
            String giganticHitNumStr = "";

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

            Haiku.getInstance().setInputNextChatLine(false);
        }

        if(!Haiku.getInstance().isShowWinChat() && line.startsWith("おめでとう！当たり！")){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowGreatWinChat() && line.startsWith("おめでとう‼︎大当たり！")){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowTipsChat() && line.startsWith("[Tips]")){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowFlyChat() && line.equals("Fly効果は無期限で継続中です")){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowLoggedInChat() &&
                (('a' <= firstCharacter && firstCharacter <= 'z') || ('A' <= firstCharacter && firstCharacter <= 'Z') || ('0' <= firstCharacter && firstCharacter <= '9') || line.startsWith("_"))
                && line.endsWith("がログインしました") ){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowClearLagChat() &&
                line.startsWith("[ClearLag]")){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowPlayerSaveChat() &&
                (line.equals("プレイヤーデータセーブ中…") || line.equals("プレイヤーデータセーブ完了"))){
            event.setCanceled(true);
        }

        if(!Haiku.getInstance().isShowWorldSaveChat() &&
                (line.equals("ワールドセーブ中....")) || line.equals("ワールドセーブ完了")){
            event.setCanceled(true);
        }
    }
}
