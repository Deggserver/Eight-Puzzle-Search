package searches;

import node.Board_Node;

public class dfs {
    public Board_Node current;
    public dfs(Board_Node n){
        this.current = n;
    }

    public Board_Node choose_child(){
        for (Board_Node n : this.current.get_children()) {

        }
    }

    public Board_Node go_back(){

    }
}
