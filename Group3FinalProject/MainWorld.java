import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWorld extends World
{
    private Stats stats = new Stats();
    
    private Button scheduleButton;
    
    private int round;
    private Label roundLabel;
    
    // TODO: temp for testing
    private Label statsLabel;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        GreenfootImage background = new GreenfootImage("room.png");
        setBackground(background);
        
        this.scheduleButton = new Button("scheduleButton.png");
        addObject(scheduleButton, 800, 600);
        
        this.round = 0;
        this.roundLabel = new Label(this.round);
        addObject(roundLabel, 500, 350);
        
        this.statsLabel = new Label(this.stats.getString());
        addObject(statsLabel, 100, 350);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this.scheduleButton)) {
            ScheduleWorld sw = new ScheduleWorld(this);
            Greenfoot.setWorld(sw);
        }
    }
    
    public void finishSchedule(int IQ, int EQ, int creativity, int memory) {
        this.round++;
        this.stats.promote(IQ, EQ, creativity, memory);
        this.roundLabel.updateLabel(this.round);
        this.statsLabel.updateLabel(this.stats.getString());
    }
    
    public int getRound() {
        return this.round;
    }
    
    public Stats getStats() {
        return this.stats;
    }
}
