package Lesson6;

import static Lesson6.FileHandlerClass.*;

public class Runner {

    public static void main(String[] args) {

        String[] header = { "Урок", "6","Cтроки",};
        String[] data1 = { "Набор строк с целочисленными значениями:" };
        String[] data2 = { "13", "10", "620" };
        String[] data3 = { "145", "10", "630" };

        writeDataLineByLine(header,data1,data2,data3);
        readData(getFilePath());
    }
}
