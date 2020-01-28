package node;

import java.util.ArrayList;

public class Board_Node{

    int[][] board;          //board[x][y] x is row, y in column
    Board_Node parent;
    ArrayList<Board_Node> children;
    int zero_x, zero_y;
    String action;          //how the blank got to its current location
    int depth;
    int cost;
    boolean expanded = false;

    /**
     *
     * @param current_layout    parent node's board
     * @param parent            node.Board_Node that called the contructor
     * @param depth             what ply this node is in
     * @param x                 the x location of the zero tile in the parent node
     * @param y                 the y location of the zero tile in the parent node
     * @param new_x             the x location to move the zero tile to
     * @param new_y             the y location to move the zero tile to
     */
    public Board_Node(int[][] current_layout , Board_Node parent , int depth,  int x , int y , int new_x , int new_y){
        this.board = current_layout.clone();
        this.swap_zero_location(x , y , new_x , new_y);
        this.action = compute_how_zero_moved(x , y , new_x , new_y);
        this.parent = parent;
        this.depth = depth;
        this.cost = this.board[x][y];
        this.zero_x = new_x;
        this.zero_y = new_y;
        generate_children();
    }

    /**
     *
     * @param x1 start x
     * @param y1 start y
     * @param x2 target x
     * @param y2 target y
     */
    private String compute_how_zero_moved(int x1 , int y1 , int x2 , int y2){
        if(x1 > x2) return "up";
        if(x1 < x2) return "down";
        if(y1 > y2) return "left";
        return "right";
    }

    /**
     *
     * @param x1 start x
     * @param y1 start y
     * @param x2 target x
     * @param y2 target y
     */
    private void swap_zero_location(int x1 , int y1 , int x2 , int y2){
        int tmp;
        tmp = this.board[x1][y1];
        this.board[x1][y1] = this.board[x2][y2];
        this.board[x1][y1] = tmp;
    }

    public int getCost(){
        return this.cost;
    }

    /**
     * generates 4 possible moves from zero-tile's loction
     * prunes the ones that go out of bounds
     * adds valid ones to this's children arraylist
     */
    public void generate_children(){
        //up down left right
        int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i<4; i++){
            if(valid_state(this.zero_x + moves[i][0], this.zero_y + moves[i][1])){
                this.add_child(new Board_Node(this.board, this, this.depth+1, this.zero_x, this.zero_y, this.zero_x + moves[i][0], this.zero_y + moves[i][1]));
            }
        }
    }

    /**
     *
     * @param x the proposed new row location for the blank tile
     * @param y the proposed new column location for the blank tile
     * @return  a boolean meaning that the proposed state is valid or invalid
     */
    private boolean valid_state(int x, int y){
        if(0 <= x && x <= 2){
            if(0 <= y && y <= 2){
                if(new int[] {x,y} != this.parent.get_zero_loction()) return true;
            }
        }
        else return false;
    }

    public void add_child(Board_Node c){
        this.children.add(c);
    }

    public ArrayList<Board_Node> get_children(){
        return this.children;
    }

    public int[] get_zero_loction(){
        return new int[] {zero_x, zero_y}
    }
}
