package BlackJack;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Game {
	// Class instances
    private static final int INIT_RECEIVE_CARD_COUNT = 2;	// 매직넘버 (정체를 알 수 없지만 특정한 기능을 하는 숫자)를 피하기 위해 선언 

	public void play() {
		System.out.println("========= Black jack =========");
		Scanner sc = new Scanner(System.in);
		Rule rule = new Rule();
		CardDeck cardDeck = new CardDeck();
		
		List<Player> players = Arrays.asList(new Gamer("사용자1"), new Dealer());
		List<Player> initAfterPlayers = initPhase(cardDeck, players);
		List<Player> playingAfterPlayers = playingPhase(sc, cardDeck, initAfterPlayers);
		
		Player winner = rule.getWinner(playingAfterPlayers);
		System.out.println("승자는 " + winner.getName());
	}
	
	// Gamer는 CardDeck 내부에서 카드를 어떻게 뽑아주는지 알필요가 없음
	// cardDeck은 카드를 뽑아주는 것에, Gamer는 CardDeck에게 카드를 받는 것에 충실해야함
	private List<Player> playingPhase(Scanner sc, CardDeck cardDeck, List<Player> players) {
		List<Player> cardReceivedPlayers;
		while(true) {
			cardReceivedPlayers = receiveCardAllPlayers(sc, cardDeck, players);
			
			if(isAllPlayerTurnOff(cardReceivedPlayers)) {
					break;
			}
		}
		return cardReceivedPlayers;
	}
	
	
	// players와 같은 컬렉션 혹은 인스턴스는 java의 특성으로 인해 Call by reference이다.
	// 따라서 return을 하지않더라도 players는 변경 상태를 유지한다 
	// 그럼에도 return을 하는 이유는 이 함수의 목적을 명확히 하기 위함이다.
	private List<Player> receiveCardAllPlayers(Scanner sc, CardDeck cardDeck, List<Player> players) {
		for(Player player : players) {
			if(isReceiveCard(sc)) {
				Card card = cardDeck.draw();
				player.receiveCard(card);
				player.turnOn();
			}else {
				player.turnOff();
			}
		}
		return players;
	}
	
	private boolean isAllPlayerTurnOff(List<Player> players){
		for(Player player : players) {
			if(player.isTurn()) {
				return false;
			}
		}
	}
	
	private boolean isReceiveCard(Scanner sc) {
			System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
			return !STOP_RECEIVE_CARD.equals(sc.nextLine());	
	}
	
    private List<Player> initPhase(CardDeck cardDeck, List<Player> players){
        System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");
        for(int i=0;i<INIT_RECEIVE_CARD_COUNT;i++) {
        	for(Player player : players) {
	            Card card = cardDeck.draw();
	            player.receiveCard(card);
	        }
        }
        return players;
    }
}
