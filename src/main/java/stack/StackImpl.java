package stack;

import java.util.LinkedHashSet;
import java.util.Set;

public class StackImpl<T> implements Stack<T>{

    //Set<T> stack = new LinkedHashSet<>();
    java.util.Stack<T> stack = new java.util.Stack<>();

    @Override
    public void push(T o) {
        stack.push(o);
    }

    @Override
    public T pop() {
        if(stack.size()==0){
            throw new IllegalStateException();
        }
        return stack.pop();
    }

    @Override
    public T peek() {
        if(stack.size()==0){
            throw new IllegalStateException();
        }
        return stack.peek();
    }
}
