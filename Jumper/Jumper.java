package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Jumper extends Actor{
    
    public Jumper(){
	setColor(Color.RED);
    }

    public Jumper(int direction, Color color){
	setDirection(direction);
	setColor(color);
    }
    
    public void act(){
	if(canJump()){
	    jump();
	}else{
	    turn();
	}
    }

    public void turn(){
	setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void jump(){
	Grid<Actor> gr = getGrid();
	if(gr == null){
	    return;
	}
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	Location nextNext = next.getAdjacentLocation(getDirection());
	
	if(gr.isValid(next) && gr.isValid(nextNext)){
	    moveTo(nextNext);
	}else{
	    removeSelfFromGrid();
	}
    }

    public boolean canJump(){
	Grid<Actor> gr = getGrid();
	if(gr == null){
	    return false;
	}
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	Location nextNext = next.getAdjacentLocation(getDirection());
	
	if(!gr.isValid(next) || !gr.isValid(nextNext)){
	    return false;
	}
	
	Actor neighbor = gr.get(next);
	Actor nextNeighbor = gr.get(nextNext);
	return (neighbor == null) || (neighbor instanceof Flower) || (neighbor instanceof Rock);
    }
}
