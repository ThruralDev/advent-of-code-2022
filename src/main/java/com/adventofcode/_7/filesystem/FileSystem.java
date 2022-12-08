package com.adventofcode._7.filesystem;

import java.util.HashMap;

public class FileSystem {

    private HashMap<String, Member> fileSizeMap = new HashMap<>();
    private boolean isBusy;

    public FileSystem() {

        isBusy = false;
        fileSizeMap.put("/", new Member(0, Type.DIRECTORY));
    }

    /**
     * When the directory is not present in the filesystem.
     *
     * @param dirPath
     *         is absolute path of directory.
     */
    public void registerDirectoryToFileSystem(String dirPath) {
        if(!dirPath.endsWith("/")) dirPath += "/";

        if (fileSizeMap.get(dirPath) == null) {
            fileSizeMap.put(dirPath, new Member(0, Type.DIRECTORY));
        }
    }

    /**
     * When the file is not present in the filesystem.
     *
     * @param absoluteFilePath
     *         is absolute path of file with ending.
     * @param size
     *         of file in KB.
     */
    public void registerFileToFileSystem(String absoluteFilePath, String size) {

        int fileSize = Integer.parseInt(size);
        if (fileSizeMap.get(absoluteFilePath) == null) {
            fileSizeMap.put(absoluteFilePath, new Member(fileSize, Type.FILE));

            // Append size to the parent directories.
            String parentDirectoryPath = absoluteFilePath
                    .replaceAll("[a-zA-Z.]*$", "");
            while (!parentDirectoryPath.equals("/")) {

                // Feed map until path empty.
                System.out.println("Increasing size of directory " + parentDirectoryPath + " by " + fileSize);
                fileSizeMap.put(parentDirectoryPath,
                        new Member(fileSizeMap.get(parentDirectoryPath).increaseSize(fileSize), Type.DIRECTORY));
                parentDirectoryPath = parentDirectoryPath.replaceAll("\\/[a-z.A-Z]+\\/$", "/");
                System.out.println();
            }
            fileSizeMap.put(parentDirectoryPath,
                    new Member(fileSizeMap.get(parentDirectoryPath).increaseSize(fileSize), Type.DIRECTORY));
            System.out.println();
        }
    }

    public boolean getIsBusy() {

        return isBusy;
    }

    public void setIsBusy(boolean isBusy) {

        this.isBusy = isBusy;
    }

    @Override
    public String toString() {

        return "FileSystem{" +
                "isBusy=" + isBusy +
                '}';
    }

    public Member getFileSizeMember(String key) {

        return fileSizeMap.get(key);
    }
}
