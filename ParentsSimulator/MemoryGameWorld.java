import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;

/**
 * Memory game world is the world for the flip card game, it allows player to click 2 cards at the same time and check if the cards have the 
 * picture. If the 2 cards have different pictures, the cards will be flipped back. If the 2 cards have same pictures, the cards will 
 * be removed. The player's goal is to remove all pairs. 
 * 
 * @Yuxin Li 
 * @version Jan 2023
 * 
 * Animal pictures by Naomi Lord
 * 
 * card cover from:
 * https://www.google.com/url?sa=i&url=http%3A%2F%2Frojgaraurnirman.in%2Fnotes.asp%3Fiid%3D85854742-cute%2Bbackground%2Bwallpaper%26cid%3D5&psig=AOvVaw2-48CrC9AafUW-Axk9iiiA&ust=1674583595198000&source=images&cd=vfe&ved=0CBEQjhxqFwoTCNCeq5Sk3vwCFQAAAAAdAAAAABAM
 */
public class MemoryGameWorld extends World
{
    private GreenfootImage background = new GreenfootImage("memory_intro.jpg");
    private ArrayList<String> allCards = new ArrayList<String>();
    private Card[][] cards;
    private int level;
    private int lSpacing = 840/6;
    private int wSpacing = 550/4;
    private Card firstCard;
    private Card secondCard;
    private int waittime;
    private TimeDisplayer timeDisplay = new TimeDisplayer(60);
    private PointDisplayer pointDisplay = new PointDisplayer(0);
    private long startTime;
    private long endTime;
    private int points;
    private MainWorld main;
    
    private GreenfootSound matchSound;
    /**
     * Constructor for the memory game. Add and shuffle the cards when the world is initialized. 
     * Start the count down timer and the point displayer
     * 
     * @param mainWorld the main player world that the player will go back to after the game
     */
    public MemoryGameWorld(MainWorld mainWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        main = mainWorld;
        setBackground(background);
        for(int i=0; i<2; i++){
            allCards.add("bunny");
            allCards.add("cheetah");
            allCards.add("duck");
            allCards.add("fox");
            allCards.add("penguin");
            allCards.add("bear");
            allCards.add("owl");
            allCards.add("lion");
            allCards.add("bull");
            allCards.add("panda");
            allCards.add("pig");
            allCards.add("giraffe");
        }
        // shuffle the cards
        Collections.shuffle(allCards);
        //add the cards to the 2D array and calculate the position
        cards = new Card[4][6];
        int index = 0;
        for(int i = 0; i<cards.length; i++){
            for(int j = 0; j<cards[i].length; j++){
                cards[i][j] = new Card(allCards.get(index));
                index++;
                addObject(cards[i][j],150+j*lSpacing,150+i*wSpacing);
            }
        }
        waittime = 30;
        addObject(timeDisplay, 200, 50);
        addObject(pointDisplay, 800, 50);
        startTime = System.nanoTime();
        points = 0;
        
        matchSound = new GreenfootSound("memoryCard.wav");
    }
    
    public void act(){
        //first and second card are static variables stored in Card class
        firstCard = Card.getFirst();
        secondCard = Card.getSecond();
        if(firstCard != null && secondCard != null){
            if((firstCard.getName()).equals(secondCard.getName())){
                //remove the cards and reset the first flip and second flip
                countDown();
                if(waittime == 0){
                    matchSound.play();
                    removeObject(firstCard);
                    removeObject(secondCard);
                    firstCard = null;
                    secondCard = null;
                    waittime = 30;
                    Card.setUpNumber();
                    Card.setFirst();
                    Card.setSecond();
                    points++;
                }
            }
            else{
                //flip cards back after half a sec
                countDown();
                if(waittime == 0){
                    firstCard.flipBack();
                    secondCard.flipBack();
                    firstCard = null;
                    secondCard = null;
                    waittime = 30;
                    Card.setUpNumber();
                    Card.setFirst();
                    Card.setSecond();
                } 
            }
            
        }
        //update the timer
        if(60-getTimeInSeconds() > 0){
            endTime=System.nanoTime();
            timeDisplay.setDisplayer(60-getTimeInSeconds());
        }
        //update the points
        pointDisplay.setDisplayer(points);
        //go to the result world if the player gets all pair or time runs ou
        if(points == 12 && getTimeInSeconds() < 60){
            Greenfoot.setWorld(new GameResultWorld(points, getTimeInSeconds(), true, main, "Memory", "Creativity"));
        }
        if(getTimeInSeconds() == 60){
            Greenfoot.setWorld(new GameResultWorld(points, getTimeInSeconds(), false, main, "Memory", "Creativity"));
        }
    }
    
    /**
     * start count down if the wait time is above 0
     */
    public void countDown(){
        if(waittime > 0){
            waittime--;
        }
    }
    
    /**
     * check if all cards are removed
     * @return boolean true if there are no cards remain in world, false if there are still cards in world 
     */
    public boolean finished(){
        if(getObjects(Card.class).size() == 0){
            return true;
        }
        return false;
    }
    
    /**
     * calculate the time passed in seconds
     * @return int the time in seconds
     */
    public int getTimeInSeconds ()
    {
        return (int)((double)(endTime - startTime) / 1000000000.0);
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Constants.memorySound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        Constants.memorySound.pause();
    }
}
