package com.weetechsolution.studentcrud.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    public static void fileupload(byte[] data,String filePath,String fileName) throws IOException {
        // Target directory
        File targetfile = new File(filePath);
        if(targetfile.exists()) {
            targetfile.mkdirs();
        }

        // Binary stream write
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(data);
        out.flush();
        out.close();
    }
}
