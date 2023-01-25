import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Card has different images and names that can be flipped and removed by
 * finding matching cards
 * 
 * @Yuxin Li  
 * @version Jan 2023
 */
public class Card extends Actor
{
    /**
     * Act - do whatever the card wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage animal;
    private static GreenfootImage cover = new GreenfootImage("card_cover.png");
    private String name;
    private boolean faceUp;
    private static int upNumber;
    private static Card first = null;
    private static Card second = null;
    
    private static GreenfootSound[] sounds = {
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav"),
        new GreenfootSound("click.wav")
    };
    private int soundNum;
    private int soundIndex;
    
    /**
     * each card will have a cover, the card will show its picture if clicked
     */
    public Card(String name){
        setImage(cover);
        animal = new GreenfootImage(name+".png");
        this.name = name;
        faceUp = true;
        
        this.soundNum = sounds.length;
        this.soundIndex = 0;
    }
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this) && upNumber < 2){
            setImage(animal);
            upNumber++;
            if(upNumber == 1){
                first=this;
            }
            if(upNumber == 2 && this != first){
                second=this;
            }
            else if(upNumber==2 && this == first){
                upNumber=1;
            }
        }
        
        if(Greenfoot.mouseClicked(this)) {
            playSound();
        }
    }
    
    /**
     * show the name of the card
     * @return String the card name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Flip the card back by adding the cover
     */
    public void flipBack(){
        setImage(cover);
    }
    
    /**
     * get how many cards are flipped 
     * @return int the number of flipped cards
     */
    public static int getUpNumber(){
        return upNumber;
    }
    
    /**
     * set upNumber to 0
     */
    public static void setUpNumber(){
        upNumber=0;
    }
    
    /**
     * get the first card being flipped
     * @return Card the first card being flipped
     */
    public static Card getFirst(){
        return first;
    }
    
    /**
     * set the first card to null
     */
    public static void setFirst(){
        first=null;
    }
    
    /**
     * get the second card being flipped
     * @return Card the second card being flipped
     */
    public static Card getSecond(){
        return second;
    }
    
    /**
     * set the second card to null
     */    
    public static void setSecond(){
        second=null;
    }
    
    /**
     * Start playing sound if there is sound
     */
    public void playSound() {
        soundIndex++;
        if (soundIndex > (sounds.length - 1)) {
            soundIndex = 0;
        }
        sounds[soundIndex].play();
    }
    
    /**
     * Pause playing sound if there is sound
     */
    public void pauseSound() {
        sounds[soundIndex].pause();
    }
    
    /**
     * Method to determine weather sound is playing.
     * @return boolean True if the sound is playing, False otherwise.
     */
    public boolean isSoundPlaying () {
        return sounds[soundIndex].isPlaying();
    }
    
    /**
     * Method to get the sound in specific index.
     * @return GreenfootSound the greenfoot sound
     */
    public GreenfootSound getSound (){
        return sounds[soundIndex];
    }
}
