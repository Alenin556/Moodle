import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Main.getFactorial;
import static org.example.Main.successNotification;

public class FactorialTestJ {


    @Test
    public void getFactorialTest(){
        Integer[] nums = new Integer[]{1,2,3,4,5,6,7,8,9,10};

        Integer factor = getFactorial(nums);

        Assertions.assertEquals(3628800,factor);
    }

    @Test
    public void getFactorialTypeTest(){
        Integer[] nums = new Integer[]{};

        Integer factor = getFactorial(nums);

        Assertions.assertEquals(null,factor);
    }
}
