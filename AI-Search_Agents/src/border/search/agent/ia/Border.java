package border.search.agent.ia;

import java.util.ArrayList;
import java.util.List;

import general.search.agent.ia.SearchNode;

public abstract class Border {

	protected List<SearchNode> elements;
	
	public Border() {
		elements = new ArrayList<SearchNode>();
	}

	public int getSize(){
		return elements.size();
	}
	
	public void add(SearchNode newState) {
		elements.add(newState);
	}
	
    //Just print out the underlying array list.
    @Override
    public String toString() {
    	return elements.toString();
    }
    
	public abstract SearchNode get();
}
