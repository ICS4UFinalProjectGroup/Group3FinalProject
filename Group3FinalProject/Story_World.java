import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story_World here.
 * 
 * @Yuxin Li 
 * @version (a version number or a date)
 * 
 * get married picture by RapidEye
 * https://www.istockphoto.com/photo/male-and-female-hands-clasped-gm931136214-255235764
 * 
 * pregnant picture
 * https://www.madeformums.com/pregnancy/early-pregnancy-tests-are-giving-too-many-false-results/
 * 
 * hospital picture
 * https://unsplash.com/s/photos/hospital-room
 * 
 * welcome picture by dpproductions
 * https://www.istockphoto.com/photos/front-door
 * 
 * story block by user2104819
 * https://www.freepik.com/premium-vector/set-ui-elements-2d-games-apps-jungle-game-ui-part-2_4267333.htm
 * 
 * arrows by user22934206
 * https://www.freepik.com/premium-vector/collection-set-wooden-game-ui-frame-template-pop-up-interface-gui-asset-elements_11707777.htm#from_view=detail_alsolike
 */

public class Story_World extends World
{
    private GreenfootImage[] backgrounds=new GreenfootImage[5];
    private GreenfootImage[] stories=new GreenfootImage[5];
    private int clickIndex;
    private Arrow forward;
    private Arrow backward;
    /**
     * 
     *
     */
    public Story_World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 700, 1); 
        for(int i=1; i<=5; i++){
            backgrounds[i-1]=new GreenfootImage("background"+i+".png");
            stories[i-1]=new GreenfootImage("page"+i+".png");
        }
        clickIndex=0;
        setBackground(backgrounds[clickIndex]);
        getBackground().drawImage(stories[clickIndex], 125, 550);
        forward=new Forward(this);
        addObject(forward, 950, 620);
        backward=new Backward(this);
    }
    public void act(){
        if(clickIndex>0){
            addObject(backward, 80, 620);
        }
        else{
            removeObject(backward);
        }
    }
    public int getClickIndex(){
        return clickIndex;
    }
    public void setClickIndex(int num){
        clickIndex=num;
        
    }
    public void setStory(){
        setBackground(backgrounds[clickIndex]);
        getBackground().drawImage(stories[clickIndex], 125, 550);
    }
}
