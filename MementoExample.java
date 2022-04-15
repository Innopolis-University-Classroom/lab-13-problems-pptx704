import java.util.Stack;

class Editor {
    History history;
    
    public Editor(){
        this.history = new History();
        history.push(new Memento(""));
    }

    public void write(String s){
        Memento m = new Memento(getString() + s);
        history.push(m);
    }

    public void undo(){
        history.undo();
    }

    public String getString(){
        return this.history.cursor.state;
    }

    public void print(){
        System.out.println(getString());
    }
}

class History {
    Stack<Memento> stack;
    Memento cursor;

    public History() {
        this.stack = new Stack<>();
    }

    void push(Memento memento){
        this.stack.add(memento);
        cursor = this.stack.peek();
    }

    void undo(){
        this.stack.pop();
        cursor = this.stack.peek();
    }
}

class Memento {
    String state;

    public Memento(String s){
        this.state = s;
    }
}

public class MementoExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.write("Hello ");
        editor.write("World");
        editor.print();
        editor.undo();
        editor.print();
    }
}