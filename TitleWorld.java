import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the game title and homescreen along with a "Play" button to start the game.
 * 
 * @author Gloria Chan
 * @version: January 24, 2023
 * 
 * CREDIT: Background image from: https://www.pinterest.ca/pin/18366310973098552/
 * */
public class TitleWorld extends World
{
    private GreenfootImage titleBG;
    private GreenfootImage playImage = new GreenfootImage("playButton.png");
    private Button playButton;
    
    /**
     * Sets up the background image and adds a "Play" button.
     * 
     */
    public TitleWorld()
    {    
        super(1000, 700, 1); 
        titleBG = new GreenfootImage("titleScreenBG.png");
        setBackground(titleBG);
        playButton = new Button(playImage);
        addObject(playButton, 800, 600);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(playButton))
        {
            this.playButton.playSound();
            Greenfoot.setWorld(new StoryWorld());
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
