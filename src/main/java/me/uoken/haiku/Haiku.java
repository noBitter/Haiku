package me.uoken.haiku;

import me.uoken.haiku.command.HaikuCommand;
import me.uoken.haiku.gui.HaikuGuiScreen;
import me.uoken.haiku.gui.HaikuGuiScreenSecond;
import me.uoken.haiku.util.ConfigUtil;
import me.uoken.haiku.util.HaikuThreadFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Mod(modid = "Haiku", version = "1.0", clientSideOnly = true, acceptedMinecraftVersions = "[1.10.2]")
public class Haiku {
    private final Minecraft mc = Minecraft.getMinecraft();
    private int countBuff = 0;
    private static Haiku instance;
    private int hitApollo, hitIcarus, hitNemesis, hitHercules, hitPluto, hitThanatos, hitGaea, hitTitan, hitArtemis, hitArthur;
    private int countRanking = 0;
    private ITextComponent addChatMessage;
    public static final ExecutorService THREAD_POOL;
    private boolean inputNextChatLine = false;
    private boolean showBuffCounter = true, showRankingCounter = true, showGiganticCounter = true;
    private boolean showGui = false;
    private boolean showGuiSecond = false;
    private boolean showWinChat = false;
    private boolean showGreatWinChat = false;
    private boolean showFlyChat = false;
    private boolean showLoggedInChat = false;
    private boolean showClearLagChat = false;
    private boolean showTipsChat = false;
    private boolean showPlayerSaveChat = false;
    private boolean showWorldSaveChat = false;
    private boolean onSeichiClick;
    private boolean dragonNight;
    private Calendar cTime;

    static {
        THREAD_POOL = Executors.newCachedThreadPool(new HaikuThreadFactory());
    }

    public static Haiku getInstance(){
        return instance;
    }

    public Minecraft getMc(){
        return this.mc;
    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event){
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);

        ClientCommandHandler.instance.registerCommand(new HaikuCommand());

        MinecraftForge.EVENT_BUS.register(new HaikuListener());

