package Lesson6;

import com.opencsv.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandlerClass {

    private static String filePath = "src/main/java/Lesson6/writer.csv";

    public static String getFilePath() {
        return filePath;
    }

    private static char seporator = ';';

    public static void writeDataLineByLine(String[] header,String[] data1,String[] data2,String[] data3)
    {
        File file = new File(filePath) ;
        try {
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile, seporator,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            String[] headers = header;
            writer.writeNext(header);

            // добавляем записи в файл
            String[] datas1 = data1;
            writer.writeNext(datas1);
            String[] datas2 = data2;
            writer.writeNext(datas2);
            String[] datas3 = data3;
            writer.writeNext(datas3);

            // закрываем соединение
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData(String filePath)
    {
        try {
            FileReader filereader = new FileReader(filePath);

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withCSVParser(parser)
                    .build();

            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
