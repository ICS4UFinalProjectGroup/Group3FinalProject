import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import greenfoot.GreenfootImage;

/**
 * This is a world  
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class ScheduleWorld extends AbstractWorld
{
    // declare and initialize all the variables and objects here
    public static final int DEFAULT_ITEM_WIDTH = 120;
    public static final int DEFAULT_ITEM_HEIGHT = 90;
    
    private static final int LIST_ITEM_X0 = 142;
    private static final int LIST_ITEM_Y0 = 267;
    private static final int SCHEDULE_ITEM_X0 = 503;
    private static final int SCHEDULE_ITEM_Y0 = 335;
    
    private GreenfootImage scheduleText;
    private Label ageLabel;
    private Button finishButton;
    private FlashingText flashText;
    
    private ScheduleItem[][] scheduleTable;
    
    // It is a design of different types of glope sounds.
    // But the differences between them is too small to notice. so sad:(
    private static GreenfootSound[] sounds = {
        new GreenfootSound("glope1.wav"),
        new GreenfootSound("glope2.wav"),
        new GreenfootSound("glope3.wav"),
        new GreenfootSound("glope4.wav"),
    };
    private int soundNum = sounds.length;
    private int soundIndex = 0;
    
    /**
     * Constructor for objects of class ScheduleWorld.
     * @param mainWorld a object of MainWorld
     */
    public ScheduleWorld(MainWorld mainWorld)
    {
        super(mainWorld);

        setBackground(new GreenfootImage("backgroundSchedule.png"));
        addObject(new Label(this.mainWorld.getStageText()), 500, 20);
        this.finishButton = new Button("buttonSchedule.png");
        
        scheduleText = new GreenfootImage("scheduleText.png");
        flashText = new FlashingText(scheduleText);
        addObject(flashText, 680, 220);
        
        this.scheduleTable = initScheduleTable();
        
        initSelection();
        
        // for the sound index
        this.soundNum = sounds.length;
        this.soundIndex = 0;
    }
    
    /**
     * Act - do whatever the ScheduleWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // once player finished the filling schedule, move on the the 
        // ActivityEffectWorld to show the activitis effects.
        if (Greenfoot.mouseClicked(this.finishButton)) {
            ActivityEffectWorld aew = new ActivityEffectWorld(this.mainWorld, this.scheduleTable);
            Greenfoot.setWorld(aew);
        }
        
        initSelection();
        
        // Only add the finish button when player fills in all of the blocks
        if (canFinish() && finishButton.getWorld() == null) {
            addObject(this.finishButton, 210, 620);
        }
    }
    
    /**
     * This is a method used to set activities with sound effect. 
     * First, it will determine weather it is allowed to set activity
     * if it does, set activity, if it doesn't, do nothing.
     * @param activity This is an object of Activity
     */
    public void trySetActivity(Activity activity) {
        //check every blocks in the schedule table.
        for (int i = 0; i < scheduleTable.length; i++) {
            for (int j = 0; j < scheduleTable[i].length; j++) {
                ScheduleItem scheduleItem = scheduleTable[i][j];
                // check if it allowed to set the activity in this block
                if (scheduleItem.canSetActivity(activity)) {
                    tryClearActivity(activity);
                    scheduleItem.setActivity(activity);
                    playSound();
                    return;
                }
            }
        }
    }
    
    /**
     * This is a method used to
     */
    private void tryClearActivity(Activity activity) {
        for (int i = 0; i < scheduleTable.length; i++) {
            for (int j = 0; j < scheduleTable[i].length; j++) {
                ScheduleItem scheduleItem = scheduleTable[i][j];
                if (scheduleItem.getActivity() == activity) {
                    scheduleItem.clearActivity();
                    return;
                }
            }
        }
    }
    
    /**
     * This is a method used to add the activity based o the mouse location
     * If the mouse's location is in the central part of the whole block, the
     * activity will be added.
     */
    private void initSelection() {
        int borderX = 10;
        int borderY = 15;
        int stage = this.mainWorld.getStage();
        for (int i = 0; i < Constants.activityNames[stage].length; i++) {
            int offSetX = i % 2;
            int offSetY = i / 2;
            
            int x = LIST_ITEM_X0 + offSetX * (DEFAULT_ITEM_WIDTH + borderX);
            int y = LIST_ITEM_Y0 + offSetY * (DEFAULT_ITEM_HEIGHT + borderY);
            
            ArrayList<Activity> activities = (ArrayList<Activity>) getObjectsAt(x, y, Activity.class);
            
            String name = Constants.activityNames[stage][i];
            int[] points = Constants.activityPoints[stage][i];
            
            if (activities.size() == 0) {
                addObject(new Activity(name, points), x, y);
                addObject(new Activity(name, points), x, y);
            }
            else if (activities.size() == 1) {
                addObject(new Activity(name, points), x, y);
            }
        }
    }
    
    /**
     * This is a method to return the schedule table
     * @return ScheduleItem[][] the table with the schesuleItem
     */
    private ScheduleItem[][] initScheduleTable() {
        int borderX = -1;
        int borderY = 3;
        ScheduleItem[][] table = new ScheduleItem[4][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = new ScheduleItem(SCHEDULE_ITEM_X0 + i * (DEFAULT_ITEM_WIDTH + borderX), SCHEDULE_ITEM_Y0 + j * (DEFAULT_ITEM_HEIGHT + borderY));
            }
        }
        return table;
    }
    
    /**
     * This is a method to determine weather can finish the scheduleTable
     * @return boolean True if the scheduleTable is full of activities,
     * false otherwise
     */
    private boolean canFinish() {
        for (int i = 0; i < scheduleTable.length; i++) {
            for (int j = 0; j < scheduleTable[i].length; j++) {
                ScheduleItem scheduleItem = scheduleTable[i][j];
                if (scheduleItem.getActivity() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Start playing sound if there is sound
     */
    public void playSound() {
        soundIndex++;
        if (soundIndex > (sounds.length - 1)) {
            soundIndex = 0;
        }
        sounds[soundIndex].play();
    }
}
