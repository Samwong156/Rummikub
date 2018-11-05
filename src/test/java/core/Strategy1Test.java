package core;

import junit.framework.TestCase;

public class Strategy1Test extends TestCase {
	public void testHasSet() {
		Tile[] tArr = {new Tile(Tile.colour.BLUE, Tile.value.NINE), new Tile(Tile.colour.GREEN, Tile.value.NINE), new Tile(Tile.colour.RED, Tile.value.NINE), new Tile(Tile.colour.RED, Tile.value.TEN),new Tile(Tile.colour.BLUE, Tile.value.TEN),new Tile(Tile.colour.GREEN, Tile.value.TEN),new Tile(Tile.colour.ORANGE, Tile.value.TEN),new Tile(Tile.colour.RED, Tile.value.TEN),new Tile(Tile.colour.BLUE, Tile.value.TEN),new Tile(Tile.colour.GREEN, Tile.value.TEN),new Tile(Tile.colour.ORANGE, Tile.value.TEN)};
		Hand h = new Hand(tArr);
		Strategy1 p = new Strategy1(h);

		assertNotNull(p.playableSets());
	}
	
	public void testPlayTile() {
		Tile[] tArr1 = {new Tile(Tile.colour.RED, Tile.value.TEN),new Tile(Tile.colour.BLUE, Tile.value.TEN),new Tile(Tile.colour.ORANGE, Tile.value.TEN)};
		Meld m1 = new Meld(tArr1);
		Meld[] mArr = {m1};
		Table t1 = new Table(mArr);
		Tile[] tArr = {new Tile(Tile.colour.GREEN, Tile.value.TEN)};
		Hand h = new Hand(tArr);
		Strategy1 p = new Strategy1(h,t1);
		
		p.play();
		assertTrue(p.getHand().isEmpty());
	}

	public void testPlayMeld() {
		Tile[] tArr = {new Tile(Tile.colour.BLUE, Tile.value.NINE), new Tile(Tile.colour.GREEN, Tile.value.NINE), new Tile(Tile.colour.RED, Tile.value.NINE)};
		Meld m = new Meld(new Tile[]{new Tile(Tile.colour.BLUE, Tile.value.NINE), new Tile(Tile.colour.GREEN, Tile.value.NINE), new Tile(Tile.colour.RED, Tile.value.NINE)});
		Hand h = new Hand(tArr);
		Strategy1 p = new Strategy1(h);
		p.playMeld(m);
		assertTrue(p.getHand().isEmpty());
	}

	public void testHasRuns() {
		Tile[] tArr = {new Tile(Tile.colour.RED, Tile.value.TEN),new Tile(Tile.colour.RED, Tile.value.ELEVEN),new Tile(Tile.colour.RED, Tile.value.TWELVE),new Tile(Tile.colour.RED, Tile.value.THIRTEEN),new Tile(Tile.colour.BLUE, Tile.value.TEN),new Tile(Tile.colour.BLUE, Tile.value.TEN),new Tile(Tile.colour.BLUE, Tile.value.TWELVE),new Tile(Tile.colour.ORANGE, Tile.value.ONE),new Tile(Tile.colour.ORANGE, Tile.value.TWO),new Tile(Tile.colour.ORANGE, Tile.value.THREE)};
		Hand h = new Hand(tArr);
		Strategy1 p = new Strategy1(h);
		assertNotNull(p.playableRuns());
	}
}
