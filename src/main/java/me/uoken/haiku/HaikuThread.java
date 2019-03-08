package me.uoken.haiku;

public class HaikuThread implements Runnable {
    public void run() {
        try {
            Thread.sleep(100);

            Haiku.getInstance().getMc().thePlayer.addChatMessage(Haiku.getInstance().getAddChatMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
