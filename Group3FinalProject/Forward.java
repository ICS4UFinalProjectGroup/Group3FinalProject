import greenfoot.*; 
/**
 * Write a description of class Forward here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Forward extends Arrow
{
    /**
     * Act - do whatever the Forward wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Forward(Story_World sw){
        storyWorld=sw;
    }
    public void act()
    {
        // Add your action code here.
        int index=storyWorld.getClickIndex();
        if(Greenfoot.mouseClicked(this)&&index<4){
            storyWorld.setClickIndex(index+1);
            flipPage();
        }
        if(Greenfoot.mouseClicked(this)&&index==4){
            Greenfoot.setWorld(new MainWorld());
        
        }
    }
}
