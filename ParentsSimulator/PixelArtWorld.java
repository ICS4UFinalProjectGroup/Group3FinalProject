import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This program runs the pixel art minigame.
 * 
 * CREDIT: Jordan Cohen for returnTimeInSeconds() method (found in Timer class).
 * 
 * @author Gloria Chan
 * @version January 18, 2023
 */
public class PixelArtWorld extends World
{
    // Sets up timer and time tracking
    private long startTime;
    private long endTime;
    private int maxTime = 75;
    private int secondsElapsed;
    private TimeDisplayer timer = new TimeDisplayer(75, 35);
    
    // Sets up point tracking
    private int points;
    private PointDisplayer pointDisplay = new PointDisplayer(0);
    
    // Randomizes pixel art
    private GreenfootImage background = new GreenfootImage("pixelArtBG.png");
    private MainWorld main;
    
    // Pixel art colours (RGB values)
    private static Color lightBlue = new Color(199, 249, 255); //c7f9ff
    private static Color brown = new Color (121, 85, 72); //795548
    private static Color darkGrey = new Color (158, 158, 158); //9e9e9e
    private static Color deepPink = new Color (255, 205, 210); //ffcdd2
    private static Color lightGrey = new Color (242, 242, 242); //f2f2f2
    private static Color darkPink = new Color (239, 154, 154); //ef9a9a
    private static Color black = new Color (0, 0, 0); //000000
    private static Color yellow = new Color (255, 193, 7); //ffc107
    private static Color darkYellow = new Color (217, 164, 4); //d9a404
    private static Color peach = new Color (255, 234, 199); //ffeac7
    private static Color darkestYellow = new Color (163, 123, 3); //a37b03
    private static Color lightPink = new Color (255, 205, 210); //ffcdd2
    
    private boolean finished; // Checks if  drawing is coloured in correctly.
    
    private Color selectedCol;
    
    private int[][] pixelArtGrid = new int [14][14];
    private Color[] colours = new Color [6];
    
