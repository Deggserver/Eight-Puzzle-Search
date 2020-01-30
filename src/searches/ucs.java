package searches;

import node.Node;

import java.util.*;

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
                if(!(frontier_or_explored_contains(child))){
                    this.frontier.add(child);
                }else{
                    this.does_current_cost_less(current);
                }
            }
        }
    }

    public void does_current_cost_less(Node curr){
        Node[] copy = new Node[this.frontier.size()];
        this.frontier.toArray(copy);
        for (int i = 0; i < copy.length; i++) {
            if(curr.state == copy[i].state && curr.path_cost < copy[i].path_cost) copy[i] = curr;
        }
        this.frontier.clear();
        for (Node n : copy){
            this.frontier.add(n);
        }
    }

    public boolean goal_test(int [] test_state){
        for (int i = 0; i < test_state.length; i++) {
            if(this.goal_state[i] != test_state[i]) return false;
        }
        return true;
    }

    public boolean frontier_or_explored_contains(Node c){
        for (Node n : this.frontier){
            if(n.parent == c.parent && n.path_cost == c.path_cost && n.state == c.state && n.action == c.action && n.depth == c.depth) return true;
        }
        for (int[] state : this.explored){
            if(Arrays.equals(state , c.state)) return true;
        }
        return false;
    }


    public static void main(String[] args){
        final int[] GOAL =      {1 , 2 , 3 , 8 , 0 , 4 , 7 , 6 , 5};
        final int[] EASY =      {1 , 3 , 4 , 8 , 6 , 2 , 7 , 0 , 5};
        final int[] MEDIUM =    {2 , 8 , 1 , 0 , 4 , 3 , 7 , 6 , 5};
        final int[] HARD =      {5 , 6 , 7 , 4 , 0 , 8 , 3 , 2 , 1};

        ucs test1 = new ucs(EASY, GOAL);
        System.out.println("---EASY---");
        test1.solve().show_progression_path();
        ucs test2 = new ucs(MEDIUM , GOAL);
        System.out.println("---MEDIUM---");
        test2.solve().show_progression_path();
        ucs test3 = new ucs(HARD , GOAL);
        System.out.println("---HARD---");
        test3.solve().show_progression_path();

    }
}
