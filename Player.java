package BlackJack;
import java.util.List;

public interface Player {
	void receiveCard(Card card);
	
	void showCard();
	
	List<Card> openCards();
	
	void turnOff();
	
	void turnOn();
	
	boolean isTurn();
}

public class Gamer implements player {
	@Override
	public void receiveCard(Card card) {}
	
	@Override
	public void showCards() {}
	
	@Override
	public List<Card> openCards(){}
}

public class Dealer implements player {
	@Override
	public void receiveCard(Card card) {}
	
	@Override
	public void showCards() {}
	
	@Override
	public List<Card> openCards(){}
}
