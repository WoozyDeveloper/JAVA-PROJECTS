
public class Regina implements PiesaDeSah {

	@Override
	public int[][] muta(int x, int y, Coordonate coord) {
		// TODO Auto-generated method stub
		int[][] coords = new int[1][2];
		switch(coord) {
		case E:
			x=8;
			break;
		case N:
			y=8;
			break;
		case NE:
			while(x<8 && y<8)
			{
				x++;
				y++;
			}
			break;
		case NV:
			while(y<8 && x>1)
			{
				y++;
				x--;
			}
			break;
		case SE:
			while(x>1 && y<8)
			{
				x--;
				y++;
			}
			break;
		case SV:
			while(x>1 && y>1)
			{
				x--;
				y--;
			}
			break;
		case S:
			y=1;
			break;
		case V:
			x=1;
			break;
		default:
			break;
		
		}
		coords[0][0] = x;
		coords[0][1] = y;
		return coords;
	}

}
