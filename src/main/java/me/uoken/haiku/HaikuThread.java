package me.uoken.haiku;

public class HaikuThread implements Runnable {
    public void run() {
        try {
            Thread.sleep(50);

            if(Haiku.getInstance().getAddChatMessage() != null) {
                Haiku.getInstance().getMc().thePlayer.addChatMessage(Haiku.getInstance().getAddChatMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
