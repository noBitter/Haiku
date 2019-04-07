package me.uoken.haiku.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.uoken.haiku.mute.MuteBase;

import java.io.*;

public class ConfigUtil {
    private File muteConfigFile;
    private JsonObject data = new JsonObject();
    private final Gson pp = new GsonBuilder().setPrettyPrinting().create();

    public ConfigUtil(String directory){
        this.muteConfigFile = new File(directory +  File.separator + "config", "haiku.cfg");
    }

    public void saveMute(){
        try{
            if(!muteConfigFile.exists()){
                muteConfigFile.getParentFile().mkdirs();
                muteConfigFile.createNewFile();
            }

            FileWriter fw = new FileWriter(this.muteConfigFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for(MuteBase base : MuteBase.getMuteMaps().values()){
                this.data.addProperty("show" + base.getIdString(), String.valueOf(base.isEnabled()));
            }

            bw.write(this.pp.toJson(data));
            bw.close();
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMute(){
        if(!this.muteConfigFile.exists()){
            saveMute();
        }else {
            try{
                FileReader fr = new FileReader(this.muteConfigFile);
                BufferedReader br = new BufferedReader( fr);
                StringBuilder sb = new StringBuilder();

                String line;

                while((line = br.readLine()) != null){
                    sb.append(line);
                }

                this.data = new JsonParser().parse(sb.toString()).getAsJsonObject();

                for(MuteBase base : MuteBase.getMuteMaps().values()){
                    base.setEnabled(this.data.get("show" + base.getIdString()).getAsBoolean());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
