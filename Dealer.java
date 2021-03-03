package BlackJack;
import java.util.ArrayList;
import java.util.List;
/*
	추가로 카드를 받는다.
	단, 카드 2개의 합계 점수가 16점 이하이면 반드시 1장을 추가로 뽑고, 17점 이상이면 받을 수 없다.
	뽑은 카드를 소유한다.
	카드를 오픈한다.
*/
public class Dealer implements Player{
	private List<Card> cards;
	private boolean turn;
	
	private static final int CAN_RECEIVE_POINT = 16;
	private static final String NAME = "딜러";
	
	public Dealer() {
		cards = new ArrayList<>();
	}
	
	public void receiveCard(Card card) {
		if(this.isReceiveCard()) {
			this.cards.add(card);
			this.showCards();
		}else {
			System.out.println("카드의 총 합이 17이상입니다. 더이상 카드를 받을 수 없습니다.");
		}
	}
	
	private int getPointSum() {
		int sum = 0;
		for(Card card: cards) {
			sum += card.getPoint();
		}
		return sum;
	}
	
	private boolean isReceiveCard() {
		return getPointSum() <= CAN_RECEIVE_POINT;
	}
	
	
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
	
	@Override
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
	
    @Override
    public String getName() {
        return this.NAME;
    }
}
