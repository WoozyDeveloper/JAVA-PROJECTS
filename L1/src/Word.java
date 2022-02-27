import java.util.ArrayList;
import java.util.Arrays;

public class Word {
	ArrayList<StringBuilder> myNeighbours = new ArrayList<StringBuilder>();
	private int dim = 0;
		
	public void setNeighbourhood(int index, StringBuilder[] words, boolean[][] matrix, int n)
	{
		for(int i = 0; i < n; i++)
			if(matrix[index][i] == true && index != i)
			{
				myNeighbours.add(words[i]);
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
