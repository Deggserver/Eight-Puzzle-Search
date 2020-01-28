public class State_Space {

    final int[] Goal =      {1 , 2 , 3 , 8 , 0 , 4 , 7 , 6 , 5};
    final int[] Easy =      {1 , 3 , 4 , 8 , 6 , 2 , 7 , 0 , 5};
    final int[] Medium =    {2 , 8 , 1 , 0 , 4 , 3 , 7 , 6 , 5};
    final int[] Hard =      {5 , 6 , 7 , 4 , 0 , 8 , 3 , 2 , 1};

    Board_Node root;

    public State_Space(Board_Node curr){
        this.root = curr;
    }

//    @ TODO: 1/28/2020
    private int[][] refactor_array(int [] in){
        return null;
    }

    public static void main(String[] args){

    }
}
