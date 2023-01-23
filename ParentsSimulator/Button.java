import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class Button extends Actor
{
    GreenfootImage image;

    /**
     * Constractor
     */
    public Button(String file) {
        this.image = new GreenfootImage(file);
        setImage(this.image);
    }

    public Button(GreenfootImage image) {
        this.image = image;
        setImage(this.image);
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
