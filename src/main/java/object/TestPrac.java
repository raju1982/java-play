package object;

import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class TestPrac {

    public static int getChangeInNumberOfPiesToBake(int leftover) {
        if(leftover<0){
            throw new IllegalArgumentException("invalid input");
        }

        if (leftover==0){
            return 40;
        }
        else if (leftover<21){
            return 0;
        }
        else {
            return (leftover - 20) * -1;
        }
    }

    @Test(expectedExceptions=IllegalArgumentException.class, expectedExceptionsMessageRegExp = "invalid input")
    public void invalidInputTest(){
        getChangeInNumberOfPiesToBake(-1);
    }

    @Test
    public void inputTest4(){
        assertEquals(40,getChangeInNumberOfPiesToBake(0));
    }

    @Test
    public void inputTest1(){
        assertEquals(0,getChangeInNumberOfPiesToBake(1));
    }

    @Test
    public void inputTest2(){
        assertEquals(0,getChangeInNumberOfPiesToBake(20));
    }

    @Test
    public void inputTest3(){
        assertEquals(-1,getChangeInNumberOfPiesToBake(21));
    }
}
