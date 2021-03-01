package BlackJack;
import java.util.List;
import java.util.LinkedList;


public class CardDeck {
    private List<Card> cards;

    public Card getCard(){
        return null;
    }
    
	private static final String[] PATTERNS = {"spade", "heart", "diamond", "club"};
	private static final int CARD_COUNT = 13;
	
	public CardDeck() {
		cards = this.generateCards();
	}
    
	private List<Card> generateCards() {
	    List<Card> cards = new LinkedList<>();
	
	    for(String pattern : PATTERNS){
	        for(int i=1; i<=CARD_COUNT; i++) {
	            String denomination = this.numberToDenomination(i);
	            Card card = new Card(pattern, denomination);	// new 빠뜨려서 헤맸음
	            
	            cards.add(card);
	        }
	    }
	
	    return cards;
	}
	
	private String numberToDenomination(int number){
	
	    if(number == 1){
	        return "A";
	    }else if(number == 11){
	        return "J";
	    }else if(number == 12){
	        return "Q";
	    }else if(number == 13){
	        return "K";
	    }
	
	    return String.valueOf(number);
	}
	
	public Card draw() {
		Card selectedCard = getRandomCard();
		cards.remove(selectedCard);
		return selectedCard;
	}
	
	// 현재 클래스 내에서만 사용되는 메서드는 private로 설정
	private Card getRandomCard() {
		int size = cards.size();
		int select = (int)(Math.random()*size);
		return cards.get(select);
	}
	
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	
    	for(Card card : cards) {
    		sb.append(card.toString());
    		sb.append("\n");
    	}
    	return sb.toString();
    }	
}