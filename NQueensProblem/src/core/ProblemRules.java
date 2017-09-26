package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import general.search.agent.ia.DomainRules;
import general.search.agent.ia.SearchNode;
import general.search.agent.ia.State;
import general.search.agent.ia.StateAction;

public class ProblemRules implements DomainRules{

	private int problemSize;
	
	public ProblemRules(int problemSize) {
		this.problemSize = problemSize;
	}

	private POS_STATE[][] deepCopy(POS_STATE[][] original) {
	    if (original == null) {
	        return null;
	    }

	    final POS_STATE[][] result = new POS_STATE[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return result;
	}
	
	private POS_STATE[][] getNewStateInfo(POS_STATE [][]m, int line, int column) {			
	  
	  int i = 0;
	  int s = m.length;
	  int  ld1 = line;
	  int lu1 = line;
	  int cr1 = column;
	  int cl1 = column;
	  int ld2 = line;
	  int lu2 = line;
	  int cr2 = column;
	  int cl2 = column;
	  POS_STATE[][] matrix = deepCopy(m);
	  
	  for(i = 0; i < s; i++){
	  
	  	// invalidate line
		matrix[line][i] = POS_STATE.INVALID;
	    
	    // invalidate columns
		matrix[i][column] = POS_STATE.INVALID;
	     
	    // invalidate diagonals
	    if(ld1 <= s - 1 && cr1 <= s - 1){
	        matrix[ld1++][cr1++] = POS_STATE.INVALID;
	    }
	    
	    if(lu1 >= 0 && cl1 >= 0){
	      matrix[lu1--][cl1--] = POS_STATE.INVALID;;
	    } 
	    
	    if(ld2 <= s - 1 && cl2 >= 0){
	        matrix[ld2++][cl2--] = POS_STATE.INVALID;;
	    }
	    
	    if(lu2 >= 0 && cr2 <= s - 1){
	      matrix[lu2--][cr2++] = POS_STATE.INVALID;;
	    } 
	  }
	  
	  matrix[line][column] = POS_STATE.OCUPIED;
	  
	  return matrix;				
	}
	
	@Override
	public List<StateAction> getChildrenOf(SearchNode node) {
		
		// we have d queens in each depth		
		List<StateAction> actions = new ArrayList<StateAction>();
		POS_STATE [][]matrix = ((ProblemState)node.getState()).getStateInfo();
		ProblemState state = (ProblemState)node.getState();
		
		for(int i = 0; i < problemSize; i++) {
			for(int j = 0; j < problemSize; j++) {		
				if(matrix[i][j] != POS_STATE.FREE) {
					continue;
				}				
				
				POS_STATE [][] newMatrix = getNewStateInfo(matrix, i, j);
				ProblemAction action = new ProblemAction(1);
				ProblemState probState = new ProblemState("" + newMatrix.hashCode(), newMatrix, state.getQueens() + 1);
				StateAction stateAction = new StateAction(probState, action);
				actions.add(stateAction);
			}
		}
		
		return actions;
	}

	@Override
	public boolean isGoal(SearchNode node) {
		return ((ProblemState)node.getState()).getQueens() == problemSize;
	}

	@Override
	public State getInitialState() {		
		POS_STATE [][] matrix = new POS_STATE[problemSize][problemSize];	
		for(int i = 0; i < problemSize; i++) {
			for(int j = 0; j < problemSize; j++) {
				matrix[i][j] = POS_STATE.FREE;
			}			
		}		
		return new ProblemState("1", matrix, 0);
	}

}
