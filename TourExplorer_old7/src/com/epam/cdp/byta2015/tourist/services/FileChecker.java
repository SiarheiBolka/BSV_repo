package com.epam.cdp.byta2015.tourist.services;

import java.io.File;
import java.io.IOException;

public class FileChecker {

    public static void checkFile(String fileName) {
        try {
            File myDir = new File (".");
            System.out.println(myDir + (myDir.isDirectory() ? " is" : " is not") + " a directory.");
            File txtFile = new File (myDir, fileName);

            if (!txtFile.exists())
                txtFile.createNewFile();
            System.out.println(txtFile + (txtFile.exists() ? " exists" : " doesn't exist"));
        } catch (IOException e1) {
            System.out.println("File error: " + e1);
        }
    }
}
