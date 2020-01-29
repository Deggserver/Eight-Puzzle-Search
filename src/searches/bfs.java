package searches;

import com.sun.org.apache.bcel.internal.generic.GotoInstruction;
import node.Node;

import java.util.ArrayList;

public class bfs {
    final public int[] goal_state;
    public ArrayList<Node> frontier;
    public ArrayList<int[]> explored;

    public bfs(int[] initial_state, int[] goal_state){
        Node root = new Node(initial_state);
        this.goal_state = goal_state;
        this.frontier = new ArrayList<>();
        this.explored = new ArrayList<>();
        frontier.add(root);
    }

    public Node solve(){
        while(true){
            if(this.frontier.isEmpty()) return null;
            Node current = this.frontier.remove(0);
            this.explored.add(current.state);
            for (Node child : current.expand()){
                if(!(this.frontier.contains(child)) || !(this.explored.contains(child.state))){
                    if(this.goal_test(child.state)) return child;
                    this.frontier.add(child);
                }
            }
        }
    }

    public boolean goal_test(int [] test_state){
        for (int i = 0; i < test_state.length; i++) {
            if(this.goal_state[i] != test_state[i]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        final int[] GOAL =      {1 , 2 , 3 , 8 , 0 , 4 , 7 , 6 , 5};
        final int[] EASY =      {1 , 3 , 4 , 8 , 6 , 2 , 7 , 0 , 5};
        final int[] MEDIUM =    {2 , 8 , 1 , 0 , 4 , 3 , 7 , 6 , 5};
        final int[] HARD =      {5 , 6 , 7 , 4 , 0 , 8 , 3 , 2 , 1};

        bfs test1 = new bfs(EASY, GOAL);
        System.out.println("---EASY---");
        test1.solve().show_progression_path();
        bfs test2 = new bfs(MEDIUM , GOAL);
        System.out.println("---MEDIUM---");
        test2.solve().show_progression_path();
        bfs test3 = new bfs(HARD , GOAL);
        System.out.println("---HARD---");
        test3.solve().show_progression_path();

    }
}
