public class Board {
    private final int x=2;//a collection for words;
    String[] words;


    public Board(){
        this.words = new String[100];
    }

    public void addWord(Player player, String word) {
        //add the word to the collection;
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {
        return words.toString();
    }
}