import info.gridworld.actor.Bug;

public class ZBug extends Bug{
    private int zSideLength;
    private int steps;
    private int zSide;

    public ZBug(int length){
        steps = 0;
	zSide = 1;
        zSideLength = length;
	turn();
	turn();
    }

    public void act()
    {
        if (zSide <= 3 && steps < zSideLength){
	    if(canMove()){
		move();
		steps++;
	    }
	}else if(zSide == 1){
	    for(int i = 0; i < 3; i ++){
		turn();
	    }
	    steps = 0;
	    zSide ++;
	}else if(zSide == 2){
	    for(int i = 0; i < 5; i ++){
		turn();
	    }
	    steps = 0;
	    zSide ++;
	}
    }
}
