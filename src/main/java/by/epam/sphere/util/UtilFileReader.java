package by.epam.sphere.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UtilFileReader implements AutoCloseable {

    static final Logger LOGGER = LogManager.getLogger(UtilFileReader.class);

    private BufferedReader fileReader;

    public UtilFileReader(File file)  {
        try {
            fileReader=new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("Файл не найден");
        }
    }

    public String readFirstLine (){
        String firstLine ="";
        try {
            firstLine= fileReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Ошибка при чтении строки");
        }
        return firstLine;
    }


    public List<String> readAllFile()  {
        List<String> list = new ArrayList<>();
        try {
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e);
        }
        return list;
    }

    @Override
    public void close() throws Exception {

    }
}
