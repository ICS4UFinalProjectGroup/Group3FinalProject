import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScheduleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScheduleWorld extends World
{
    private MainWorld mainWorld;
    private Button finishButton;
    
    /**
     * Constructor for objects of class ScheduleWorld.
     * 
     */
    public ScheduleWorld(MainWorld mainWorld)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        this.mainWorld = mainWorld;
        this.finishButton = new Button("scheduleButton.png");
        addObject(this.finishButton, 800, 600);
        drawGrid();
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this.finishButton)) {
            this.mainWorld.finishSchedule(1, 2, 3, 4);
            Greenfoot.setWorld(this.mainWorld);
        }
    }
    
    public void drawGrid() {
        addObject(new Grid(), 650, 350);
        addObject(new ListGrid(Math.min(this.mainWorld.getRound() + 1, 6)), 200, 350);
    }
}
