package tek.game.levels;

import tek.game.Level;
import tek.game.gameObjects.PhysicsDummy;
import tek.runtime.GameObject;
import tek.runtime.Scene;

public class TestLevel extends Level{

	@Override
	public void start() {
		System.out.println("Loaded default shader.");
		createShader("default", "shaders/default.vs", "shaders/default.fs");
	}

	@Override
	public void update(long delta) {
		
	}
	
	@Override
	public void end() {
		
	}

}
