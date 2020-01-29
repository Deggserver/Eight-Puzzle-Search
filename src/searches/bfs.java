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
                if(!(this.frontier.contains(child.state) || this.explored.contains(child.state))){
                    if(this.goal_test(child.state)) return child;
                    this.frontier.add(0 , child);
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
        final int[] EASYEST =   {1 , 2 , 3 , 8 , 6 , 4 , 7 , 5 , 0};

        bfs test = new bfs(EASY, GOAL);
        test.solve().show_progression_path();
    }
}
