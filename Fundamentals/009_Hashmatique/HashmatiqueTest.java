public class HashmatiqueTest {
    public static void main(String[] args) {
        Hashmatique hash = new Hashmatique();
        hash.setSong("title_1", "lyrics_1");
        hash.setSong("title_2", "lyrics_2");
        hash.setSong("title_3", "lyrics_3");
        hash.setSong("title_4", "lyrics_4");
        System.out.println(hash.getSong("title_1"));
        System.out.println(hash.getSongs());
    }

}