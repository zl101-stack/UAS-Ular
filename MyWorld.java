import greenfoot.*;
import java.util.ArrayList;
  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int framecounter;
    public  Score Score = new Score();
    public YouLose youLose = new YouLose();
    public Player player = new Player(100, 0, 0);
    public ArrayList<Tail> tailList = new ArrayList<>();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1360, 650, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(player,769,377);
        addObject(Score,60,32);
        Score.setLocation(71,19);
        addFood(); 
    }
    
    public void act()
    {
        framecounter++;
        if(framecounter > 600)
        {
            addFood();
        }
        System.out.println("hello");
    }
    
    public void addFood()
    {
        addObject(new Food(), Greenfoot.getRandomNumber(getWidth()-1), Greenfoot.getRandomNumber(getHeight()-1));
        framecounter = 0;
    }
    
    public void displayYouLose()
    {
        addObject(youLose,674,389);
        youLose.setLocation(getWidth()/2,getHeight()/2);
        Greenfoot.stop();
    }
}

