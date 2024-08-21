package birdthorn;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class SaveDataHandler {

    /**
     * It's the file that will be created for the saveData.
     * To change the file's name, change this area of the code: 'new File"[THIS AREA].json")'
     * This file will be created in the project folder.
     */
    public static final File SAVE_DATA_FILE = new File("savedata.json");

    /**
     * This is the json object you use to access any data in the save data.
     */
    public static JsonObject saveDataJson;

    public static void loadSaveData() {
        saveDataJson = new JsonObject();
        try {
            saveDataJson = JsonParser.parseReader(new FileReader(SAVE_DATA_FILE)).getAsJsonObject();
        } catch (FileNotFoundException e) {
            try {
                if (SAVE_DATA_FILE.createNewFile()) {
                    writeTheFile();
                } else {
                    System.out.println("SaveData file unable to be created");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * READY ORRRRRRRRRRRRRRRR
     * Takes the saveDataJson, and puts it into a file.
     */
    public static void writeTheFile() {
        try {
            FileWriter myWriter = new FileWriter(SAVE_DATA_FILE);
            myWriter.write(saveDataJson.toString());
            myWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Gets a value as a specified location.
     * If the value is not there, creates a value (the one listed in parameters) in its place.
     * @param key The path to the value.
     * @param value The value created if the path does not yield a value.
     * @return Returns the value either gotten or created.
     */
    public static JsonObject getJsonObject(String key, JsonObject value) {
        String[] keyParts = key.split("/");
        JsonObject objectParser = getJsonObjectParser(keyParts);

        if (!objectParser.has(keyParts[keyParts.length - 1])) {
            objectParser.add(keyParts[keyParts.length - 1], value);
        }
        writeTheFile();
        return objectParser.get(keyParts[keyParts.length - 1]).getAsJsonObject();
    }
    public static float getJsonObject(String key, float value) {
        String[] keyParts = key.split("/");
        JsonObject objectParser = getJsonObjectParser(keyParts);

        if (!objectParser.has(keyParts[keyParts.length - 1])) {
            objectParser.addProperty(keyParts[keyParts.length - 1], value);
        }
        writeTheFile();
        return objectParser.get(keyParts[keyParts.length - 1]).getAsFloat();
    }
    public static double getJsonObject(String key, double value) {
        String[] keyParts = key.split("/");
        JsonObject objectParser = getJsonObjectParser(keyParts);

        if (!objectParser.has(keyParts[keyParts.length - 1])) {
            objectParser.addProperty(keyParts[keyParts.length - 1], value);
        }
        writeTheFile();
        return objectParser.get(keyParts[keyParts.length - 1]).getAsDouble();
    }
    public static int getJsonObject(String key, int value) {
        String[] keyParts = key.split("/");
        JsonObject objectParser = getJsonObjectParser(keyParts);

        if (!objectParser.has(keyParts[keyParts.length - 1])) {
            objectParser.addProperty(keyParts[keyParts.length - 1], value);
        }
        writeTheFile();
        return objectParser.get(keyParts[keyParts.length - 1]).getAsInt();
    }
    public static boolean getJsonObject(String key, boolean value) {
        String[] keyParts = key.split("/");
        JsonObject objectParser = getJsonObjectParser(keyParts);

        if (!objectParser.has(keyParts[keyParts.length - 1])) {
            objectParser.addProperty(keyParts[keyParts.length - 1], value);
        }
        writeTheFile();
        return objectParser.get(keyParts[keyParts.length - 1]).getAsBoolean();
    }
    public static String getJsonObject(String key, String value) {
        String[] keyParts = key.split("/");
        JsonObject objectParser = getJsonObjectParser(keyParts);

        if (!objectParser.has(keyParts[keyParts.length - 1])) {
            objectParser.addProperty(keyParts[keyParts.length - 1], value);
        }
        writeTheFile();
        return objectParser.get(keyParts[keyParts.length - 1]).getAsString();
    }

    private static JsonObject getJsonObjectParser(String[] keyParts) {
        if (saveDataJson == null) {
            loadSaveData();
        }

        JsonObject objectParser = saveDataJson;

        for (int i = 0; i < keyParts.length - 1; i++) {
            if (!objectParser.has(keyParts[i])) {
                objectParser.add(keyParts[i], new JsonObject());
                StringBuilder newKey = new StringBuilder();
                for (int j = 0; j <= i; j++) {
                    newKey.append("/").append(keyParts[j]);
                }
            }
            objectParser = objectParser.get(keyParts[i]).getAsJsonObject();
        }

        return objectParser;
    }

}
