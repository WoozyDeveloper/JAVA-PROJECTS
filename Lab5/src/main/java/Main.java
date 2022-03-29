
public class Main {

    public static void main(String[] args) {
        Catalog c = new Catalog();
        Book i1 = new Book("1","ABC","https://","Gigel");
        c.add(i1);

        Notebook i2 = new Notebook("2","B","d:/","Altcineva");
        c.add(i2);

        Book i3 = new Book("3","CCC","aici","Cineva");
        c.add(i3);

        System.out.print(c);

    }
}
