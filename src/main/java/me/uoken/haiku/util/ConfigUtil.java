package me.uoken.haiku.util;

import me.uoken.haiku.Haiku;

import java.io.*;

public class ConfigUtil {
    private static File CONFIG_FILE = new File(Haiku.getInstance().getMc().mcDataDir + File.separator + "config", "haiku.cfg");

    public static void saveConfig()
    {
        try
        {
            if (!CONFIG_FILE.exists())
            {
                CONFIG_FILE.getParentFile().mkdirs();
                CONFIG_FILE.createNewFile();
            }

            FileWriter writer = new FileWriter(CONFIG_FILE, false);

            writer.write(/*Haiku.getInstance().getHitApollo() + "\n" + Haiku.getInstance().getHitIcarus() + "\n" + Haiku.getInstance().getHitNemesis() + "\n"
                    + Haiku.getInstance().getHitHercules() + "\n" + Haiku.getInstance().getHitPluto() + "\n" + Haiku.getInstance().getHitThanatos() + "\n"
                    + Haiku.getInstance().getHitGaea() + "\n" + Haiku.getInstance().getHitTitan() + "\n" + Haiku.getInstance().getHitArtemis() + "\n"
                    + Haiku.getInstance().getHitArthur() + "\n" + */Haiku.getInstance().isShowBuffCounter() + "\n" + Haiku.getInstance().isShowRankingCounter() + "\n"
                    + Haiku.getInstance().isShowGiganticCounter() + "\n" + Haiku.getInstance().isShowTipsChat() + "\n" + Haiku.getInstance().isShowClearLagChat() + "\n"
                    + Haiku.getInstance().isShowCommonHitChat() + "\n" + Haiku.getInstance().isShowGiganticHitChat() + "\n" + Haiku.getInstance().isShowFlyChat() + "\n"
                    + Haiku.getInstance().isShowLoggedInChat() + "\n" + Haiku.getInstance().isShowOtherGiganticHit() + "\n" + Haiku.getInstance().isShowSaveChat() + "\n"
                    + Haiku.getInstance().isShowGachaCountChat() + "\n" + Haiku.getInstance().isShowBuffChat() + "\n" + Haiku.getInstance().isShowGiganticHitChat()
            );

            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void loadConfig(){
        if(!CONFIG_FILE.exists()){
            saveConfig();
        }

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(CONFIG_FILE));
            String line;
            int i = 0;

            while((line = bufferedReader.readLine()) != null){
                i++;
                switch(i){
                    /*case 1:
                        Haiku.getInstance().setHitApollo(Integer.parseInt(line));
                        break;
                    case 2:
                        Haiku.getInstance().setHitIcarus(Integer.parseInt(line));
                        break;
                    case 3:
                        Haiku.getInstance().setHitNemesis(Integer.parseInt(line));
                        break;
                    case 4:
                        Haiku.getInstance().setHitHercules(Integer.parseInt(line));
                        break;
                    case 5:
                        Haiku.getInstance().setHitPluto(Integer.parseInt(line));
                        break;
                    case 6:
                        Haiku.getInstance().setHitThanatos(Integer.parseInt(line));
                        break;
                    case 7:
                        Haiku.getInstance().setHitGaea(Integer.parseInt(line));
                        break;
                    case 8:
                        Haiku.getInstance().setHitTitan(Integer.parseInt(line));
                        break;
                    case 9:
                        Haiku.getInstance().setHitArtemis(Integer.parseInt(line));
                        break;
                    case 10:
                        Haiku.getInstance().setHitArthur(Integer.parseInt(line));*/
                    case 1:
                        Haiku.getInstance().setShowBuffCounter(Boolean.valueOf(line));
                    case 2:
                        Haiku.getInstance().setShowRankingCounter(Boolean.valueOf(line));
                    case 3:
                        Haiku.getInstance().setShowGiganticCounter(Boolean.valueOf(line));
                    case 4:
                        Haiku.getInstance().setShowTipsChat(Boolean.valueOf(line));
                    case 5:
                        Haiku.getInstance().setShowClearLagChat(Boolean.valueOf(line));
                    case 6:
                        Haiku.getInstance().setShowCommonHitChat(Boolean.valueOf(line));
                    case 7:
                        Haiku.getInstance().setShowGiganticHitChat(Boolean.valueOf(line));
                    case 8:
                        Haiku.getInstance().setShowFlyChat(Boolean.valueOf(line));
                    case 9:
                        Haiku.getInstance().setShowLoggedInChat(Boolean.valueOf(line));
                    case 10:
                        Haiku.getInstance().setShowOtherGiganticHit(Boolean.valueOf(line));
                    case 11:
                        Haiku.getInstance().setShowSaveChat(Boolean.valueOf(line));
                    case 12:
                        Haiku.getInstance().setShowGachaCountChat(Boolean.valueOf(line));
                    case 13:
                        Haiku.getInstance().setShowBuffChat(Boolean.valueOf(line));
                    case 14:
                        Haiku.getInstance().setShowGiganticHitChat(Boolean.valueOf(line));
                }
            }

            bufferedReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
