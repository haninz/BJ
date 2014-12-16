import java.util.Random;

/**
 * An implementation of a deck of cards.
 * 
 * @author ta2er
 * 
 */

public class Deck {
	/**
	 * Array of cards on deck ,the top card is in the first index.
	 */

	private Card[] MyCards;
	/**
	 * the number of cards in the deck.
	 */
	private int numCards;

	/**
	 * constructor with a default of one deck (52 cards) and no shuffling .
	 */
	public Deck() {
		// call the other Constructor ,defining one deck without shuffling.
		this(1, false);
	}

	/**
	 * Constructor that define the number of decks what means how many sets of
	 * 52 cards is in the deck
	 * 
	 * @param DeckNum
	 *            the number of the decks in the deck
	 * @param Shuffle
	 *            whether to shuffle the cards.
	 */

	public Deck(int DeckNum, boolean Shuffle) {
		this.numCards = DeckNum * 52;
		this.MyCards = new Card[this.numCards];
		// card index

		int c = 0;
		// For each Suit
		for (int S = 0; S < 4; S++) {

			for (int num = 0; num < DeckNum; num++) {
				// For each number
				for (int n = 1; n <= 13; n++) {
					// add anew card to the deck
					this.MyCards[c] = new Card(Suit.values()[S], n);
					c++;
				}
			}
		}
		// shuffle !!!

		if (Shuffle) {
			this.shuffle();
		}
	}

	/**
	 * Shuffle deck randomly swapping pairs of cards .
	 */
	public void shuffle() {
		// random number generator

		Random rand = new Random();

		// temporary card
		Card temp;

		int j;
		for (int i = 0; i < this.numCards; i++) {
			// get a random card j to swap i's value with
			j = rand.nextInt(this.numCards);

			// do swap
			temp = this.MyCards[i];
			this.MyCards[i] = this.MyCards[j];
			this.MyCards[j] = temp;

		}

	}

	/**
	 * deal the next card from the top of the deck
	 * 
	 * @return the dealt card
	 */
	public Card dealNextCard() {
		// get the top Card
		Card Top = this.MyCards[0];

		// shift all the cards to the left
		for (int c = 1; c < this.numCards; c++) {
			this.MyCards[c - 1] = this.MyCards[c];
		}
		this.MyCards[this.numCards - 1] = null;
		// decrement the number of cards
		this.numCards--;

		return Top;

	}

	/**
	 * print the top cards in the deck
	 * 
	 * @param numToPrint
	 *            From the top of the deck
	 */
	public void printDeck(int numToPrint) {
		for (int c = 0; c <= numToPrint; c++) {
			System.out.printf("%3d/%d %s\n", c + 1, this.numCards,
					this.MyCards[c].toString());

		}
		System.out.printf("\t[%d other]\n", this.numCards - numToPrint);
	}

	public Card[] getMyCards() {
		return MyCards;
	}

	public void setMyCards(Card[] myCards) {
		MyCards = myCards;
	}

	public int getNumCards() {
		return numCards;
	}

	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}

}
