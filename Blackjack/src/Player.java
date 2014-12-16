/**
 * An implementation of a BlackJack Player.
 * 
 * @author ta2er
 * 
 */
public class Player {

	/**
	 * The Player"s name.
	 */
	private String name;

	/**
	 * The cards in the Player"s Hand.
	 */
	private Card[] Hand = new Card[10];

	/**
	 * The number of Cards in the Player's Hand
	 */
	private int numCards;

	/**
	 * Player Constructor
	 * 
	 * @param aName
	 *            the Player Name
	 */
	public Player(String aName) {

		this.name = aName;

		// set a Player's hand to empty
		this.emptyHand();
	}

	/**
	 * Reset the Player's hand to Zero Cards.
	 */
	public void emptyHand() {
		for (int c = 0; c < 10; c++) {
			this.Hand[c] = null;
		}
		this.numCards = 0;

	}

	/**
	 * Add a card to the player hand
	 * 
	 * @param aCard
	 *            the card to add
	 * @return whether the sum of the new hand is below or equal to 21
	 */
	public boolean addCard(Card aCard) {
		// print error if we already have the max number of cards
		if (this.numCards == 10) {
			System.err.printf("%s's hand already has 10 cards; "
					+ "cannot add another \n", this.name);
			System.exit(1);

		}
		
		// add new card in next slot and increment number of cards counter 
		this.Hand[this.numCards]= aCard;
		this.numCards++;
		
		return (this.getHandSum() <=21);
	}
	/**
	 * get the sum of cards in the Player's Hand
	 * @return the Sum
	 */
	public int getHandSum(){
		
		int handSum=0;
		int cardNum;
		int numAces =0;
		
		//calc each card's to the hand sum 
		for (int c=0;c<this.numCards;c++){
			//get the number of the current  card
			cardNum = this.Hand[c].getCardNumber();
			
			if(cardNum ==1){//Ace
				numAces++;
				handSum +=11;
			}else if(cardNum>10){ //face card 
				handSum+=10;
			}else{
				handSum+=cardNum;
				
			}
		}
		//if we have aces and our sum is >21,set some/all of them to value 1 instead 
		while(handSum>21 && numAces >0){
			handSum-=10;
			numAces--;
			
		}
		return handSum;
	}
	/**
	 * Print the Cards in the Player's Hand
	 * @param showFirstCard whether the first card is hidden or not
	 */
	public void printHand(){
		System.out.printf("%s's Cards:\n",this.name);
		for(int c=0 ; c<this.numCards ;c++){
			
				System.out.printf(" %s\n",this.Hand[c].toString());
				
			}
		}
	}

