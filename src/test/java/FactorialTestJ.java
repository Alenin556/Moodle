

import org.testng.Assert;
import org.testng.annotations.Test;



import static org.example.Main.getFactorial;

import static org.testng.Assert.assertEquals;

public class FactorialTestJ {


    @Test
    public void getFactorialTest(){
        Integer[] nums = new Integer[]{1,2,3,4,5,6,7,8,9,10};

        Integer factor = getFactorial(nums);
        Integer result = 3628800;

        Assert.assertEquals(result,factor);
    }

    @Test
    public void getFactorialLengthTest(){
        Integer[] nums = new Integer[]{};

        Integer factor = getFactorial(nums);

        assertEquals(null,factor);
    }
}
