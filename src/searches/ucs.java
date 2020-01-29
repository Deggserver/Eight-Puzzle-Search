package searches;

import node.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;

public class ucs {
    final public int[] goal_state;
    public PriorityQueue<Node> frontier;
    public ArrayList<int[]> explored;

    Comparator<Node> node_cost_Comparator = new Comparator<Node>() {
        public int compare(Node n1, Node n2) {
            return n1.path_cost - n2.path_cost;
        }
    };

    public ucs(int[] initial_state, int[] goal_state){
        Node root = new Node(initial_state);
        this.goal_state = goal_state;
        this.frontier = new PriorityQueue<>(node_cost_Comparator);
        this.explored = new ArrayList<>();
        frontier.add(root);
    }

    public Node solve(){
        while(true){
            if(this.frontier.isEmpty()) return null;
            Node current = this.frontier.remove();
            if(this.goal_test(current.state));
            this.explored.add(current.state);
            for (Node child : current.expand()){
                if(!(this.frontier.contains(child)) || !(this.explored.contains(child.state))){
                    this.frontier.add(child);
                }else if(this.frontier.contains(current)){

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
}
