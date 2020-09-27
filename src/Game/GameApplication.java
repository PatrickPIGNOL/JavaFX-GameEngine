package Game;

import GameEngine.Dimensions;
import GameEngine.GameGroup;
import GameEngine.GameWindow;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class GameApplication extends Application 
{
	private GameWindow aWindow;
	private Scene aScene;
	private GameGroup aGroup;
	private Canvas aCanvas;
	private GraphicsContext aGraphicsContext;
	
	@Override
	public void start(Stage pStage) throws Exception 
	{
		this.aGroup = new GameGroup();
		this.aWindow = new GameWindow(this.aGroup, pStage, new Dimensions(800, 600), "NewJavaFX-GameBase", true);
		this.aWindow.mAddOnResisedListener(this.aGroup);
		this.aWindow.show();
	}
}
