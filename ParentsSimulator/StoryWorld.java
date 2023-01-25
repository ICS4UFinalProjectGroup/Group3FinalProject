import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * StoryWorld is an initial world that shows the player and intro story
 * of the game. Players can click the button to flip pages.
 * 
 * @Yuxin Li 
 * @version Jan 2023
 * 
 * get married picture by RapidEye
 * https://www.istockphoto.com/photo/male-and-female-hands-clasped-gm931136214-255235764
 * https://hackspirit.com/differences-between-falling-in-love-and-flowing-in-love/
 * 
 * pregnant picture
 * https://www.madeformums.com/pregnancy/early-pregnancy-tests-are-giving-too-many-false-results/
 * https://www.thehealthy.com/pregnancy/positive-pregnancy-test/
 * 
 * hospital picture
 * https://unsplash.com/s/photos/hospital-room
 * https://wexnermedical.osu.edu/blog/patients-value-control-privacy-in-hospital-rooms
 * 
 * baby pic
 * https://www.peakpx.com/en/hd-wallpaper-desktop-alevu
 * 
 * backgroundMusic
 * Music by <a href="https://pixabay.com/users/23117649-23117649/?utm_source=link-attributi
 * on&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=7741">23117649</a> from
 * <a href="https://pixabay.com//?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_c
 * ampaign=music&amp;utm_content=7741">Pixabay</a>
 * 
 * welcome picture by dpproductions
 * https://www.istockphoto.com/photos/front-door
 * https://abeautifulmess.com/first-things-first-a-pink-front-door/
 * 
 * story block by user2104819
 * https://www.freepik.com/premium-vector/set-ui-elements-2d-games-apps-jungle-game-ui-part-2_4267333.htm
 * 
 * arrows by user22934206
 * https://www.freepik.com/premium-vector/collection-set-wooden-game-ui-frame-template-pop-up-interface-gui-asset-elements_11707777.htm#from_view=detail_alsolike
 */

public class StoryWorld extends World
{
    private GreenfootImage[] backgrounds = new GreenfootImage[5];
    private GreenfootImage[] stories = new GreenfootImage[5];
    private int clickIndex;
    private Arrow forward;
    private Arrow backward;
    /**
     * Story World constructor
     * set the first page of story and add the flip page button
     */
    public StoryWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        for(int i=1; i<=5; i++){
            backgrounds[i-1]=new GreenfootImage("backgroundAlt"+i+".png");
            stories[i-1]=new GreenfootImage("page"+i+".png");
        }
        clickIndex=0;
        setBackground(backgrounds[clickIndex]);
        getBackground().drawImage(stories[clickIndex], 200, 530);
        forward=new Forward(this);
        addObject(forward, 920, 610);
        backward=new Backward(this);
        
        Constants.backgroundSound.playLoop();
    }
    
    public void act(){
        if(clickIndex>0){
            addObject(backward, 80, 610);
        }
        else {
            removeObject(backward);
        }
    }
    
    /**
     * get the current page number of story
     * @return int the current page number 
     */
    public int getClickIndex(){
        return clickIndex;
    }
    
    /**
     * set the page number 
     * @param num the page number
     */
    public void setClickIndex(int num){
        clickIndex=num;
    }
    
    /**
     * flip the story page by setting a new background and add the 
     * corresponding story
     */
    public void setStory(){
        setBackground(backgrounds[clickIndex]);
        getBackground().drawImage(stories[clickIndex], 200, 530);
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has started.
     * Play background sound in loop once the execution has started.
     */
    public void started() {
        Constants.backgroundSound.playLoop();
    }
    
    /**
     * This method is called by the Greenfoot system when the execution has stopped.
     * Pause background sound once the execution has stopped so that when it
     * started again, the sound will play coherently.
     */
    public void stopped() {
        Constants.backgroundSound.pause();
    }
}
