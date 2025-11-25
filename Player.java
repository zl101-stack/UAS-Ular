import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int speed = 7;
    int r, g, b;
    
    int tailDelay = 0;                 
    int tailInterval = 3; 
    public int playerLength = 10;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        GreenfootImage img = new GreenfootImage(50, 50);
        img.setColor(new Color(r, g, b));
        img.fillOval(0, 0, 50, 50);    // kepala bulat
        setImage(img);
    }
    
    public void act()
    {
        updateEyes(); 
        spawnTail();
        move(speed);
        InputMovement();
        eatFood();
        checkBorder();
    }
    
    public void spawnTail()
    {
        tailDelay++;
        if (tailDelay >= tailInterval)
        {
            MyWorld w = (MyWorld)getWorld();

            // Tambahkan tail baru
            w.addObject(new Tail(r, g, b, this), getX(), getY());

            // BATAS jumlah tail supaya tidak numpuk
            if (w.tailList.size() > playerLength)   // playerLength adalah panjang snake
            {
                Tail removed = w.tailList.remove(0);
                w.removeObject(removed);
            }

            tailDelay = 0;
        }
    }

    public void InputMovement()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
        }
    }
    
    public void checkBorder()
    {
        if (getX() <= 0 || getX() >= getWorld().getWidth()-1 ||
            getY() <= 0 || getY() >= getWorld().getHeight()-1)
        {
            MyWorld w = (MyWorld)getWorld();
            w.displayYouLose();
        }
    }
    
    public void eatFood()
    {
        if(isTouching(Food.class))
        {
           MyWorld mw = (MyWorld)getWorld();
            mw.Score.addScore();
            mw.addFood();
            playerLength += 5;
        }
    }  
    
    public void updateEyes()
    {
        GreenfootImage head = new GreenfootImage(50, 50);
        head.setColor(new Color(r, g, b));
        head.fillOval(0, 0, 50, 50);
        
        int rot = getRotation();
        int lx = 0, ly = 0;  // left eye offset
        int rx = 0, ry = 0;  // right eye offset

        if (rot == 0) {            // RIGHT
            lx = 5; ly = -5;
            rx = 5; ry = 5;
        }
        else if (rot == 90) {      // DOWN
            lx = -5; ly = 5;
            rx = 5;  ry = 5;
        }
        else if (rot == 180) {     // LEFT
            lx = -5; ly = -5;
            rx = -5; ry = 5;
        }
        else if (rot == 270) {     // UP
            lx = -5; ly = -5;
            rx = 5;  ry = -5;
        }

        // gambar mata visual
        head.setColor(Color.WHITE);
        head.fillOval(28 + lx, 20 + ly, 13, 13); // mata kiri
        head.fillOval(28 + rx, 20 + ry, 13, 13); // mata kanan



        // pasang ulang gambar kepala
        setImage(head);

    }
}
