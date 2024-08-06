package Lesson7;


import static Lesson7.ArraysHandler.getSumFromCells;
import static Lesson7.ArraysHandler.logger;


public class Runner {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {


        //В методе main() вызвать полученный метод, обработать возможные исключения MyArrayDataException и MyArrayDataException и вывести результат расчета.


        String[][] twoDimArray = new String[][]{{"1", "1", "0", "3"}, {"2", "1", "1", "1"}, {"1", "2", "1", "1"}, {"0", "3", "1", "1"}};
        String[][] twoDimArrayLengthException = new String[][]{{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] twoDimArrayTypeException = new String[][]{{"1", "1", "a", "1"}, {"1", "м", "1", "о"}, {"1", "п", "1", "1"},{"a", "f", "1", "1"}};


        getSumFromCells(twoDimArray);
        System.out.println("\n");

        try {
            getSumFromCells(twoDimArrayLengthException);
        } catch (MyArrayDataException exception){
            logger.error("При обработке возникла ошибка.");
        }
        System.out.println("\n");

        try {
            getSumFromCells(twoDimArrayTypeException);
        } catch (MyArrayDataException exception){
            logger.error("При обработке возникла ошибка.");
        }


    }
}
