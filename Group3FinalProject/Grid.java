import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid extends Actor
{
    public Grid() {
        GreenfootImage grid = new GreenfootImage(500, 340);
        grid.setColor(Color.BLACK);
        grid.drawLine(0, 0, 480, 0);
        grid.drawLine(0, 50, 480, 50);
        grid.drawLine(0, 140, 480, 140);
        grid.drawLine(0, 230, 480, 230);
        grid.drawLine(0, 320, 480, 320);
        
        grid.drawLine(0, 0, 0, 320);
        grid.drawLine(120, 0, 120, 320);
        grid.drawLine(240, 0, 240, 320);
        grid.drawLine(360, 0, 360, 320);
        grid.drawLine(480, 0, 480, 320);
        setImage(grid);
    }
    /**
     * Act - do whatever the Grid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
