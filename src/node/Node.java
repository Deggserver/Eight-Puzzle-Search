package node;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Node {
    public int[] state;
    public Node parent;
    public String action;
    public int depth;
    public int path_cost;
    public boolean expanded;

    /**
     * Contructor for root state node;
     * @param s initial state array
     */
    public Node(int[] s){
        this.state = s;
        this.parent = null;
        this.action = null;
        this.depth = 0;
        this.path_cost = 0;
        this.expanded = false;
    }

    /**
     *
     * @param s
     * @param p
     * @param a
     * @param c
     */
    public Node(int [] s, Node p, String a, int c){
        this.state = s;
        this.parent = p;
        this.action = a;
        this.depth = this.parent.depth + 1;
        this.path_cost = this.parent.path_cost + c;
        this.expanded = false;
    }

    /**
     * generates 4 possible moves of zero-tile's location
     * prunes the ones that go out of bounds
     * returns valid ones
     */
    public ArrayList<Node> expand(){
        ArrayList<Node> out = new ArrayList<>();
        int zero = index_of_zero();
        //up
        if(zero >= 3){
            int tmp[] = this.state.clone();
            tmp[zero] = tmp[zero-3];
            tmp[zero-3] = 0;
            out.add(new Node(tmp, this, "up", tmp[zero]));
        }
        //down
        if(zero <= 5){
            int tmp[] = this.state.clone();
            tmp[zero] = tmp[zero+3];
            tmp[zero+3] = 0;
            out.add(new Node(tmp, this, "down", tmp[zero]));
        }
        //left
        if(zero > 0){
            int tmp[] = this.state.clone();
            tmp[zero] = tmp[zero-1];
            tmp[zero-1] = 0;
            out.add(new Node(tmp, this, "left", tmp[zero]));
        }
        //right
        if(zero < 8){
            int tmp[] = this.state.clone();
            tmp[zero] = tmp[zero+1];
            tmp[zero+1] = 0;
            out.add(new Node(tmp, this, "right", tmp[zero]));
        }
        return out;
    }

    public int index_of_zero(){
        for (int i = 0; i < this.state.length; i++) {
            if(this.state[i] == 0) return i;
        }
        return -1;
    }

}
