import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game_Result_World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game_Result_World extends World
{

    /**
     * Constructor for objects of class Game_Result_World.
     * 
     */
    private int result_points;
    private int total_time;
    private boolean on_time;
    private Color transparent = new Color(0,0,0,0);
    private MainWorld main;
    public Game_Result_World(int points, int time_taken, boolean success, MainWorld mainWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1); 
        main=mainWorld;
        result_points=points;
        total_time=time_taken;
        on_time=success;
        
        if(on_time){
            GreenfootImage isSuccessful=new GreenfootImage("Congratulations! You finished the game in "+ total_time +" sec!", 30, Color.BLACK, transparent);  
            GreenfootImage displayPoints=new GreenfootImage("You get "+ result_points +" points.", 50, Color.BLACK, transparent);
            getBackground().drawImage(isSuccessful, 200, 200);
            getBackground().drawImage(displayPoints, 320, 300);
        }
        else{
            GreenfootImage isSuccessful=new GreenfootImage("Oops! Time is up!", 30, Color.BLACK, transparent);  
            GreenfootImage displayPoints=new GreenfootImage("You get "+ result_points +" points.", 50, Color.BLACK, transparent);
            getBackground().drawImage(isSuccessful, 400, 200);
            getBackground().drawImage(displayPoints, 320, 300);
        }
    }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Stats_Board stats=main.returnStats();
            stats.addPoints("Memory", result_points/2);
            stats.addPoints("Creativity", result_points-result_points/2);
            Greenfoot.setWorld(main);
            
        }
    }
}
