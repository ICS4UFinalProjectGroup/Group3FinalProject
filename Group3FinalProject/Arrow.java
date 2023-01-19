import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @Yuxin  (your name) 
 * @version (a version number or a date)
 */
public abstract class Arrow extends Actor
{
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected Story_World storyWorld;
    public Arrow(){
        
    }
    
    public void flipPage(){
        storyWorld.setStory();
    }
}
