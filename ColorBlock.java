import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pixel here.
 * 
 * @author Gloria Chan
 * @version !! DATE !!
 */
public class ColorBlock extends PixelArtTools
{
    private boolean correct;
    private boolean colourable = true;
    private boolean selected;
    private Color correctColour;
    private Color currColour;
    private Color selColour;
    
    private Color colour;
    private int num;
    private int size;
    //private int[] pos = new int 
    public ColorBlock(int size, int num, Color colour, Color currColour)
    {
        this.num = num;
        this.size = size;
        this.correctColour = colour;
        this.currColour = currColour;
        selected = false;
        
        // Before the use can play, the number (corresponding to the pixel's colour
        // will be displayed)
        GreenfootImage pixel = new GreenfootImage(size, size);
        pixel.setColor(currColour);
        pixel.fillRect(0, 0, size, size);
        pixel.setColor(Color.BLACK);
        String text = String.valueOf(num);
        pixel.drawString(text, size/2, size/2);
        setImage(pixel);
    }
    
    public void act()
    {
        changeColours();
    }
    
    public void changeColours(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        // In order to colour, the space bar must be down.
        if (Greenfoot.isKeyDown("space") && Greenfoot.mouseMoved(this) && colourable)
        {
            // Checks which colour the user selected to colour with.
            PixelArtWorld w = (PixelArtWorld) getWorld();
            Color selColour = w.returnColour();
            
            // If the wrong colour is used to paint the pixel block,
            // the number (which corresponds with the colour) will remain.
            GreenfootImage pixel = getImage();
            pixel.setColor(selColour);
            pixel.fillRect(0, 0, size, size);
            pixel.setColor(Color.BLACK);
            pixel.drawString(String.valueOf(num), size/2, size/2);
            setImage(pixel);
            
            // If the correct colour is used to paint the pixel block,
            // the colour will be locked into place (unable to change the colour).
            if (selColour.equals(correctColour))
            {
                pixel = getImage();
                pixel.setColor(selColour);
                pixel.fillRect(0, 0, size, size);
                setImage(pixel);
                colourable = false;
            }
        }
    }
    
    // If the colour is wrong, or if the block has not been filled.
    // The number (which corresponds with a colour) will still show.
    public boolean checkColour(){
        return colourable;
    }
}
