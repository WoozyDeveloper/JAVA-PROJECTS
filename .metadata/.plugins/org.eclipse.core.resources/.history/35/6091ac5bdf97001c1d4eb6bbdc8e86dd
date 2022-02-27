import java.util.Random;

public class Homework {
	
//	private static int convertBoolean(boolean x)
//	{
//		return x == true? 1 : 0;
//	}

	//Functie ce verifica daca doua cuvinte sunt vecine
	private static boolean areNeighbours(StringBuilder s1, StringBuilder s2)
	{
		for(int i=0; i < s1.length(); i++)
			for(int j=0; j < s2.length(); j++)
				if(s1.charAt(i) == s2.charAt(j))//daca gasim un caracter comun
					return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		//preiau in startTime timpul la care incepe programul
		int startTime = (int) System.nanoTime();
		int n = Integer.parseInt(args[0]);//luam primul parametru ce este chiar n
		int p = Integer.parseInt(args[1]);//luam al doilea parametru, si anume p
		char[] c = new char[args.length - 2];//in c se va afla alfabetul
		
		int index = 0;
		//pornim de la 2 prin argumente deoarece in 0 avem n si in 1 pe p, alfabetul incepand de la 2 pana la args.length
		for(int i = 2; i < args.length; i++) 
			c[index++] = args[i].charAt(0);//am pus charAt(0) ca sa-l vada ca si caracter.
		
		//acum in c avem alfabetul
		
		StringBuilder[] words = new StringBuilder[n];//aici vom avea cuvintele generate aleator
		for(int i = 0; i < n; i++)
		{
			words[i] = new StringBuilder();
			Random r = new Random();
			int low = 0;
			int high = c.length;
			int result = r.nextInt(high-low) + low;//in result avem un numar random din intervalul [low,high].
			words[i].append(c[result]);//punem un caracter
			for(int j = 1; j < p; j++)//punem urmatoarele p-1 caractere
			{
				r = new Random();
				low = 0;
				high = c.length - 1;
				result = r.nextInt(high-low) + low;
				words[i].append(c[result]);
			}
		}
		
		boolean[][] adj = new boolean[n][n];
		for(int i=0;i<words.length;i++)
			for(int j=0;j<words.length;j++)
			{
				if(areNeighbours(words[i],words[j]) == true)
				{
					adj[i][j] = true;
					//System.out.print("\nVecini " + words[i] + " cu " + words[j]);
				}
				else
					adj[i][j] = false;
			}
		System.out.println();
		Word[] wordDB = new Word[n];
		for(int i = 0; i < n ; i++)
		{
			wordDB[i] = new Word();
			wordDB[i].setNeighbourhood(i, words, adj, n);
		}
		for(int i = 0; i < n ; i++)
		{
			wordDB[i].printNeighbours(i,words);
			System.out.println();
		}
		
		
		
//		for(int i=0;i<words.length;i++)
//		{
//			for(int j=0;j<words.length;j++)
//				System.out.print(adj[i][j]+" ");
//			System.out.println();
//		}
		
		
		//preiau in endTime timpul la care s-a terminat programul
		int endTime = (int) System.nanoTime();
		//afisez timpul de rulare scazand endTime-startTime
		System.out.println("Time: " + (endTime - startTime));
	
	}
}
