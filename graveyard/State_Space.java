package node;

import searches.*;

public class State_Space {

    final int[] GOAL =      {1 , 2 , 3 , 8 , 0 , 4 , 7 , 6 , 5};
    final int[] EASY =      {1 , 3 , 4 , 8 , 6 , 2 , 7 , 0 , 5};
    final int[] MEDIUM =    {2 , 8 , 1 , 0 , 4 , 3 , 7 , 6 , 5};
    final int[] HARD =      {5 , 6 , 7 , 4 , 0 , 8 , 3 , 2 , 1};

    Board_Node root, current;

    public State_Space(Board_Node curr){
        this.root = curr;
        this.current = curr;
    }

    /**
     * this is a hard-coded solution that assumes the input array is mean to be formatted into a 3 x 3 array.
     * @param in    Input 1 dimensional array
     * @return      The conversion of the in array to a matrix.
     */
    public int[][] refactor_array(int [] in){
        int[][] out = {{in[0] , in[1] , in[2]} , {in[3] , in[4] , in[5]} , {in[6] , in[7] , in[8]}};
        return out;
    }

    public void show_board(){
        for (int[] x : this.current.board){
            for (int y : x){
                System.out.print(" y");
            }
            System.out.println();
        }
    }

    public void main(String[] args){
        State_Space test = new State_Space(new Board_Node(this.refactor_array(EASY), null, 0, 2, 2 ,3, 2));
        te  st.show_board();
    }
}
