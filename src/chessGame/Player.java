package chessGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import log_in.Choose;

public class Player {
	
	protected static List<String> data = new ArrayList<>();
	protected static String[][] gameData;
	
	public static void WriteToFile(String data){
        try {
            String name = LoginPage.getName();
            // taking the username
            String path = "src/files/";
            FileWriter writer = new FileWriter(path+name, true);
            writer.write(data+"\n"); //writing the data in the file
            writer.close();
        } catch (IOException evt) {
            throw new RuntimeException(evt);
        }
    }

    public static void ReadDataFromFile(){

		try {
            String path="src/files/";
            String name = LoginPage.getName();
            File obj = new File(path+name);//reading the data from the needed file
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String gameDataLine = reader.nextLine();
                String[] gameDataLineSplit = gameDataLine.split(",");// save the data of each line in string
                for (int i=0; i< gameDataLineSplit.length; i++) {
                    data.add(gameDataLineSplit[i]); //splitting each string in a raw and storing it in a list
                }

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int games=0;
        int listSize= data.size();
        while(listSize%4==0 && listSize!=0){// getting n. of games by dividing elements of list by 4 as table has 4 columns
            games++;
            listSize-=4;
        }
        gameData= new String[games][4];// store elements of list in 2D array to be read in the table
        int k=0;
        for (int i = 0; i < games; i++) {
            for (int j = 0; j < 4; j++) {
                gameData[i][j] = data.get(k);
                k++;
            }
        }
    }
}
