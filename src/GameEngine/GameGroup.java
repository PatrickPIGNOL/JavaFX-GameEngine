package GameEngine;

import javafx.scene.Group;

public class GameGroup extends Group implements IGameGroup
{
	public GameGroup()
	{
		super();
	}

	@Override
	public void mOnResized(Dimensions pScreen) 
	{
		System.out.println("Width : " + pScreen.getWidth() + ", Height : " + pScreen.getHeight());
	}
}
