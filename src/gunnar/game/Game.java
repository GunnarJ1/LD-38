//By Gunnar Jessee
//daApr 21, 2017
package gunnar.game;

import org.joml.Vector2f;

import gunnar.game.utils.LevelLoader;
import tek.Window;
import tek.game.Interface;
import tek.game.Level;
import tek.game.levels.TestLevel;
import tek.input.Keyboard;
import tek.render.Shader;
import tek.runtime.Scene;
import tek.ui.UIFont;
import tek.ui.UIScene;
import tek.ui.UIText;

public class Game implements Interface
{
	
	
	public Level level;
	public UIFont test;
	public UIScene ui;

	
	private static Game instance;
	public static Game GetInstance() {
		return instance;
	}
	
	public Game()
	{
		instance = this;
	}
	
	
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
		testing.set(new Vector2f(10, 10),  new Vector2f(100, 100));
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
		Keyboard.setupButton("horizontal", Keyboard.KEY_RIGHT, Keyboard.KEY_D, Keyboard.KEY_LEFT, Keyboard.KEY_A);
		Window.instance.setClearColor(0, .6f, .8f);
		Scene.current.camera.size = new Vector2f(Window.defaultWidth /4, Window.defaultHeight /4);
		// UI elements
		UIFont font = new UIFont("fonts/test.ttf", 12.0f);
		UIText.defaultFont = font;
		UIScene.defaultShader = new Shader("ui", "shaders/ui.vs", "shaders/ui.fs");
		ui = Scene.current.uiScene;
		
		loadLevel(new TestLevel());
		Shader shader = Shader.get("default");
		Scene.current.defaultShader = shader;
		LevelLoader.LoadLevel("level0");
	}
	
}
