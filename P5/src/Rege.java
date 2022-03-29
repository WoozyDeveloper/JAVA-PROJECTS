
public class Rege implements PiesaDeSah {

	@Override
	public int[][] muta(int x, int y, Coordonate coord) {
		// TODO Auto-generated method stub
		int[][] coords = new int[1][2];
		switch(coord) {
		case E:
			if(y==8) {
				System.out.println("Nu se poate");
				break;
			}
			y++;
			break;
		case N:
			if(x==8) {
				System.out.println("Nu se poate");
				break;
			}
			x++;
			break;
		case NE:
			if(y==8 || x==8) {
				System.out.println("Nu se poate");
				break;
			}
			x++;
			y++;
			break;
		case NV:
			if(x==8) {
				System.out.println("Nu se poate");
				break;
			}
			x++;
			if(y==1) {
				System.out.println("Nu se poate");
				break;
			}
			y--;
			break;
		case S:
			if(x==1) {
				System.out.println("Nu se poate");
				break;
			}
			x--;
			break;
		case V:
			if(y==1) {
				System.out.println("Nu se poate");
				break;
			}
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
