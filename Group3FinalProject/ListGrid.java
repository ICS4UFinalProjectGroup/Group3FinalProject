import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ListGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListGrid extends Actor
{
    public ListGrid(int num) {
        GreenfootImage grid = new GreenfootImage(130, 90*num + 10);
        grid.setColor(Color.BLACK);
        for (int i = 0; i <= num; i++) {
            grid.drawLine(0, i * 90, 120, i * 90);
        }
        grid.drawLine(0, 0, 0, num * 90);
        grid.drawLine(120, 0, 120, num * 90);
        setImage(grid);
    }
    /**
     * Act - do whatever the ListGrid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
