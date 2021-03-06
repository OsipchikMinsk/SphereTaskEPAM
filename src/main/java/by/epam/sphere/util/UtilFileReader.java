package by.epam.sphere.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UtilFileReader implements AutoCloseable {

    static final Logger LOGGER = LogManager.getLogger(UtilFileReader.class);
    private File file;

//    private BufferedReader fileReader;

    public UtilFileReader(File file)  {
            this.file = file;
    }

    public String readFirstLine (){
        String firstLine ="";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            firstLine = fileReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Ошибка при чтении строки");
        }

        return firstLine;
    }


    @Override
    public void close() throws Exception {

    }
}
