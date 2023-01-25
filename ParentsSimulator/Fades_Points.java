import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fades_Points here.
 * 
 * @author Yuxin Li  
 * @version Jan 2023
 */
public class Fades_Points extends Flashing_Text
{
    
    /**
     * Act - do whatever the Fades_Points wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Fades_Points(GreenfootImage text){
        super(text);
    }
    public void act()
    {
        // Add your action code here.
        add_points_effect();
        if(getImage().getTransparency()==0){
            getWorld().removeObject(this);
        }
    }
    
    /**
     * the transparency decreases
     */
    public void add_points_effect(){
        getImage().setTransparency(getImage().getTransparency()-5);
    }
}
