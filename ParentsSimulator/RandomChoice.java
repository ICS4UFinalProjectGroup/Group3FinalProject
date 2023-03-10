import greenfoot.*;

/**
 * Write a description of class RandomChoice here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class RandomChoice extends Actor {
    private String answer;
    private int[] results;
    private GreenfootSound clickSound;

    /**
     * Constructor for objects of class RandomChoice
     */
    public RandomChoice(String answer, int[] results) {
        this.answer = answer;
        this.results = results;
        
        GreenfootImage image = new GreenfootImage("randomChoicesAnswer.png");
        image.setColor(Color.GRAY);
        image.drawImage(new GreenfootImage(this.answer, 20, Color.GRAY, new Color(0, 0, 0, 0)), 30, image.getHeight() / 2 - 5);
        setImage(image);
        
        clickSound = new GreenfootSound("click.wav");
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            clickSound.play();
            ActivityEffectWorld w = (ActivityEffectWorld) getWorld();
            w.finishRandomChoice(this.results);
        }
    }
}