    // Draws out a cow
    private int[][] pixelArtGrid0 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1},
        {1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1},
        {1, 3, 3, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 1},
        {1, 3, 3, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 1},
        {1, 3, 3, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 1},
        {1, 1, 4, 5, 5, 5, 5, 5, 5, 5, 3, 3, 4, 1, 1},
        {1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1},
        {1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1},
        {1, 1, 1, 5, 5, 7, 5, 5, 5, 7, 5, 5, 1, 1, 1},
        {1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 1},
        {1, 1, 4, 4, 4, 6, 4, 4, 4, 6, 4, 4, 4, 1, 1},
        {1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    }; 
    // Draws out a cat
    private int[][] pixelArtGrid1 = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1},
        {1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1},
        {1, 1, 2, 3, 3, 4, 5, 4, 5, 4, 3, 3, 2, 1, 1},
        {1, 1, 4, 4, 4, 4, 5, 4, 5, 4, 4, 4, 4, 1, 1},
        {1, 1, 2, 4, 4, 4, 5, 4, 5, 4, 4, 2, 2, 1, 1},
        {1, 1, 2, 4, 4, 4, 5, 4, 5, 4, 4, 2, 2, 1, 1},
        {1, 1, 2, 4, 4, 4, 5, 4, 5, 4, 4, 4, 4, 1, 1},
        {1, 1, 4, 4, 6, 4, 4, 4, 4, 4, 6, 4, 4, 1, 1},
        {1, 1, 4, 2, 2, 4, 7, 7, 7, 4, 2, 2, 4, 1, 1},
        {1, 1, 4, 4, 4, 4, 4, 7, 4, 4, 4, 4, 4, 1, 1},
        {1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };
    private Color[] colours0 = {
         lightBlue, brown, darkGrey, deepPink, lightGrey, darkPink, black
    };
    private Color[] colours1 = {
        lightBlue, yellow, darkYellow, peach, darkestYellow, black, lightPink
    };
    
    /**
     * Starts timer to track user play time and generates a random pixel art for the user
     * to complete. Initalizes the pixel art grid and the colour bars.
     * 
     */
    public PixelArtWorld(MainWorld mainWorld)
    {    
        // Create a world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        main = mainWorld;
        addObject(timer, 200, 85);

        startTime = System.nanoTime();
        secondsElapsed = 0;
        points = 0;
        setBackground(background);
        
        int type = Greenfoot.getRandomNumber(2);
        finished = false;
        // Integer that randomizes the minigame's art.
        // 0 = Cow; 1 = Cat
        if (type == 0)
        {
            // Draws out a cow.
            pixelArtGrid = pixelArtGrid0;
            colours = colours0;
        }
        else if (type == 1)
        {
            // Draws out a cat.
            pixelArtGrid = pixelArtGrid1;
            colours = colours1;
        }
        
        selectedCol = Color.WHITE;
        
        makeGrid(525,525); // 40 x 40 cells in the grid
        addColors();
        makeColourBar(7);

        Constants.pixelSound.playLoop();
    }

    public void act()
    {
        changeColours();
        endTime = System.nanoTime();
        
        secondsElapsed = returnTimeInSeconds();
        timer.setDisplayer(maxTime - secondsElapsed);
        
        finished = returnCompletion();
        if (finished)
        {
            if (secondsElapsed <= 60) // Less than or equal to 60 s to complete = Win + 12 pts
            {
                points = 12;
                Greenfoot.setWorld(new GameResultWorld(points, secondsElapsed, true, main, "EQ", "Creativity"));
            }
            else if (secondsElapsed >= 61 && secondsElapsed <= 70) // 61 s to 70 s to complete = Win + 6 pts
            {
                points = 6;
                Greenfoot.setWorld(new GameResultWorld(points, secondsElapsed, true, main, "EQ", "Creativity"));
            }
            else // More than 70 s to complete = 2 points
            {
                points = 2;
                Greenfoot.setWorld(new GameResultWorld(points, secondsElapsed, true, main, "EQ", "Creativity"));
            }
        }
        
        if (!finished && secondsElapsed == maxTime) // Didn't complete the pixel art in time = Lose
        {
            points = 0;
            Greenfoot.setWorld(new GameResultWorld(points, secondsElapsed, false, main, "EQ", "Creativity"));
        }
    }
    
    /**
     * Method that makes a numbered grid (2D array) with numbers that the player must fill in.
     * Each grid is filled with different values (depending on the art).
     */
    private void makeGrid(int length, int height)
    {
        int p = length / 15; // Dimensions of each cell in the grid.
        int x = 417; // Amount of room left for colour box.
        int y = (700 - length)/2; // Makes sure that the grid is in the centre of the World.
        
        GreenfootImage c = new GreenfootImage (2, height);
        GreenfootImage r = new GreenfootImage (length, 2);
        c.setColor(Color.GRAY);
        r.setColor(Color.GRAY);
        c.fillRect(0, 0, 1, height);
        r.fillRect(0, 0, length, 1);
        for (int i = 0; i < 16; i++)
        {
            getBackground().drawImage(c, x + i*p, y);
            getBackground().drawImage(r, x, y + i*p);
        }
    }
    
    /**
     * Method that adds boxes to represent the colours of the pixel art (its corresponding number is also displayed).
     */
    private void makeColourBar(int numColours)
    {
        for (int i = 0; i < numColours; i++)
        {
            ColorDisplay bar = new ColorDisplay(32, colours[i], i + 1);
            int x;
            int y;
            if (i % 2 == 0)
            {
                x = 108 + 31*i;
                y = 285;
                addObject(bar, x, y);
            }
            else
            {
                x = 102 + 32*i;
                y = 338;
                addObject(bar, x, y);
            }
        }
    }
    /**
     * Method that adds boxes with no colour to the grid (players must click on these to colour them in). 
     */
    private void addColors()
    {
        // Adds in Color Actors.
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                ColorBlock cb = new ColorBlock(33, pixelArtGrid[i][j], colours[pixelArtGrid[i][j] - 1], Color.WHITE);
                int x = 400 + 35*(j+1);
                int y = 70 + 35*(i+1);
                addObject(cb, x, y);
            }
        }
    }
    
    /**
     * Method that allows users to change their painting colour by pressing on specific number keys.
     */
    private void changeColours()
    {
        if(Greenfoot.isKeyDown("1")){
           selectedCol = colours[0];  
        }
        if(Greenfoot.isKeyDown("2")){
           selectedCol = colours[1];      
        }
        if(Greenfoot.isKeyDown("3")){
           selectedCol = colours[2];      
        }
        if(Greenfoot.isKeyDown("4")){
           selectedCol = colours[3];      
        }
        if(Greenfoot.isKeyDown("5")){
           selectedCol = colours[4];      
        }
        if(Greenfoot.isKeyDown("6")){
           selectedCol = colours[5];      
        }
        if(Greenfoot.isKeyDown("7")){
           selectedCol = colours[6];      
        }
        if(Greenfoot.isKeyDown("8")){
           selectedCol = colours[7];      
        }
    }
    
    /**
     * Method that returns the colour that the player has selected to paint with.
     */
    public Color returnColour()
    {
        return selectedCol;
    }
    
    /**
     * Method that returns the time in seconds.
     */
    private int returnTimeInSeconds()
    {
       return (int)((double)(endTime - startTime) / 1000000000.0); 
    }
    
    /**
     * Methodd that checks to see whether the user is completed the pixel art correctly or not.
     */
    private boolean returnCompletion()
    {
        ArrayList <ColorBlock> cbArray = (ArrayList <ColorBlock>) getObjects(ColorBlock.class);
        if (finished == false)
        {
            for (ColorBlock cb : cbArray)
            {
                // If colourable is true, finished is false. 
                // That means that there is still a block that needs to be coloured in.
                if (cb.checkColour()){
                    finished = false;
                    return false;
                }
            }
            finished = true;
        }
        return finished;
    }

    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Constants.pixelSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        Constants.pixelSound.pause();
    }
}
