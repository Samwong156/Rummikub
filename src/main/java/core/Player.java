package core;
import java.util.Observable;
import java.util.Observer;

public abstract class Player implements Observer{
	
	protected String name;
	protected Hand hand; 
	protected Table table; // player can see table itself
	
	
	public Player (){ //should have player strategy
		
		hand = new Hand(); 
    	//should contain player strategy
    	table = new Table();

	}
	public void update(Observable obs, Object x) {
		Game update = (Game) obs;
		table = update.getTable();
		updateHand(update);
	}
	
	protected abstract void updateHand(Game update);
	
	protected abstract void play();
	
	@Override
	public String toString(){
		return name;
	}
}
