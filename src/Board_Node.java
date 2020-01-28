public class Board_Node{

    int[][] board;          //board[x][y] x is row, y in column
    Board_Node parent;
    int zero_x, zero_y;
    String action;          //how the blank got to its current location
    int depth;
    int cost;
    boolean expanded = false;

    /**
     *
     * @param current_layout    parent node's board
     * @param parent            Board_Node that called the contructor
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
}
