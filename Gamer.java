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
	// ī�带 �� ������ ���ϱ����� ���� ī����� Ȯ���Ҽ� �ֵ��� �ϴ� �޼���
	public void showCards() {
		StringBuilder sb = new StringBuilder();
		sb.append("���� ���� ī�� ��� \n");
		
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
