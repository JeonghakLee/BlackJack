package BlackJack;
import java.util.Scanner;

public class Game {
	// Class instances
    private static final int INIT_RECEIVE_CARD_COUNT = 2;	// �����ѹ� (��ü�� �� �� ������ Ư���� ����� �ϴ� ����)�� ���ϱ� ���� ���� 

	public void play() {
		System.out.println("========= Black jack =========");
		Scanner sc = new Scanner(System.in);
		
		Dealer dealer = new Dealer();
		Gamer gamer = new Gamer();
		Rule rule = new Rule();
		CardDeck cardDeck = new CardDeck();
		
        initPhase(cardDeck, gamer, dealer);		
		playingPhase(sc, cardDeck, gamer, dealer);
	}
	
	// Gamer�� CardDeck ���ο��� ī�带 ��� �̾��ִ��� ���ʿ䰡 ����
	// cardDeck�� ī�带 �̾��ִ� �Ϳ�, Gamer�� CardDeck���� ī�带 �޴� �Ϳ� ����ؾ���
	private void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer, Dealer dealer) {
		String gamerInput, dealerInput;
		boolean isGamerTurn = false,
				isDealerTurn = false;
		
		while(true) {
			System.out.println("ī�带 �̰ڽ��ϱ�? ���Ḧ ���Ͻø� 0�� �Է��ϼ���.");
			gamerInput = sc.nextLine();
			
			if("0".equals(gamerInput)) {
				break;
			}else{
				Card card = cardDeck.draw();
				gamer.receiveCard(card);
			}
			
			System.out.println("ī�带 �̰ڽ��ϱ�? ���Ḧ ���Ͻø� 0�� �Է��ϼ���.");
			dealerInput = sc.nextLine();
			
			if("0".equals(dealerInput)) {
				break;
			}else{
				Card card = cardDeck.draw();
				dealer.receiveCard(card);
			}
			
			if(isGamerTurn && isDealerTurn) {
				break;
			}
		}
	}
	
    private void initPhase(CardDeck cardDeck, Gamer gamer, Dealer dealer){
        System.out.println("ó�� 2���� ī�带 ���� �̰ڽ��ϴ�.");
        for(int i=0;i<INIT_RECEIVE_CARD_COUNT;i++) {
            Card card = cardDeck.draw();
            gamer.receiveCard(card);
            
            Card card2 = cardDeck.draw();
            dealer.receiveCard(card2);
        }
    }
}
