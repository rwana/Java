package cardstuff;

import java.util.Random;

class Cards {
    String deck[];

    //constructor
    Cards() {
        deck = new String[52];
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
            }
        }
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
            }
        }
    }

    //method for shuffling deck
    void shuffleDeck() {
        String cardStorage;
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

    //method for shuffling deck using arraycopy
    void shuffleDeck2() {
        String cardStorage;
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int n = rand.nextInt((51 - i) + 1) + i;
            cardStorage = deck[n];
            System.arraycopy(deck,i,deck,i+1,n-i);
            deck[i] = cardStorage;
        }
    }

    //method to test a cards frequency at each position
    void freqTest(int pos, int iter) {
        String testCondition = deck[pos];
        System.out.println("\nTesting card " + testCondition);
        for (int i = 0; i < deck.length; i++) {
            int count = 0;
            for (int j = 0; j < iter; j++) {
                if (deck[i].equals(testCondition)) count++;
                shuffleDeck2();
            }
            double d = ((double) count) / iter * 100;
            System.out.println("position " + i + ": " + d);
        }
    }

    //method that prints out the deck order
    void pDeck() {
        for (int i = 0; i < deck.length; i++) {
            if (i % 13 == 0) System.out.println();
            System.out.print(deck[i] + "\t");
        }
    }

    //method to check for duplicate cards
    void duplicateCheck() {
        for (int i = 0; i < deck.length; i++) {
            for (int j = i + 1; j < deck.length; j++) {
                if (deck[i].equals(deck[j]))
                    System.out.println("duplicate found");
            }
        }
        System.out.println("no duplicates found");
    }

    public static void main(String... args) {
        Cards testDeck = new Cards();
        testDeck.newDeck();
        testDeck.pDeck();
        System.out.println();
        testDeck.shuffleDeck2();
        testDeck.pDeck();
        testDeck.freqTest(0, 10000);
        //testDeck.duplicateCheck();
    }
}
