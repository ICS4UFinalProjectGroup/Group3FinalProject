import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ColorBar here.
 * 
 * @author Gloria Chan
 * @version !! DATE !!
 */
public class ColorBar extends PixelArtTools
{
    public ColorBar(int size, Color colour, int num)
    {
        GreenfootImage colorBar = new GreenfootImage(size, size);
        colorBar.setColor(colour);
        colorBar.fillRect(0, 0, size, size);
        if (colour.equals(Color.BLACK))
        {
            colorBar.setColor(Color.WHITE);
        }
        else
        {
            colorBar.setColor(Color.BLACK);
        }
        String text = String.valueOf(num);
        colorBar.drawString(text, size/2, size/2);
        setImage(colorBar);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
