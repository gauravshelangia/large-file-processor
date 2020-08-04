package com.postman;

import com.postman.file.processor.CSVFileProcessor;
import com.postman.file.processor.FileProcessor;

import java.sql.SQLException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println("Large File Processor com.postman.file.processor.App Started");

        System.out.println("Start at = " + new Date());
        long currentMills = System.currentTimeMillis();

        String fileToSave = "conf/products.csv";
        FileProcessor fileProcessor = new CSVFileProcessor();
        fileProcessor.saveFileToDB(fileToSave);

        System.out.println(System.currentTimeMillis() - currentMills + "ms spent");
    }
}
