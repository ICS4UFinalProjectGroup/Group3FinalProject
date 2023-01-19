import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game_Intro_World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game_Intro_World extends World
{

    /**
     * Constructor for objects of class Game_Intro_World.
     * 
     */
    private GreenfootImage background = new GreenfootImage("wallpaper.jpg");
    private GreenfootImage welcomeText;
    private Flashing_Text flashText;
    private GreenfootImage clickImage;
    private MainWorld main; 
    public Game_Intro_World(MainWorld mainWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1);
        main=mainWorld;
        setBackground(background);
        welcomeText=new GreenfootImage("memory_welcome_text.png");
        getBackground().drawImage(welcomeText, 125, 100);
        clickImage=new GreenfootImage("memory_clickText.png");
        flashText=new Flashing_Text(clickImage);
        addObject(flashText, 500, 600);
        
    }
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Memory_Game_World(main));
        }
    }
}
