package node;

public class State_Space {

    final int[] Goal =      {1 , 2 , 3 , 8 , 0 , 4 , 7 , 6 , 5};
    final int[] Easy =      {1 , 3 , 4 , 8 , 6 , 2 , 7 , 0 , 5};
    final int[] Medium =    {2 , 8 , 1 , 0 , 4 , 3 , 7 , 6 , 5};
    final int[] Hard =      {5 , 6 , 7 , 4 , 0 , 8 , 3 , 2 , 1};

    Board_Node root;

    public State_Space(Board_Node curr){
        this.root = curr;
    }

    /**
     * this is a hard-coded solution that assumes the input array is mean to be formatted into a 3 x 3 array.
     * @param in    Input 1 dimensional array
     * @return      The conversion of the in array to a matrix.
     */
    private int[][] refactor_array(int [] in){
        int[][] out = {{in[0] , in[1] , in[2]} , {in[3] , in[4] , in[5]} , {in[6] , in[7] , in[8]}};
        return out;
    }

    public static void main(String[] args){

    }
}
