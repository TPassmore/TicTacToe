package tictactoe;

public class gridTile {
    private boolean editable;
    private Symbol status;

    public gridTile(Symbol state, boolean editable) {
        this.status = state;
        this.editable = editable;
    }
    public void setStatus(Symbol state) {
        this.status = state;
    }
    public char getCharValue(){
        return status.getState();
    }

    public Symbol getStatus() {
        return status;
    }

    public boolean isEditable() {return editable;}

    public void setEditable(boolean editable) {this.editable = editable;}
}
