package GameEngine;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameWindow extends Stage
{
	private Scene aScene;
	List<IOnResizedListener> aResizedListeners;
	public GameWindow(GameGroup pGameGroup, Stage pStage, Dimensions pScreen, String pTitle, boolean pResizeable)
	{
		super(pStage.getStyle());
		this.aResizedListeners = new ArrayList<IOnResizedListener>();
		this.setTitle(pTitle);
		this.aScene = new Scene(pGameGroup, 800, 600);
		this.setScene(this.aScene);
		this.setResizable(pResizeable);
		this.widthProperty().addListener(new ChangeListener<Number>() 
		{
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) 
			{
				mOnResizedEvent();
			}
		});
		this.heightProperty().addListener(new ChangeListener<Number>() 
		{
			@Override
			public void changed(ObservableValue<? extends Number> pObservableValue, Number pOldValue, Number pNewValue) 
			{
				mOnResizedEvent();
			}
		});
	}
	
	public void mAddOnResisedListener(IOnResizedListener pOnResizedListener)
	{
		this.aResizedListeners.add(pOnResizedListener);
	}
	
	public void mRemoveOnResisedListener(IOnResizedListener pOnResizedListener)
	{
		this.aResizedListeners.remove(pOnResizedListener);
	}
		
	private void mOnResizedEvent()
	{
		for(IOnResizedListener vListener : this.aResizedListeners)
		{
			vListener.mOnResized(new Dimensions(this.getWidth(), this.getHeight()));
		}
	}
}
