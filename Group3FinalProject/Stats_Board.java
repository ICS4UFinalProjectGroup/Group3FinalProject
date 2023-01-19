import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stats_Board here.
 * 
 * @Yuxin (your name) 
 * @version (a version number or a date)
 */
public class Stats_Board extends Actor
{
    /**
     * Act - do whatever the Stats_Board wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int[] stats_values=new int[4];
    private Stat iq_stat;
    private Stat eq_stat;
    private Stat memory_stat;
    private Stat creativity_stat;
    private static final Color transparent = new Color(0,0,0,0);
    public Stats_Board(){
        
    }
    
    public void addedToWorld(World w){
        iq_stat=new Stat("IQ", stats_values[0]);
        w.addObject(iq_stat, getX(), getY()-60);
        eq_stat=new Stat("EQ", stats_values[1]);
        w.addObject(eq_stat, getX(), getY());
        memory_stat=new Stat("Memory", stats_values[2]);
        w.addObject(memory_stat, getX(), getY()+60);
        creativity_stat=new Stat("Creativity", stats_values[3]);
        w.addObject(creativity_stat, getX(), getY()+120);
    }
    
    public void addPoints(String name, int points){
        GreenfootImage point_adding_text = new GreenfootImage("+ "+ points, 20, Color.BLACK, transparent);
        
        if(name.equals("IQ")){
            getWorld().addObject(new Fades_Points(point_adding_text), iq_stat.getX()+60, iq_stat.getY()-10);
            stats_values[0]+=points;
            iq_stat.setStat(stats_values[0]);
        }
        
        if(name.equals("EQ")){
            getWorld().addObject(new Fades_Points(point_adding_text), eq_stat.getX()+60, eq_stat.getY()-10);
            stats_values[1]+=points;
            eq_stat.setStat(stats_values[1]);
        }
        
        if(name.equals("Memory")){
            getWorld().addObject(new Fades_Points(point_adding_text), memory_stat.getX()+95, memory_stat.getY()-10);
            stats_values[2]+=points;
            memory_stat.setStat(stats_values[2]);
        }
        
        if(name.equals("Creativity")){
            getWorld().addObject(new Fades_Points(point_adding_text), creativity_stat.getX()+105, creativity_stat.getY()-10);
            stats_values[3]+=points;
            creativity_stat.setStat(stats_values[3]);
        }
    }
    
}