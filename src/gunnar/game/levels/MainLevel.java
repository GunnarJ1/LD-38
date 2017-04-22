package gunnar.game.levels;

import tek.game.Level;

public class MainLevel extends Level{

	@Override
	public void start() {
		createTexture("textures/texsheet.png");
		createShader("default", "shaders/default.vs", "shaders/default.fs");
	}

	@Override
	public void update(long delta) {
		
	}
	
	@Override
	public void end() {
		
	}

	@Override
	public void input(long delta) {
		// TODO Auto-generated method stub
		
	}

}