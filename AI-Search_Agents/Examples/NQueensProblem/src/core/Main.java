package core;

import general.search.agent.ia.SearchNode;
import seach.agent.ia.DFSAgent;

public class Main {

	public static void main(String[] args) {
		
		int problemSize = 8;
		ProblemRules rules = new ProblemRules(problemSize);
		DFSAgent agent = new DFSAgent(rules);		
		
		// this line returns a list of nodes that compose the solution,
		// but for this problem, I will not show the entire path, just the goal node
		agent.resolve();
		
		SearchNode goal = agent.getGoalNode();		
		if(goal == null) {			
			System.out.println("Cannot find a solution");			
		}else {		
			System.out.println(goal.getState().toString());
		}
	}

}
