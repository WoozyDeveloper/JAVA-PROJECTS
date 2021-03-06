import java.util.ArrayList;
import java.util.Arrays;

public class Word {
	ArrayList<StringBuilder> myNeighbours = new ArrayList<StringBuilder>();//aici salvam vecinii pentru fiecare cuvant in parte
	private int dim = 0;
		
	public void setNeighbourhood(int index, StringBuilder[] words, boolean[][] matrix, int n)
	{
		for(int i = 0; i < n; i++)
			if(matrix[index][i] == true && index != i)//daca words[index] e vecin cu words[i] si cuvantul e difert de el insusi
			{
				myNeighbours.add(words[i]);//adaugam cuvantul
				dim++;
			}
				
	}
	public void printNeighbours(int index, StringBuilder[] words)
	{
		System.out.print("Vecinii lui " + words[index] + ": ");
		for(int i = 0; i < myNeighbours.size(); i++)
			System.out.print(myNeighbours.get(i) + " ");
	}
}
