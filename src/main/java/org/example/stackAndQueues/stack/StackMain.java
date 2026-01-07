package org.example.stackAndQueues.stack;

public class StackMain {

    public static void main (String[] args) throws StackException {
        DynamicStack stack = new DynamicStack(5);

        stack.push(58);
        stack.push(32);
        stack.push(87);
        stack.push(12);
        stack.push(10);
        stack.push(15);
        stack.push(17);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
