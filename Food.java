    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int framecounter;
    public int pertambahan = 5;
    
    public void act()
    {
        framecounter++;
        RemoveObject();
    }
    
    public void RemoveObject()
    {
        framecounter++;
        if(framecounter >=600)
        {
            getWorld().removeObject(this);
        }
        else if(isTouching(Player.class))
        {
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.player.playerLength += pertambahan;
            getWorld().removeObject(this);
        }
    }
}