package BlackJack;
import java.util.Scanner;

public class Game {
	// Class instances
    private static final int INIT_RECEIVE_CARD_COUNT = 2;	// 매직넘버 (정체를 알 수 없지만 특정한 기능을 하는 숫자)를 피하기 위해 선언 

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
	
	// Gamer는 CardDeck 내부에서 카드를 어떻게 뽑아주는지 알필요가 없음
	// cardDeck은 카드를 뽑아주는 것에, Gamer는 CardDeck에게 카드를 받는 것에 충실해야함
	private void playingPhase(Scanner sc, CardDeck cardDeck, Gamer gamer, Dealer dealer) {
		String gamerInput, dealerInput;
		boolean isGamerTurn = false,
				isDealerTurn = false;
		
		while(true) {
			System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
			gamerInput = sc.nextLine();
			
			if("0".equals(gamerInput)) {
				break;
			}else{
				Card card = cardDeck.draw();
				gamer.receiveCard(card);
			}
			
			System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
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
        System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
        for(int i=0;i<INIT_RECEIVE_CARD_COUNT;i++) {
            Card card = cardDeck.draw();
            gamer.receiveCard(card);
            
            Card card2 = cardDeck.draw();
            dealer.receiveCard(card2);
        }
    }
}
