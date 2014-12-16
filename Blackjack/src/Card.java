/**
 * AN implementation Of A card Type
 * 
 * @author ta2er
 * 
 */
public class Card {

	private Suit CardSuit; // The Suit Of My Card one Of The Four Suits

	/**
	 * The Number Of My Card ,Ace=1 J=11 Q=12 K=13
	 */
	private int CardNumber;

	public Card(Suit MySuit, int MyNum) {

		this.CardSuit = MySuit;
		if(MyNum>=1 && MyNum<=13){
		this.CardNumber = MyNum;}
		else{
			System.err.println(MyNum + "is Not A valid Number!");
			System.exit(1);
		}

	}

	public int getCardNumber() {
		return CardNumber;
	}

	public String toString(){
		String StNumber = "Error";
		switch(this.CardNumber){
		
		case 1:
			StNumber = "Ace";
			break;
		case 2:
			StNumber = "Two";
			break;
		case 3:
			StNumber = "Three";
			break;
		case 4:
			StNumber = "Four";
			break;
		case 5:
			StNumber ="Five";
			break;
		case 6:
			StNumber = "Six";
			break;
		case 7:
			StNumber = "Seven" ;
			break;
		case 8:
			StNumber = "Eight";
			break;
		case 9:
			StNumber = "Nine";
			break;
		case 10:
			StNumber ="Ten";
			break;
		case 11:
			StNumber = "Jack";
			break;
		case 12:
			StNumber = "Queen";
			break;
		case 13:
			StNumber ="King";
			break;
		}
		return StNumber + " Of " + CardSuit.toString();
	}
}