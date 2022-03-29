
public class Tura implements PiesaDeSah {

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
