
public class Compulsory {
	
	//functie ce calculeaza suma cifrelor unui numar
	private static int digitSum(int num)
	{
		int sum = 0;
		do
		{
			sum+=num%10;
			num/=10;
		}while(num>0);
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
		
		//generez numarul random n si realizez calculele
		int n = (int) (Math.random() * 1_000_000);
		n*=3;
		n+=Integer.parseInt("10101", 2);
		n+=Integer.parseInt("FF", 16);
		n*=6;
		
		//fac suma cifrelor sale pana devine de o cifra
		while(n>9)
			n = digitSum(n);
		
		//System.out.println(n);
		System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
	}
}
