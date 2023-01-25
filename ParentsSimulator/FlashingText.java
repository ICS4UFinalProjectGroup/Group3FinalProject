import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Add a text image to create a blinking effect
 * 
 * @Yuxin Li  
 * @version Jan 2023
 */
public class FlashingText extends Actor
{
    private GreenfootImage textImage;
    private int time = 3;
    private boolean flash = true;
    
    /**
     * constructor for the FlashingText
     * @param text the text that will blink 
     */
    public FlashingText(GreenfootImage text){
        textImage = text;
        setImage(textImage);
    }
    
    public void act()
    {
        // Add your action code here.
        time--;
        int curRransparency=getImage().getTransparency();
        if(flash){
            if(time == 0){
                getImage().setTransparency(curRransparency -= 5);
                time = 3;
            }
            if(getImage().getTransparency() == 150){
                flash=false;
            }
        }
        else{
            if(time == 0){
                getImage().setTransparency(curRransparency += 5);
                time = 3;
            }
            if(getImage().getTransparency() == 255){
                flash = true;
            }
        }
    }
}
