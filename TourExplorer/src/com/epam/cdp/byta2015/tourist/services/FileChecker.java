package com.epam.cdp.byta2015.tourist.services;

import java.io.File;
import java.io.IOException;

public class FileChecker {

    public static void checkFile(String fileName) {
        try {
            File myDir = new File (".");
            File txtFile = new File (myDir, fileName);

            if (!txtFile.exists()){
                txtFile.createNewFile();
            }
        } catch (IOException e1) {
            System.out.println("File error: " + e1);
        }
    }
}
