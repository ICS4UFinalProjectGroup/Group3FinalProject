import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stat extends LabelAbstract
{
    /**
     * Act - do whatever the Stat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String stat_name;
    public Stat(String name, int value){
        this.value=value;
        stat_name=name;
    }
    public void updateImage(){
        GreenfootImage display = new GreenfootImage(stat_name+": "+ getValue(), 30, Color.BLACK, transparent);
        setImage(display);
    }
    public void setStat(int newValue)
    {
        value = newValue;
        updateImage();
    }
}
