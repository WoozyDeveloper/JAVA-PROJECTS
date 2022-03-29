
public class Pion implements PiesaDeSah {

	@Override
	public int[][] muta(int x, int y, Coordonate coord) {
		// TODO Auto-generated method stub
		int[][] coords = new int[1][2];
		switch(coord) {
		case N:
			if(x==8) {
				System.out.println("Nu se poate");
				break;
			}
			x++;
			break;
		default:
			break;
		}
		coords[0][0] = x;
		coords[0][1] = y;
		return coords;
	}

}
