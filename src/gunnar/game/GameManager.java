package gunnar.game;

public class GameManager {
	
	private static int score;
	
	int GetScore() {
		return score;
	}
	
	void SetScore(int sco) {
		score = sco;
	}
	
	void AddScore(int addition) {
		score += addition;
	}
	
}
