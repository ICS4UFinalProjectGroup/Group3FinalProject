import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Activity here.
 * 
 * @author Yixin Cai
 * @version 2023-01-21
 */
public class Activity extends Actor
{
    public static final int SPEED = 20;

    private String name;
    private int originalX;
    private int originalY;
    private boolean isMouseDown;
    private int[] points;

    public Activity(String name, int[] points) {
        this.name = name;
        this.points = points;
        
        String imageFileName = "activity" + this.name + "Icon.png";
        setImage(new GreenfootImage(imageFileName));
    }
    
    public void addedToWorld(World w) {
        originalX = getX();
        originalY = getY();
    }

    /**
     * Act - do whatever the Activity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseDragged(this)) {
            setLocation(Greenfoot.getMouseInfo().getX(),Greenfoot.getMouseInfo().getY());
            this.isMouseDown = true;
        }
        else if (Greenfoot.mouseDragEnded(this)) {
            ArrayList<Activity> activities = (ArrayList<Activity>) getObjectsAtOffset(0, 0, Activity.class);
            if (activities.size() == 1) {
                ScheduleWorld sw = (ScheduleWorld) getWorld();
                sw.trySetActivity(this);
            }
            this.isMouseDown = false;
        }
        
        if (!this.isMouseDown) {
            checkMove();
        }
    }
    
    private void checkMove() {
        int x = getX();
        int y = getY();
        if (x != originalX || y != originalY) {
            double dx = Math.abs(originalX - x);
            double dy = Math.abs(originalY - y);
            double degree = Math.atan(dy / dx);
            double mx = Math.cos(degree) * SPEED;
            double my = Math.sin(degree) * SPEED;
            if (dx < mx || dy < my) {
                setLocation(originalX, originalY);
            }
            else {
                int xDirection = originalX > x ? 1 : -1;
                int yDirection = originalY > y ? 1 : -1;
                setLocation((int) (x + mx * xDirection), (int) (y + my * yDirection));
            }
        }
    }
    
    public void setActivity(int x, int y) {
        setLocation(x, y);
        this.originalX = x;
        this.originalY = y;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int[] getPoints() {
        return this.points;
    }
    
}
