import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This program runs the pixel art minigame.
 * 
 * @author Gloria Chan
 * @version !! DATE !!
 * CREDIT: Mr. Cohen for his Timer class.
 */
public class PixelArtWorld extends World
{
    // Sets up timer and time tracking
    private int secondsElapsed;
    private int maxTime;
    private int points;
    
    private PointDisplayer pointDisplay = new PointDisplayer(0);
    private Timer timer;
    
    private int type = Greenfoot.getRandomNumber(2);
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
    private boolean tempForColourable;
    
    private Color selectedCol;
    
    private int[][] pixelArtGrid = new int [14][14];
    private Color[] colours = new Color [6];
    
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
    
    
    /** Type 1 = Cow; type 2 = Cat; type 3 = giraffe;
    private int type = Greenfoot.getRandomNumber(3);
    This can be randomized in the World that generates minigames.
    **/
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PixelArtWorld(MainWorld mainWorld)
    {    
        // Create a world with 1000x700 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        main = mainWorld;
        
        // Add timer
        maxTime = 90;
        timer = new Timer(75);
        startTimer();
        addObject(timer, 195, 85);
        points = 0;
        setBackground(background);
        
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
        
        if(maxTime-getTimeInSeconds()>0){
            endTimer();
            timer.setDisplayer(maxTime-getTimeInSeconds());
        }
        if(getTimeInSeconds()>= maxTime) {
            Greenfoot.setWorld(new WinScreen(points, getTimeInSeconds(), false, main));
        }
        
        // not sure how you have points set up, but if you want to show it on the screen I also use the Score class for that (can see it in Chessboard act())
        finished = returnCompletion();
        if (finished)
        {
            if (getTimeInSeconds() <= 60) // Less than or equal to 60 s to complete = 
            {
                points = 12;
                Greenfoot.setWorld(new Game_Result_World(points, secondsElapsed, true, main, "EQ", "Creativity"));
            }
            else if (getTimeInSeconds() >= 61 && getTimeInSeconds() <= 70)
            {
                points = 6;
                Greenfoot.setWorld(new Game_Result_World(points, secondsElapsed, true, main, "EQ", "Creativity"));
            }
            else
            {
                points = 2;
                Greenfoot.setWorld(new Game_Result_World(points, secondsElapsed, true, main, "EQ", "Creativity"));
            }
        }
    }
    
    // Makes a numbered grid (2D array) with numbers that the player must fill in.
    // Each grid is filled with different values (depending on the art).
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
    
    private void makeColourBar(int numColours)
    {
        for (int i = 0; i < numColours; i++)
        {
            ColorBar bar = new ColorBar(32, colours[i], i + 1);
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
    
    // Generates bar full of the colours that the player must choose from to colour in the pixel art.
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
    
    private Color[] returnColourList()
    {
        return colours;
    }
    
    public Color returnColour()
    {
        return selectedCol;
    }
    
    private boolean returnCompletion()
    {
        ArrayList <ColorBlock> cbArray = (ArrayList <ColorBlock>) getObjects(ColorBlock.class);
        if (finished == false)
        {
            for (ColorBlock cb : cbArray)
            {
                // If colourable is true, finished is false. 
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
    
    // Mr.Cohen's timer class
    /**
     * A very simply Timer class that functions as a virtual stopwatch.
     * 
     * This can be used as a semi-accurate method of measuring the elapsed time
     * while some code is running. It can be used as a timer in a game, or to
     * track the efficiency of some procedure. Methods for stop, start and reset
     * allow easy control of Timer objects. Methods are included that return 
     * seconds (as an int), milliseconds (as a float) or a formatted String.
     * 
     * @author Jordan Cohen
     * @version v1.0.2
     */
    private long startTime;
    private long endTime;

    /**
     * Start the Timer
     */
    public void startTimer()
    {
        startTime = System.nanoTime();
    }

    /**
     * Stop the Timer
     */
    public void endTimer ()
    {
        endTime = System.nanoTime();
    }

    /**
     * Reset the Timer
     */
    public void resetTimer ()
    {
        startTime = 0;
        endTime = 0;
    }

    /**
     * Returns elapsed time as a neatly formatted String. Most practical for
     * applications where output (rather than calculation) is the goal. The
     * exact format will depend on the time elapsed - either ms, sec, or min:sec.
     * 
     * @return String neatly formatted display of time elapsed
     */
    public String getTimeString ()
    {
        if ((endTime - startTime) < 1000000)
        {
            return (endTime - startTime) + "ns";
        }
        // Less than 1 second
        if ((endTime - startTime)/1000000000 < 1)
        {
            return getTimeInMilliseconds() + " ms";
        }
        else if ((endTime - startTime)/1000000000 < 60)
        {
            return getTimeInPreciseSeconds() + " sec";
        }
        
        int minutes = getTimeInSeconds() / 60;
        float seconds = getTimeInPreciseSeconds() - ((float)minutes * 60);
        return minutes + " min " + seconds + " sec";
    }
    
    /**
     * Return the elapsed time in seconds. This assumes that the timer has already
     * been started and stopped (but not reset). For very short durations, this will
     * return zero even though some time has elapsed.
     * 
     * @return int  The number of seconds elapsed, as an int.
     */
    public int getTimeInSeconds ()
    {
        return (int)((double)(endTime - startTime) / 1000000000.0);
    }
    
    /**
     * Return the elapsed time in seconds. This assumes that the timer has already
     * been started and stopped (but not reset). For very short durations, this will
     * return zero even though some time has elapsed.
     * 
     * @return float  The number of seconds elapsed, as an int.
     */
    public float getTimeInPreciseSeconds ()
    {
        return (float)((double)(endTime - startTime) / 1000000000.0);
    }

    /**
     * Return the elapsed time in seconds. This assumes that the timer has already
     * been started and stopped (but not reset). This will return the value as a 
     * float and is most useful for shorter durations where second is not accurate
     * enough.
     * 
     * @return float  The number of milliseconds elapsed, as a float.
     */
    public float getTimeInMilliseconds ()
    {
        return (float)((double)(endTime - startTime) / 1000000.0);
    }
}

