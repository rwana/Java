import java.util.Random;

class CardShuffle3 {
    String deck[];

    //constructor
    CardShuffle3() {
        deck = new String[52];
    }

    //method for filling a new deck
    void newDeck() {
        char spade = '\u2660';
        char heart = '\u2665';
        char diamond = '\u2666';
        char club = '\u2663';

        char suit[] = {spade, heart, diamond, club};
        String rank[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                int deckloc = (i * rank.length) + j; // current deck location
                deck[deckloc] = rank[j] + Character.toString(suit[i]);
                System.out.print(deck[deckloc] + " ");
            }
            System.out.println();
        }
    }

    //method for shuffling deck
    void shuffleDeck() {
        String cardStorage = new String();
        Random rand = new Random();

        for (int i = 0; i < deck.length; i++) {
            int n = rand.nextInt((51 - i) + 1) + i;
            cardStorage = deck[n];
            for (int j = n; j > i; j--) {
                deck[j] = deck[j - 1];
            }
            deck[i] = cardStorage;
        }
    }

    public static void main(String... args) {
        CardShuffle3 testDeck = new CardShuffle3();
        testDeck.newDeck();

        String testCondition = testDeck.deck[2];
        testDeck.shuffleDeck();
        System.out.println();
        for (int i = 0; i < testDeck.deck.length; i++) {
            if (i % 13 == 0) System.out.println();
            System.out.print(testDeck.deck[i] + " ");
        }
    }
}