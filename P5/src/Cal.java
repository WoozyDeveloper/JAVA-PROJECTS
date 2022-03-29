
public class Cal implements PiesaDeSah {

	@Override
	public int[][] muta(int x, int y, Coordonate coord) {
		// TODO Auto-generated method stub
		int[][] coords = new int[1][2];
		switch(coord) {
		case NE:
			if(x+3 > 8 || y + 1 > 8) {
				System.out.println("Nu se poate");
				break;
			}
			x+=3;
			y++;
			break;
		case NV:
			if(x+3 > 8 || y - 1 < 1) {
				System.out.println("Nu se poate");
				break;
			}
			x+=3;
			y--;
			break;
		case SE:
			if(x-3 > 8 || y + 1 > 8) {
				System.out.println("Nu se poate");
				break;
			}
			x-=3;
			y++;
			break;
		case SV:
			if(x-3 > 8 || y - 1 < 1) {
				System.out.println("Nu se poate");
				break;
			}
			x-=3;
			y--;
			break;
		default:
			break;
		}
		coords[0][0] = x;
		coords[0][1] = y;
		return coords;
	}

}
