package searches;

import node.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class dfs {
    final public int[] goal_state;
    public ArrayList<Node> frontier;
    public ArrayList<int[]> explored;

    public int time = 0;
    public int space = 0;

    public dfs(int[] initial_state, int[] goal_state){
        Node root = new Node(initial_state);
        this.goal_state = goal_state;
        this.frontier = new ArrayList<>();
        this.explored = new ArrayList<>();
        frontier.add(root);
    }

    public Node solve(){
        while(true){
            if (space < this.frontier.size()) space = this.frontier.size();
            if(this.frontier.isEmpty()) return null;
            Node current = this.frontier.remove(0);
            time+=1;
            this.explored.add(current.state);
            for (Node child : current.expand()){
                if(!(frontier_or_explored_contains(child))){
                    if(this.goal_test(child.state)) return child;
                    this.frontier.add(0 , child);
                }
            }
        }
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

    public boolean goal_test(int [] test_state){
        for (int i = 0; i < test_state.length; i++) {
            if(this.goal_state[i] != test_state[i]) return false;
        }
        return true;
    }

    public void get_time_space(){
        System.out.println("Time: "+time+" Space: "+space);
    }

    public static void main(String[] args){
        final int[] GOAL =      {1 , 2 , 3 , 8 , 0 , 4 , 7 , 6 , 5};
        final int[] EASY =      {1 , 3 , 4 , 8 , 6 , 2 , 7 , 0 , 5};
        final int[] MEDIUM =    {2 , 8 , 1 , 0 , 4 , 3 , 7 , 6 , 5};
        final int[] HARD =      {5 , 6 , 7 , 4 , 0 , 8 , 3 , 2 , 1};

        dfs test1 = new dfs(EASY, GOAL);
        System.out.println("---EASY---");
        test1.solve().show_progression_path();
        test1.get_time_space();
        dfs test2 = new dfs(MEDIUM , GOAL);
        System.out.println("---MEDIUM---");
        test2.solve().show_progression_path();
        test2.get_time_space();
        dfs test3 = new dfs(HARD , GOAL);
        System.out.println("---HARD---");
        test3.solve().show_progression_path();
        test3.get_time_space();
    }

}
