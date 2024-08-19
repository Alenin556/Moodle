

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

        Assert.assertEquals(factor,result);
    }

    @Test
    public void getFactorialNegativeTest(){
        //TODO 2) Нет обработки отрицательных значений в методе , и  тестирование этой обработки
        Integer[] nums = new Integer[]{-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};

        Integer factor = getFactorial(nums);
        Integer result = null;

        Assert.assertEquals(factor,result);
    }

    @Test
    public void getFactorialResultLengthTest(){
        //TODO 3) нет обработки выхода за пределы диапазона integer
        Integer[] nums = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

        Integer factor = getFactorial(nums);
        Integer result = null;

        Assert.assertEquals(factor,result);
    }
    @Test
    public void getFactorialEmptyLengthTest(){
        Integer[] nums = new Integer[]{};

        Integer factor = getFactorial(nums);

        assertEquals(factor,null);
    }
}
