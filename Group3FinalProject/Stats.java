/**
 * Write a description of class Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stats  
{
    // instance variables - replace the example below with your own
    private int IQ;
    private int EQ;
    private int creativity;
    private int memory;

    /**
     * Constructor for objects of class Stats
     */
    public Stats(int IQ, int EQ, int creativity, int memory)
    {
        this.IQ = IQ;
        this.EQ = EQ;
        this.creativity = creativity;
        this.memory = memory;
    }
    
    public Stats()
    {
        this(0, 0, 0, 0);
    }
    
    public void promote(int IQ, int EQ, int creativity, int memory) {
        this.IQ += IQ;
        this.EQ += EQ;
        this.creativity += creativity;
        this.memory += memory;
    }
    
    // TODO: temp for testing
    public String getString() {
        return "IQ " + this.IQ + "\nEQ " + this.EQ + "\ncreativity "
            + this.creativity + "\nmemory " + this.memory;
    }
}
