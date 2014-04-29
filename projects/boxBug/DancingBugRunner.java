import java.util.Random;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class DancingBugRunner{
    public static void main(String[]args){
	ActorWorld world = new ActorWorld();
	Random rng = new Random();
	int[]data = new int[10];
	for(int i = 0; i < data.length; i ++){
	    data[i] = rng.nextInt(8);
	}
	DancingBug alice = new DancingBug(data, 5);
	alice.setColor(Color.ORANGE);
	world.add(new Location(5,5), alice);
	world.show();
    }
}