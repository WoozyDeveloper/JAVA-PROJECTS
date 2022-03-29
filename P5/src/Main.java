import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Cal c = new Cal();
		int res[][] = new int[1][2];
		res = c.muta(2, 1, Coordonate.NE);
		System.out.println(res[0][0] + " " + res[0][1]);
	}
}
