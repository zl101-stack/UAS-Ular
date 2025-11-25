import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eye here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eye extends Actor
{
    public GreenfootImage visualEye;
    
    public Eye()
    {
        GreenfootImage img = new GreenfootImage(28, 28);
        img.setColor(Color.WHITE);
        img.fillOval(0, 0, 28, 28);

        img.setColor(Color.BLACK);
        img.fillOval(10, 10, 8, 8); // pupil
        
        visualEye = img; 
        
        GreenfootImage hitbox = new GreenfootImage(1, 1);
        hitbox.setColor(new Color(0,0,0,0));
        hitbox.fill();

        setImage(hitbox);
    }
    /**
     * Act - do whatever the Eye wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
