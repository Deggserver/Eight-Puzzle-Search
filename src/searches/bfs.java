package searches;

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

    }

}
