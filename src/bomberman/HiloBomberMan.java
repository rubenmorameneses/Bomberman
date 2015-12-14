package bomberman;

public class HiloBomberMan extends Thread
{
    int posx,posy;
    char movimiento;

    public HiloBomberMan(int posx, int posy, char movimiento)
    {
        this.posx = posx;
        this.posy = posy;
        this.movimiento= movimiento;
    }
    
    public void run()
    {
        switch(movimiento)
        {
            case 'w':
            {
                
            }
            case 's':
            {
                
            }
            case 'a':
            {
                
            }
            case 'd':
            {
                
            }
            case ' ':
            {
                
            }
        }
    }
}