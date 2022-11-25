package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
    /*    String versionString = readStreamOfLinesUsingFiles();
        System.out.println(versionString);

        //List all files and sub-directories using Files.list()
        Files.list(Paths.get("C:/vogella_tests")).forEach(System.out::println);

        //How to identify the current directory
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir); */

        String input = FileUtil.readTextFile("C:/vogella_tests/file.txt");
        System.out.println(input);
        System.out.println("-----------------------------------------------------");

        FileUtil.writeToTextFile("copy.txt", input);
        System.out.println(FileUtil.readTextFile("copy.txt"));

        FileUtil.readTextFileByLines("copy.txt");
        System.out.println("//////////////////////");
        Path path = Paths.get("copy.txt");
        System.out.println(path);

    }

    private static String readStreamOfLinesUsingFiles() throws IOException {

        Stream<String> lines = Files.lines(Paths.get("C:/vogella_tests", "MANIFEST.MF"));
        Optional<String> versionString = lines.filter(s -> s.contains("Bundle-Version:")).
                                            map(e -> e.substring(15).trim()).findFirst();
        lines.close();
        if(versionString.isPresent()) {
            return versionString.get();
        }
        return "";
    }


}