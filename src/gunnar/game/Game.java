//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game;

import org.joml.Vector2f;

import tek.audio.Music;
import tek.game.Interface;
import tek.game.Level;
import tek.input.Keyboard;
import tek.input.Mouse;
import tek.render.Shader;
import tek.runtime.Scene;
import tek.ui.UIFont;
import tek.ui.UIScene;
import tek.ui.UIText;
import tek.ui.UITexture;

public class Game implements Interface
{
	
	Music music;
	
	public Level level;
	
	public UIFont test;
	public UIScene ui;
	
	public UITexture texture;
	public UIText text;
	
	
	public void loadLevel(Level level){
		if(this.level != null)
			level.end();
		
		this.level = level;
		level.start();
	}
	
	@Override
	public void start() {
		preInit();
		
		UIText testing = new UIText("LD Game");
		
		Scene.current.uiScene.texts.add(testing);
		
	}

	@Override
	public void end() {
		
	}

	@Override
	public void input(long delta) {
		
	}

	@Override
	public void update(long delta) {
		
	}

	@Override
	public void render(long delta) {
	}

	
	private void preInit() {
		
		UIScene.defaultShader = new Shader("ui", "shaders/ui.vs", "shaders/ui.fs");
		ui = Scene.current.uiScene;
	}
	
}
