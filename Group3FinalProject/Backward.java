import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Backward here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Backward extends Arrow
{
    /**
     * Act - do whatever the Backward wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Backward(Story_World sw){
        storyWorld=sw;
    }
    public void act()
    {
        // Add your action code here.
        int index=storyWorld.getClickIndex();
        if(Greenfoot.mouseClicked(this)&&index>=1){
            storyWorld.setClickIndex(index-1);
            flipPage();
        }
    }
}