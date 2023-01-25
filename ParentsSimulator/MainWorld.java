import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author Yixin Cai
 * @version 2023-01-22
 * 
 * Pointing Finger by Dave Gandy
 * <a href="https://www.flaticon.com/free-icons/arrow" title="arrow icons">Arrow icons created by Dave Gandy - Flaticon</a>
 */
public class MainWorld extends World
{
    private int stage;
    private Label stageLabel;
    private int tik;
    private Button scheduleButton;
    private Button playPixelArtButton;
    private Button playMemoryButton;
    private Button playChessButton;
    private Button resultButton;
    private FlashingText pointingFinger;
    
    private Map<String, Stat> statMap;
    
    private boolean playArtGame;
    private boolean playMemoryGame;
    private boolean playMazeGame;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainWorld() {
        super(1000, 700, 1); 
        
        this.scheduleButton = new Button("buttonSchedule.png");
        addObject(scheduleButton, 800, 600);
        
        this.stage = 0;
        this.stageLabel = new Label("");
        addObject(stageLabel, 500, 20);
        updateStageLabel();
        this.tik = 0;
        
        this.playPixelArtButton = new Button("buttonPixelGame.png");
        addObject(playPixelArtButton, 200, 200);
        this.playMemoryButton = new Button("buttonMemoryGame.png");
        addObject(playMemoryButton, 130, 195);
        this.playChessButton = new Button("buttonChessGame.png");
        addObject(playChessButton, 160, 95);
        this.resultButton = new Button("buttonResult.png");
        this.pointingFinger = new FlashingText(new GreenfootImage("pointingFinger.png"));
        addObject(pointingFinger, 320, 150);
        
        Stat iqStat = new Stat(0);
        Stat eqStat = new Stat(0);
        Stat memoryStat = new Stat(0);
        Stat creativityStat = new Stat(0);
        addObject(iqStat, 240, 360);
        addObject(eqStat, 240, 440);
        addObject(memoryStat, 240, 520);
        addObject(creativityStat, 240, 600);
        
        this.statMap = new HashMap<String, Stat>();
        this.statMap.put("IQ", iqStat);
        this.statMap.put("EQ", eqStat);
        this.statMap.put("Memory", memoryStat);
        this.statMap.put("Creativity", creativityStat);
        
        Constants.backgroundSound.playLoop();
        
        setBackground();
        
        playArtGame = false;
        playMemoryGame = false;
        playMazeGame = false;
    }
    
    public void act() {
        // Game about to finish
        if (this.stage > 2) {
            removeObject(this.scheduleButton);
            if(playArtGame && playMazeGame && playMemoryGame){
                if (this.resultButton.getWorld() == null) {
                    addObject(this.resultButton, 800, 600);
                }
                else if (Greenfoot.mouseClicked(this.resultButton)) {
                    this.resultButton.playSound();
                    int[] stats = {
                        this.statMap.get("IQ").getValue(),
                        this.statMap.get("EQ").getValue(),
                        this.statMap.get("Memory").getValue(),
                        this.statMap.get("Creativity").getValue()
                    };
                    EndWorld ew = new EndWorld(stats);
                    Greenfoot.setWorld(ew);
                }
            }
        }
        
        if (Greenfoot.mouseClicked(this.scheduleButton)) {
            this.scheduleButton.playSound();
            ScheduleWorld sw = new ScheduleWorld(this);
            Greenfoot.setWorld(sw);
        }
        else if (Greenfoot.mouseClicked(this.playPixelArtButton)) {
            stopSound();
            this.playPixelArtButton.playSound();
            playArtGame=true;
            PixelArtWorld prw = new PixelArtWorld(this);
            Greenfoot.setWorld(prw);
        }
        else if (Greenfoot.mouseClicked(this.playMemoryButton)) {
            stopSound();
            this.playMemoryButton.playSound();
            playMemoryGame=true;
            GameIntroWorld giw = new GameIntroWorld(this);
            Greenfoot.setWorld(giw);
        }
        else if (Greenfoot.mouseClicked(this.playChessButton)) {
            stopSound();
            this.playChessButton.playSound();
            playMazeGame=true;
            OpeningScreen cb = new OpeningScreen(this);
            Greenfoot.setWorld(cb);
        }
    }
    
    public int getStage() {
        return this.stage;
    }

    public void nextStage() {
        this.stage++;
        updateStageLabel();
        setBackground();
    }
    
    public void addPoint(String name, int point) {
        this.statMap.get(name).addPoint(point);
    }
    
    public String getStageText() {
        String text = "Stage: ";
        switch(this.stage) {
            case 0:
                return text + "1-6 Years Old";
            case 1:
                return text + "7-12 Years Old";
            case 2:
                return text + "13-18 Years Old";
            default:
                return text + "Adult";
        }
    }
    
    private void updateStageLabel() {
        this.stageLabel.updateLabel(getStageText());
    }
    
    private void setBackground() {
        String fileName;
        if (this.stage == 0) {
            fileName = "backgroundBaby.png";
        }
        else if (this.stage == 1) {
            fileName = "backgroundChild.png";
        }
        else {
            fileName = "backgroundTeen.png";
        }
        GreenfootImage background = new GreenfootImage(fileName);
        setBackground(background);
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Constants.backgroundSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        stopSound();
    }
    
    private void stopSound() {
        Constants.backgroundSound.pause();
    }
}
