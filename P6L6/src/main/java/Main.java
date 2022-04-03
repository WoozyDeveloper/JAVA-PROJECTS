import java.util.Random;
import java.awt.Color;

public class Main {
    static double h,v,s;

    public static double mini(double r, double g, double b){
        return Math.min(Math.min(r, g), b);
    }

    public static double maxi(double r, double g, double b){
        return Math.max(Math.max(r, g), b);
    }

    public static void RGBtoHSV(double r, double g, double b)
    {
        double min, max, delta;
        min = mini( r, g, b );
        max = maxi( r, g, b );
	v = max;				// v
        delta = max - min;
        if( max != 0 )
		s = delta / max;		// s
	else {
        // r = g = b = 0		// s = 0, v is undefined
		s = 0;
		h = -1;
        return;
    }
        if( r == max )
		h = ( g - b ) / delta;		// between yellow & magenta
	else if( g == max )
		h = 2 + ( b - r ) / delta;	// between cyan & yellow
	else
		h = 4 + ( r - g ) / delta;	// between magenta & cyan
	h *= 60;				// degrees
        if( h < 0 )
		h += 360;
    }

    public static void main(String[] args) throws Saturat {
        double r,g,b;

        Random random = new Random();
        int i=0;
        for(i=1;i<=10;i++) {
            r = random.nextDouble() * 100;
            g = random.nextDouble() * 100;
            b = random.nextDouble() * 100;
            RGBtoHSV(r,g,b);
            if(h>90 || v>90 || s>90)
                continue;
            else
            {
                System.out.println(h+ " " + s  + " " + v);
                break;
            }
        }
        if(i>10) {
            System.out.println(h+ " " + s  + " " + v);
            throw new Saturat();
        }
        else
            System.out.println("DONE la iteratia " + i);
    }
}
