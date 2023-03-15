package com.simian.game;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SaveLoad {
    private static String filename = "save";
    private static String settings = "settings";

    public SaveLoad() {

    }

    public static void saveGame() {
        /*************
         * Game Code *
         *************/

        // Create string variables of variables that will be saved

        // Turn strings into a string array to be written
        List<String> rows = Arrays.asList();

        // Code implemented from https://stackabuse.com/reading-and-writing-csvs-in-java/
        try {
            /***************
             * Engine Code *
             ***************/

            String pathString = filename + ".csv";
            FileWriter csvWriter = new FileWriter(pathString);

            /*************
             * Game Code *
             *************/

            for (String data : rows) {
                csvWriter.append(data);
                csvWriter.append(",");
            }

            /***************
             * Engine Code *
             ***************/

            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadGame() throws IOException {
        /***************
         * Engine Code *
         ***************/
        String pathString = filename + ".csv";

        /*************
         * Game Code *
         *************/

        // Create array of string to store variables from save-file
        String[] data = new String[5];

        /***************
         * Engine Code *
         ***************/

        // Code modified and implemented from:
        // https://stackabuse.com/reading-and-writing-csvs-in-java/

        File csvFile = new File(pathString);
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathString));
            String row;

            // Assumes there's only one line to parse
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");

            }

            /*************
             * Game Code *
             *************/

            // Create variables to store data from save-file

            // Update variables
        }
    }

    // Save settings
    public static void saveSettings() {
        /***************
         * Engine Code *
         ***************/
        String pathString = settings + ".csv";

        /*************
         * Game Code *
         *************/

        // Create string for settings that will be saved

        List<String> rows = Arrays.asList();

        // Code implemented from https://stackabuse.com/reading-and-writing-csvs-in-java/
        try {
            FileWriter csvWriter = new FileWriter(pathString);

            // Write the setting

            /***************
             * Engine Code *
             ***************/
            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSettings () throws IOException {
        /***************
         * Engine Code *
         ***************/
        String pathString = settings + ".csv";

        /*************
         * Game Code *
         *************/
        // Create array to store settings
        String[] data;

        /***************
         * Engine Code *
         ***************/

        // Code modified and implemented from:
        // https://stackabuse.com/reading-and-writing-csvs-in-java/

        File csvFile = new File(pathString);
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathString));
            String row;

            // Assumes there's only one word to parse
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");
            }

            /*************
             * Game Code *
             *************/

            // Create variables from parsed data

            // Update variables
            }
        }
}