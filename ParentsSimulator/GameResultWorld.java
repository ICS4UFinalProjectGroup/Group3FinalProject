import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The result world shows player whether they are successful in finishing the game or not. Tells the player how many points they earn
 * 
 * @Yuxin Li (your name) 
 * @version Jan 2023(a version number or a date)
 */
public class GameResultWorld extends World
{
    private String statAffected1;
    private String statAffected2;
    private int resultPoints;
    private int totalTime;
    private boolean onTime;
    private Color transparent = new Color(0,0,0,0);
    private GreenfootImage background = new GreenfootImage("confetti.png");
    private MainWorld mainWorld;
    private int waitTime=60;
    private FlashingText backText = new FlashingText(new GreenfootImage("goBackImage.png"));
    
    private GreenfootSound sound;
    /**
     * Show the player the results of the flip card game
     * @param points points earned by player
     * @param timeTaken time used in the game
     * @param success whether the player remove all cards or not
     * @param mainWorld the main player world that the player will go back to after the game
     * @param stat1 the first stat that game will contribute to
     * @param stat2 the second stat that the game will contribute to
     */
    public GameResultWorld(int points, int timeTaken, boolean success, MainWorld mainWorld, String stat1, String stat2)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        this.mainWorld = mainWorld;
        resultPoints = points;
        totalTime = timeTaken;
        onTime = success;
        statAffected1 = stat1;
        statAffected2 = stat2;
        
        setBackground(background);
        addObject(backText, 512, 520);
        if(onTime){
            GreenfootImage isSuccessful=new GreenfootImage("Congratulations! You finished the game in "+ totalTime +" sec!", 30, Color.BLACK, transparent);  
            GreenfootImage displayPoints=new GreenfootImage("You get "+ resultPoints +" points.", 50, Color.BLACK, transparent);
            getBackground().drawImage(isSuccessful, 200, 150);
            getBackground().drawImage(displayPoints, 330, 200);
            
            Constants.successSound.play();
        }
        else{
            GreenfootImage isSuccessful=new GreenfootImage("Oops! Time is up!", 30, Color.BLACK, transparent);  
            GreenfootImage displayPoints=new GreenfootImage("You get "+ resultPoints +" points.", 50, Color.BLACK, transparent);
            getBackground().drawImage(isSuccessful, 400, 150);
            getBackground().drawImage(displayPoints, 330, 200);
            
            Constants.failSound.play();
        }
        
        if(Constants.memorySound.isPlaying()) {
            sound = Constants.memorySound;
        }
        else {
            sound = Constants.pixelSound;
        }
    }
    
    public void act() {
        //go back to the main world and set the stats
        waitTime--;
        if ((Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(backText)) && waitTime <= 0) {
            this.mainWorld.addPoint(statAffected1, resultPoints/2);
            this.mainWorld.addPoint(statAffected2, resultPoints-resultPoints/2);
            Constants.pixelSound.stop();
            Constants.memorySound.stop();
            Greenfoot.setWorld(mainWorld);
            Constants.backgroundSound.playLoop();
        }
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        sound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        sound.pause();
    }
}
