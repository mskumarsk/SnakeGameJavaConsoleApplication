package aaa.snakegame;

public class Position {
    private int head;
    private int tail;
    Position(int head,int tail){
        this.head=head;
        this.tail=tail;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}
