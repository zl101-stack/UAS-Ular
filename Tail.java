import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tail extends Actor
{
    /**
     * Act - do whatever the Tail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Player player;
    int countLength = 0;
    int r, g, b;
    
    public Tail(int r, int g, int b, Player player)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.player = player;
        GreenfootImage img = new GreenfootImage(40, 40);
        img.setColor(new Color(r, g, b));
        img.fillOval(0, 0, 40, 40); // ekor bulat
        setImage(img);
    }
    
    protected void addedToWorld(World world)
    {
        MyWorld w = (MyWorld)world;
        w.tailList.add(this);   // daftar ekor
    }
    
    public void act()
    {
        countLength++;
        if (countLength > 20)  // nilai ini bisa diatur sesuai jarak aman
        {
            Actor head = getOneIntersectingObject(Player.class);
            if (head != null)
            {
                if (getOneIntersectingObject(Eye.class) == null)
                {
                    MyWorld w = (MyWorld)getWorld();
                    w.displayYouLose();
                }
            }
        }
    
        if (countLength > player.playerLength)
        {
            getWorld().removeObject(this);
        }
    }
}


