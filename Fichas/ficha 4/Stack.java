import java.util.ArrayList;

public class Stack {
    private ArrayList<String> stack;

    //Construtor por omissao
    public Stack(){
        this.stack = new ArrayList<>(); 
    }

    //Construtor parametrizado

    public Stack(ArrayList<String> stacks){
        this.stack = new ArrayList<>(stacks);
    }

    //Construtor copia

    public Stack (Stack s){
        this.stack = s.getStack();
    }

    public ArrayList<String> getStack(){
        return this.stack;
    }

    public void setStack(ArrayList<String> s){
        this.stack = s;
    }
    
    public String toString() {
        return "Stack{" + "stack=" + stack + '}';
    }

    public Stack clone(){
        return new Stack(this);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Stack s = (Stack) o;
        return (this.stack == s.stack);
    }

     //Método que vai ver o elemento que está no topo da stack
    public String top(){
        return this.stack.get(this.stack.size()-1);
    }

    //Insere no topo;
    public void push(String s){
        this.stack.add(s);
    }

    //Remove o elemento do topo da stack, se esta não estiver vazia
    public void pop(){
        this.stack.remove(this.stack.size()-1);
    }
    //Determina se a stack está vazia;
    public boolean empty(){
        return this.stack.isEmpty();
    }

    //Determina o comprimento da stack
    public int lenght(){
        return this.stack.size();
    }
}