        ConfigUtil.loadConfig();
    }

    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event){
        if(this.showGui){
            this.mc.displayGuiScreen(new HaikuGuiScreen());

            this.showGui = false;
        }

        if(this.showGuiSecond){
            this.mc.displayGuiScreen(new HaikuGuiScreenSecond());

            this.showGuiSecond = false;
        }
    }

    @SubscribeEvent
    public void playerLoggedIn(final FMLNetworkEvent.ClientConnectedToServerEvent event){
        this.onSeichiClick = (!this.mc.isSingleplayer() && event.getManager().getRemoteAddress().toString().toLowerCase().contains("play.seichi.click"));
    }

    public String getStringRepresentation(ArrayList<Character> list){
        StringBuilder builder = new StringBuilder(list.size());

        for(Character ch: list){
            builder.append(ch);
        }

        return builder.toString();
    }

    /*
    public boolean isDragonNight(){
        if(cTime.get(Calendar.HOUR_OF_DAY) == 20){
            this.doragonNight = true;
        }else{
            this.doragonNight = false;
        }

        return this.isDragonNight;
    }
    */

    public void setHitApollo(int hitApollo){
        this.hitApollo = hitApollo;
    }

    public int getHitApollo(){
        return this.hitApollo;
    }

    public void setHitIcarus(int hitIcarus){
        this.hitIcarus = hitIcarus;
    }

    public int getHitIcarus(){
        return this.hitIcarus;
    }

    public void setHitNemesis(int hitNemesis){
        this.hitNemesis = hitNemesis;
    }

    public int getHitNemesis(){
        return this.hitNemesis;
    }

    public void setHitHercules(int hitHercules){
        this.hitHercules = hitHercules;
    }

    public int getHitHercules(){
        return this.hitHercules;
    }

    public void setHitPluto(int hitPluto){
        this.hitPluto = hitPluto;
    }

    public int getHitPluto(){
        return this.hitPluto;
    }

    public void setHitThanatos(int hitThanatos){
        this.hitThanatos = hitThanatos;
    }

    public int getHitThanatos(){
        return this.hitThanatos;
    }

    public void setHitGaea(int hitGaea){
        this.hitGaea = hitGaea;
    }

    public int getHitGaea(){
        return this.hitGaea;
    }

    public void setHitTitan(int hitTitan){
        this.hitTitan = hitTitan;
    }

    public int getHitTitan(){
        return this.hitTitan;
    }

    public void setHitArtemis(int hitArtemis){
        this.hitArtemis = hitArtemis;
    }

    public int getHitArtemis(){
        return this.hitArtemis;
    }

    public void setHitArthur(int hitArthur){
        this.hitArthur = hitArthur;
    }

    public int getHitArthur(){
        return this.hitArthur;
    }

    public int getCountBuff(){
        return this.countBuff;
    }

    public void setCountBuff(int countBuff){
        this.countBuff = countBuff;
    }

    public int getCountRanking(){
        return this.countRanking;
    }

    public void setCountRanking(int countRanking){
        this.countRanking = countRanking;
    }

    public void setAddChatMessage(ITextComponent addChatMessage){
        this.addChatMessage = addChatMessage;
    }

    public ITextComponent getAddChatMessage(){
        return this.addChatMessage;
    }

    public void setInputNextChatLine(boolean inputNextLine){
        this.inputNextChatLine = inputNextLine;
    }

    public boolean isInputNextChatLine(){
        return this.inputNextChatLine;
    }

    public boolean isShowBuffCounter() {
        return showBuffCounter;
    }

    public boolean isShowRankingCounter() {
        return showRankingCounter;
    }

    public boolean isShowGiganticCounter() {
        return showGiganticCounter;
    }

    public void setShowBuffCounter(boolean showBuffCounter) {
        this.showBuffCounter = showBuffCounter;
    }

    public void setShowRankingCounter(boolean showRankingCounter) {
        this.showRankingCounter = showRankingCounter;
    }

    public void setShowGiganticCounter(boolean showGiganticCounter) {
        this.showGiganticCounter = showGiganticCounter;
    }

    public boolean isShowGui() {
        return showGui;
    }

    public void setShowGui(boolean showGui) {
        this.showGui = showGui;
    }

    public boolean isShowWinChat() {
        return showWinChat;
    }

    public boolean isShowGreatWinChat() {
        return showGreatWinChat;
    }

    public boolean isShowFlyChat() {
        return showFlyChat;
    }

    public boolean isShowLoggedInChat() {
        return showLoggedInChat;
    }

    public boolean isShowClearLagChat() {
        return showClearLagChat;
    }

    public void setShowWinChat(boolean showWinChat) {
        this.showWinChat = showWinChat;
    }

    public void setShowGreatWinChat(boolean showGreatWinChat) {
        this.showGreatWinChat = showGreatWinChat;
    }

    public void setShowFlyChat(boolean showFlyChat) {
        this.showFlyChat = showFlyChat;
    }

    public void setShowLoggedInChat(boolean showLoggedInChat) {
        this.showLoggedInChat = showLoggedInChat;
    }

    public void setShowClearLagChat(boolean showClearLagChat) {
        this.showClearLagChat = showClearLagChat;
    }

    public boolean isShowTipsChat() {
        return showTipsChat;
    }

    public void setShowTipsChat(boolean showTipsChat) {
        this.showTipsChat = showTipsChat;
    }

    public boolean isShowGuiSecond() {
        return showGuiSecond;
    }

    public void setShowGuiSecond(boolean showGuiSecond) {
        this.showGuiSecond = showGuiSecond;
    }

    public boolean isSeichiClick() {
        return this.onSeichiClick;
    }

    public boolean isShowPlayerSaveChat() {
        return this.showPlayerSaveChat;
    }

    public boolean isShowWorldSaveChat() {
        return this.showWorldSaveChat;
    }

    public void setShowPlayerSaveChat(boolean showPlayerSaveChat) {
        this.showPlayerSaveChat = showPlayerSaveChat;
    }

    public void setShowWorldSaveChat(boolean showWorldSaveChat) {
        this.showWorldSaveChat = showWorldSaveChat;
    }
}
