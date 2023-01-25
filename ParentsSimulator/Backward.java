import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Flip the story back a page
 * 
 * @Yuxin Li
 * @version Jan 2023
 */
public class Backward extends Arrow
{
    /**
     * Act - do whatever the Backward wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Backward(StoryWorld sw){
        GreenfootImage backwardArrow = new GreenfootImage("backward.png");
        setImage(backwardArrow);
        storyWorld=sw;
    }
    public void act()
    {
        // Add your action code here.
        super.act();
        int index=storyWorld.getClickIndex();
        if(Greenfoot.mouseClicked(this)&&index>=1){
            storyWorld.setClickIndex(index-1);
            flipPage();
        }
    }
}