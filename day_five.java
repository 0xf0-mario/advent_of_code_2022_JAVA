import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class day_five {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // create 9 stacks, stack one will have characters D, H, N, Q, T, W, V, B from bottom to top
        // stack two will have characters D, W, B bottom to top
        // stack three will have characters T, S, Q< W< J, C bottom to top
        // stack four will have characters F, J, R, N, Z< T, P
        //stack five will have characters
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        Stack<Character> stack3 = new Stack<Character>();
        Stack<Character> stack4 = new Stack<Character>();
        Stack<Character> stack5 = new Stack<Character>();
        Stack<Character> stack6 = new Stack<Character>();
        Stack<Character> stack7 = new Stack<Character>();
        Stack<Character> stack8 = new Stack<Character>();
        Stack<Character> stack9 = new Stack<Character>();
        stack1.push('D');
        stack1.push('H');
        stack1.push('N');
        stack1.push('Q');
        stack1.push('T');
        stack1.push('W');
        stack1.push('V');
        stack1.push('B');
        stack2.push('D');
        stack2.push('W');
        stack2.push('B');
        stack3.push('T');
        stack3.push('S');
        stack3.push('Q');
        stack3.push('W');
        stack3.push('J');
        stack3.push('C');
        stack4.push('F');
        stack4.push('J');
        stack4.push('R');
        stack4.push('N');
        stack4.push('Z');
        stack4.push('T');
        stack4.push('P');
        // stack five will have G, P, V< J, M S, T
        // stack six will have B, W, F, T, N 
        //stack seven will have B, L, D< Q, F, H, V, N
        //stack eight will have H, P, F, R
        //stack nine will have Z< S, M, B, L, N, P, H
        stack5.push('G');
        stack5.push('P');
        stack5.push('V');
        stack5.push('J');
        stack5.push('M');
        stack5.push('S');
        stack5.push('T');
        stack6.push('B');
        stack6.push('W');
        stack6.push('F');
        stack6.push('T');
        stack6.push('N');
        stack7.push('B');
        stack7.push('L');
        stack7.push('D');
        stack7.push('Q');
        stack7.push('F');
        stack7.push('H');
        stack7.push('V');
        stack7.push('N');
        stack8.push('H');
        stack8.push('P');
        stack8.push('F');
        stack8.push('R');
        stack9.push('Z');
        stack9.push('S');
        stack9.push('M');
        stack9.push('B');
        stack9.push('L');
        stack9.push('N');
        stack9.push('P');
        stack9.push('H');
        // put all of them into a list 1 through 8 so we can access them easily
        List<Stack<Character>> stackList = new ArrayList<>();
        stackList.add(stack1);
        stackList.add(stack2);
        stackList.add(stack3);
        stackList.add(stack4);
        stackList.add(stack5);
        stackList.add(stack6);
        stackList.add(stack7);
        stackList.add(stack8);
        stackList.add(stack9);


        // read the input, each line contains Move x amount from stack y to stack z

        while(in.hasNext()) {
            String current = in.nextLine();
            String[] strings = current.split(" ");
            int amount = Integer.parseInt(strings[1]);
            int from = Integer.parseInt(strings[3]);
            int to = Integer.parseInt(strings[5]);
            //move the amount from the from stack to the to stack
            // for (int i = 0; i < amount; i++) {
            //     stackList.get(to-1).push(stackList.get(from-1).pop());
            // }
            //if the amount is more than 1 make sure that the items in the stack get moved in the same order as they were in that stack
                //create a temp stack to hold the items
            Stack<Character> temp = new Stack<Character>();
            //pop the amount of items from the from stack and push them onto the temp stack
            for (int i = 0; i < amount; i++) {
                temp.push(stackList.get(from-1).pop());
            }
            //pop the items from the temp stack and push them onto the to stack
            for (int i = 0; i < amount; i++) {
                stackList.get(to-1).push(temp.pop());
            }

        }
        //print the top of all the stack 
        for (int i = 0; i < stackList.size(); i++) {
            System.out.println(stackList.get(i).peek());
        }
    }
}
