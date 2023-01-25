import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FadesPoints here.
 * 
 * @author Yuxin Li  
 * @version Jan 2023
 */
public class FadesPoints extends FlashingText
{
    
    /**
     * Act - do whatever the FadesPoints wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public FadesPoints(GreenfootImage text){
        super(text);
    }
    public void act()
    {
        // Add your action code here.
        addPointsEffect();
        if(getImage().getTransparency()==0){
            getWorld().removeObject(this);
        }
    }
    
    /**
     * the transparency decreases
     */
    public void addPointsEffect(){
        getImage().setTransparency(getImage().getTransparency()-5);
    }
}
