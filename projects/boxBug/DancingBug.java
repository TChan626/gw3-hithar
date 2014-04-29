import info.gridworld.actor.Bug; 

public class DancingBug extends Bug{
    private int steps;
    private int sideLength;
    private int[]data;
    private int i;

    public DancingBug(int[]data, int length){
	this.data = data;
	i = 0;
        steps = 0;
        sideLength = length;
    }

    public void act()
    {
        if (steps < sideLength && canMove()){
            move();
            steps++;
	}else{
	    for(int j = 0; j < data[i]; j ++){
		turn();
	    }
	    steps = 0;
	    i ++;
	}
	if(i == data.length - 1){
	    i = 0;
	}
    }
}
