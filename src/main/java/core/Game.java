package core;

import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Game extends Observable{ 
	private Pile pile;
	private Table table;
	private CLI cli;
	private Hand h0;
	private Hand h1;
	private Hand h2;
	private Hand h3;
	private Player playerArr[];

	public void init() {
		pile = new Pile();
		table = new Table();
		cli = new CLI();
		h0 = new Hand();
		h1 = new Hand();
		h2 = new Hand();
		h3 = new Hand();
		playerArr = new Player[4];

		playerArr[0] = new Player("human", 0);
		playerArr[1] = new Player("p1", 1);
		playerArr[2] = new Player("p2", 2);
		playerArr[3] = new Player("p3", 3);
		pile.scramble();
		
		this.addObserver(playerArr[0]);
		this.addObserver(playerArr[1]);
		this.addObserver(playerArr[2]);
		this.addObserver(playerArr[3]);
	}
	
	//init(file)
	
	public void start() {
		cli.message("Welcome To Rummikub!");
		deal(h0);
		deal(h1);
		deal(h2);
		deal(h3);
		turnLoop();
	}
	
	private Player turnLoop() {
		
		for(int i = 0; i<4; i++) {
			cli.message("Player " + playerArr[i].toString() + "'s turn.");
			
			
			
			if(i==3) i=-1;
		}

		return null;
	}
	
	private void deal(Hand hand) {
		for(int i = 0; i<14; i++) {
			hand.addTileTop_hand(pile.deal());
		}
		broadcast();
	}
	
	private void broadcast() {
		notifyObservers();
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public ArrayList<Hand> gethands() {
		ArrayList<Hand> hands  = new ArrayList<Hand>();
		hands.add(h0);
		hands.add(h1);
		hands.add(h2);
		hands.add(h3);
		return hands;
		
	}

	public Hand getH0() {
		return h0;
	}

	public void setH0(Hand h0) {
		this.h0 = h0;
	}

	public Hand getH1() {
		return h1;
	}

	public void setH1(Hand h1) {
		this.h1 = h1;
	}

	public Hand getH2() {
		return h2;
	}

	public void setH2(Hand h2) {
		this.h2 = h2;
	}

	public Hand getH3() {
		return h3;
	}

	public void setH3(Hand h3) {
		this.h3 = h3;
	}
	
	
}