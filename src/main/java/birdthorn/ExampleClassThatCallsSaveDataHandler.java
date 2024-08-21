package birdthorn;

public class ExampleClassThatCallsSaveDataHandler {
    public static void main(String[] args) {
        //This should be called before doing anything with save data
        SaveDataHandler.loadSaveData();

        //Examples of how to add data

        /* If there is an integer at {"settings":{"keybinds":{"up:INTEGER_LOCATION"}}} returns that integer
            Otherwise, places 51 in the INTEGER_LOCATION
         */
        System.out.println(SaveDataHandler.getJsonObject("settings/keybinds/up", 51));
        System.out.println(SaveDataHandler.getJsonObject("settings/keybinds/up", 32));

        System.out.println(SaveDataHandler.getJsonObject("food/fruits", "Apple"));
        System.out.println(SaveDataHandler.getJsonObject("food/fruits", "Orange"));
    }
}