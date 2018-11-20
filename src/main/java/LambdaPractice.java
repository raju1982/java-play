import java.util.List;
import java.util.ArrayList;

public class LambdaPractice {

    /*
    parameter -> expression body

    Optional type declaration −
    No need to declare the type of a parameter. The compiler can inference the same from the value of the parameter.

    Optional parenthesis around parameter −
    No need to declare a single parameter in parenthesis. For multiple parameters, parentheses are required.

    Optional curly braces − No need to use curly braces in expression body if the body contains a single statement.

    Optional return keyword −
    The compiler automatically returns the value if the body has a single expression to return the value.
    Curly braces are required to indicate that expression returns a value.
     */

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    interface OnClickListener{
        void onClick(int view);
    }

    private void setOnClickListener(OnClickListener clickListner) {
        clickListner.onClick(5);
    }

    public static void main(String[] args){


        LambdaPractice tester = new LambdaPractice();

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        /*
            interface GreetingService {
        void sayMessage(String message);
    }
         */

        //without parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //with parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");

        /*
            interface OnClickListener{
               void onClick(int view);
            }
         */
        //without parenthesis
        OnClickListener listner1 = view -> System.out.println("listner1 " + view);
        //with parenthesis
        OnClickListener listner2 = (view) -> System.out.println("listner2 " + view);


        /*
            private void setOnClickListener(OnClickListener clickListner) {
                clickListner.onClick(5);
            }
         */
        tester.setOnClickListener((view) -> System.out.println("listner3 " + view));

        List<Integer> answer = new ArrayList<Integer>();

        for(int i=9; i<100; i++){
            if(i%3==2 && i%4==3 && i%5==4){
                answer.add(i);
            }
        }

        for (Integer x: answer){
            System.out.println("answer: " + x);
        }



    }
}
