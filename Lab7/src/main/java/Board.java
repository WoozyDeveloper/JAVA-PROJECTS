public class Board {
    private final int x=2;//a collection for words;
    private String[] words;
    private int index = 0;

    public Board(){
        this.words = new String[100];
        index = 0;
    }

    public void addWord(Player player, String word) {
        //add the word to the collection;
        words[index] = word;
        index++;
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {
        return words.toString();
    }
}