package gunnar.game.utils;

public class Timer {

	private boolean isPaused;
	private float time;
	private float currentTime;

	public Timer() {
		this(10);
	}

	public Timer(float time) {
		currentTime = 0;
		isPaused = false;
		this.time = time;
	}

	public void update(float deltaTime) {
		if (currentTime >= time && !isPaused) {
			isPaused = true;
			System.out.println("time ran out!");
		}

		if (!isPaused)
			currentTime += 1 * (deltaTime / 1000.0);
	}

	public void resetTimer() {
		currentTime = 0;
		isPaused = false;
	}
	
	public void pause() {
		isPaused = true;
	}
	
	public void play() {
		isPaused = false;
	}
	
	public void setTime(float time) {
		this.time = time;
	}
	
	public float getTime() {
		return currentTime;
	}
	
	public boolean isPaused() {
		return isPaused;
	}
	
	public boolean isFinished() {
		return (currentTime >= time);
	}
	
}
