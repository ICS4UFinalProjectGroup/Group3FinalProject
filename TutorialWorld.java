import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Teaches the user everything about the game (and the story behind it).
 * 
 * @author: Gloria Chan
 * @version: January 23, 2023
 * 
 * CREDIT: Yuxin's StoryWorld for reference.
 */
public class TutorialWorld extends World
{
    private GreenfootImage[] tutorialPage = new GreenfootImage[13];
    private int pageNumber;
    
    private GreenfootImage proceedMessage;
    private FlashingText flashingMessage;
    
    /**
     * For every page, there is a corresponding image. The user will be prompted to proceed to
     * the next page by clicking on anywhere on the screen.
     * 
     */
    public TutorialWorld()
    {    
        super(1000, 700, 1); 
        proceedMessage = new GreenfootImage("proceed.png");
        
        flashingMessage = new FlashingText(proceedMessage);
        addObject(flashingMessage, 500, 630);
        
        pageNumber = 0;
        for(int i = 1; i <= 12; i++){
            tutorialPage[i-1]=new GreenfootImage("tutorialPg"+ i +".png");
        }
        setBackground(tutorialPage[pageNumber]);
        
        Constants.backgroundSound.playLoop();
    }
    
    public void act()
    {
        // The user proceeds to the next page everytime the screen is clicked.
        if (Greenfoot.mouseClicked(null))
        {
            pageNumber++;
            setBackground(tutorialPage[pageNumber]);
            if (pageNumber == 12)
            {
                Greenfoot.setWorld(new MainWorld());
            }
        }
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
        Constants.backgroundSound.pause();
    }
}
