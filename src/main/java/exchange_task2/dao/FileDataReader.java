package exchange_task2.dao;

import exchange_task2.exeption.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileDataReader {
    private final static Logger LOGGER = LogManager.getLogger(FileDataReader.class);
    private static Lock lock = new ReentrantLock();
    private static FileDataReader fileDataReader;

    public FileDataReader() {
    }

    public static FileDataReader getFileDataReader() {
        if (fileDataReader == null){
            lock.lock();
            fileDataReader = new FileDataReader();
            lock.unlock();
        }
        return fileDataReader;
    }
    public String getLineFromFileByNumber (File file, int numberOfLine) throws DaoException {
        String lineResult = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file ))) {
           while (numberOfLine-->0) {
               lineResult = bufferedReader.readLine();
           }
        }catch (IOException e){
            LOGGER.error(e.getMessage(), e);
            throw new DaoException(e);
        }
        return lineResult;
    }

    public String getFirstLineFromFile(File file) throws DaoException {
        String firstLineFromFile = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            firstLineFromFile = bufferedReader.readLine();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DaoException(e);
        }
        return firstLineFromFile;
    }

    public List<String> getAllFile(File file) throws DaoException {
        List<String> resultDataFromFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                resultDataFromFile.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DaoException(e);
        }
        return resultDataFromFile;
    }

}
