import greenfoot.*; 
/**
 * Flip the page forward
 * 
 * @Yuxin Li 
 * @version Jan 2023
 */
public class Forward extends Arrow
{
    /**
     * Act - do whatever the Forward wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Forward(StoryWorld sw){
        GreenfootImage forwardArrow = new GreenfootImage("forward.png");
        setImage(forwardArrow);
        storyWorld = sw;
    }
    public void act()
    {
        // Add your action code here.
        super.act();
        int index=storyWorld.getClickIndex();
        if(Greenfoot.mouseClicked(this) && index < 4){
            storyWorld.setClickIndex(index+1);
            flipPage();
        }
        if(Greenfoot.mouseClicked(this) && index == 4){
            Greenfoot.setWorld(new TutorialWorld());
        }
    }
}
