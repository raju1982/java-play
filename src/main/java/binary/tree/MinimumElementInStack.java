package binary.tree;
import java.util.Stack;

public class MinimumElementInStack {

    //Implementation 1
    private Stack<Integer> repo = new Stack<Integer>();
    private Stack<Integer> minElementRepo = new Stack<Integer>();

    public void push(int number){
        repo.add(number);
        if(!minElementRepo.isEmpty()){
            int top = minElementRepo.peek();
            if(number < top) {
                minElementRepo.push(number);
            }
            else{
                minElementRepo.push(top);
            }
        }
        else{
            minElementRepo.add(number);
        }
    }

    public Integer min(){
        return minElementRepo.pop();
    }


    //Implementation 2
    private StackImplementation<Integer> repo1 = new StackImplementation<Integer>();
    private StackImplementation<Integer> minElementRepo1 = new StackImplementation<Integer>();

    public void push1(int number) throws StackImplementation.StackUnderflowException,StackImplementation.StackOverflowException{
        repo1.push(number);
        if(!minElementRepo1.isEmpty()){
            int top = minElementRepo1.peek();
            if(number < top) {
                minElementRepo1.push(number);
            }
            else{
                minElementRepo1.push(top);
            }
        }
        else{
            minElementRepo1.push(number);
        }
    }

    public Integer min1(){
        return minElementRepo.pop();
    }

    public static void main(String[] args) throws StackImplementation.StackOverflowException, StackImplementation.StackUnderflowException{
        MinimumElementInStack test = new MinimumElementInStack();
        test.push(10);
        test.push(15);
        test.push(5);
        test.push(-1);
        test.push(3);
        test.push(13);

        System.out.println(test.min());

        test.push1(10);
        test.push1(15);
        test.push1(5);
        test.push1(-1);
        test.push1(3);
        test.push1(13);

        System.out.println(test.min1());
    }
}
