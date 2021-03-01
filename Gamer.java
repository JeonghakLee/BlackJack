package BlackJack;
import java.util.List;
import java.util.ArrayList;

public class Gamer {
	private List<Card> cards;
	
	public Gamer() {
		cards = new ArrayList<>();
	}
	
	public void receiveCard(Card card) {
		this.cards.add(card);
		this.showCards();
	}
	// 카드를 더 뽑을지 정하기위해 현재 카드들을 확인할수 있도록 하는 메서드
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
}
