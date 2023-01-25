import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Arrow is a class the players can click to flip page
 * 
 * @Yuxin Li 
 * @version Jan 2023
 */
public abstract class Arrow extends Actor
{
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected StoryWorld storyWorld;
    
    private static GreenfootSound[] sounds = {
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
    };
    private int soundNum;
    private int soundIndex;
    
    /**
     * constructor for arrow
     */
    public Arrow(){
        this.soundNum = sounds.length;
        this.soundIndex = 0;
    }
    
    /**
     * the method can be called to flip page
     */
    public void flipPage(){
        storyWorld.setStory();
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            playSound();
        }
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
    
    /**
     * Pause playing sound if there is sound
     */
    public void pauseSound() {
        sounds[soundIndex].pause();
    }
    
    /**
     * Method to determine weather sound is playing.
     * @return boolean True if the sound is playing, False otherwise.
     */
    public boolean isSoundPlaying () {
        return sounds[soundIndex].isPlaying();
    }
    
    /**
     * Method to get the sound in specific index.
     * @return GreenfootSound the greenfoot sound
     */
    public GreenfootSound getSound (){
        return sounds[soundIndex];
    }
}
