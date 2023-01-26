import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class constitutes the color boxes in the colour selection box of PixelArtWorld.
 * 
 * @author Gloria Chan
 * @version January 19, 2023
 */
public class ColorBar extends PixelArtTools
{
    /**
     * Constructor for ColorBar class
     * @param size specifications for the color box's size
     * @param colour specifications for the box's colour
     * @param the number that corresponds to the image's colour
     */
    public ColorBar(int size, Color colour, int num)
    {
        GreenfootImage colorBar = new GreenfootImage(size, size);
        colorBar.setColor(colour);
        colorBar.fillRect(0, 0, size, size);
        if (colour.equals(Color.BLACK)) // If the box colour is black, the text should be white
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
