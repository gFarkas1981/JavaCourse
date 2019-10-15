package com.gfarkas;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {

    public Zip() {
    }

    public void zip(String[] files) {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("zipFile.zip");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ZipOutputStream zipOut = new ZipOutputStream(fos);

        for (String srcFile : files) {

            File fileToZip = new File(srcFile);
            FileInputStream fis = null;

            try {
                fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] bytes = new byte[1024];
            int length = 0;

            while (true) {

                try {
                    if (!((length = fis.read(bytes)) >= 0)) break;
                    zipOut.write(bytes, 0, length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            zipOut.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void unZip(String zipFile) {


        File destDir = new File("unZipped");
        byte[] buffer = new byte[1024];
        ZipInputStream zis = null;

        try {
            zis = new ZipInputStream(new FileInputStream(zipFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ZipEntry zipEntry = null;

        try {
            zipEntry = zis.getNextEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (zipEntry != null) {

            File newFile = null;

            try {
                newFile = newFile(destDir, zipEntry);
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(newFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            int len = 0;

            while (true) {
                try {
                    if (!((len = zis.read(buffer)) > 0)) break;
                    fos.write(buffer, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {

                fos.close();
                zipEntry = zis.getNextEntry();
            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        try {
            zis.closeEntry();
            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

}
