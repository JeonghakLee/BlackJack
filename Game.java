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
	
	// Gamer는 CardDeck 내부에서 카드를 어떻게 뽑아주는지 알필요가 없음
	// cardDeck은 카드를 뽑아주는 것에, Gamer는 CardDeck에게 카드를 받는 것에 충실해야함
	private void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer) {
		String gamerInput;
		while(true) {
			System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
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
        System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
        for(int i=0;i<INIT_RECEIVE_CARD_COUNT;i++) {
            Card card = cardDeck.draw();
            gamer.receiveCard(card);
        }
    }
}
