package BlackJack;
import java.util.Scanner;

public class Game {
	// Class instances
	public void play() {
		System.out.println("========= Black jack =========");
		Scanner sc = new Scanner(System.in);
		
		Dealer delear = new Dealer();
		Gamer gamer = new Gamer();
		Rule rule = new Rule();
		CardDeck cardDeck = new CardDeck();
		
        initPhase(cardDeck, gamer);		
		playingPhase(sc, cardDeck, gamer);
	}
	
	// Gamer�� CardDeck ���ο��� ī�带 ��� �̾��ִ��� ���ʿ䰡 ����
	// cardDeck�� ī�带 �̾��ִ� �Ϳ�, Gamer�� CardDeck���� ī�带 �޴� �Ϳ� ����ؾ���
	private void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer) {
		String gamerInput;
		while(true) {
			System.out.println("ī�带 �̰ڽ��ϱ�? ���Ḧ ���Ͻø� 0�� �Է��ϼ���.");
			gamerInput = sc.nextLine();
			
			if("0".equals(gamerInput)) {
				break;
			}
			
			Card card = cardDeck.draw();
			gamer.receiveCard(card);
		}
		
	}
	
    private static final int INIT_RECEIVE_CARD_COUNT = 2;
    private void initPhase(CardDeck cardDeck, Gamer gamer){
        System.out.println("ó�� 2���� ī�带 ���� �̰ڽ��ϴ�.");
        for(int i=0;i<INIT_RECEIVE_CARD_COUNT;i++) {
            Card card = cardDeck.draw();
            gamer.receiveCard(card);
        }
    }
}
