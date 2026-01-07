package org.example.stackAndQueues.stack;

public class CustomStack {
     protected int[] data;
     private static final int DEFAULT_LENGTH = 10;

     int ptr = -1;

     public CustomStack(){
         this(DEFAULT_LENGTH);
     }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
         if (isFull()){
             System.out.println("Stack is full");
             return false;
         }
         ptr++;
         data[ptr] = item;
         return true;
    }

    public int pop () throws StackException {
         if(isEmpty()){
             throw new StackException("Cannot remove item from empty stack !!");
         }
         int removed = data[ptr];
         ptr--;
         return removed;
    }

    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Stack is empty !!");
        }
        return data[ptr];
    }

    public boolean isFull() {
         return ptr == data.length - 1;
    }

    public boolean isEmpty() {
         return ptr == -1;
    }
}
