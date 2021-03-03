package BlackJack;
import java.util.List;
import java.util.ArrayList;

	
public class Gamer implements player {
	private List<Card> cards;
	private boolean turn;
	
	public Gamer() {
		cards = new ArrayList<>();
	}
	
	@Override
	public void receiveCard(Card card) {
		this.cards.add(card);
		this.showCards();
	}
	// 카드를 더 뽑을지 정하기위해 현재 카드들을 확인할수 있도록 하는 메서드
	@Override
	public void showCards() {
		StringBuilder sb = new StringBuilder();
		sb.append("현재 보유 카드 목록 \n");
		
		for(Card card: cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public List<Card> openCards() {
		return this.cards;
	}
	
	@Override
	public void turnOff() {
		this.setTurn(false);
	}
	
	@Override
	public void turnOn() {
		this.setTurn(true);
	}
	
	@Override
	public boolean isTurn() {
		return this.turn;
	}

	private void setTurn(boolean turn) {
		this.turn = turn;
	}
}
