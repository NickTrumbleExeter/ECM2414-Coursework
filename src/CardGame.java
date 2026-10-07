//Executable class
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class CardGame{

    public static void main(String[] args){
        //requests number of players and pack location
        Scanner scanner = new Scanner(System.in);

        //check player count is valid?
        System.out.println("Enter the number of players");
        int playerCount = Integer.parseInt(scanner.nextLine());

        //check path is valid?
        Path packPath = requestPackPath(playerCount, scanner);

        //deal cards into decks from input packs

        //deal cards into hands from decks

        //create output files

        //loop through turns and writing to output files

        
    }

    private static Path requestPackPath(int playerCount, Scanner scanner){
        while (true) {
            //request location of the pack
            System.out.println("Enter the location of the input pack:");
            Path packPath = Path.of(scanner.nextLine());

            //checks is file .txt file
            if (!packPath.getFileName().toString().endsWith(".txt")){
                System.out.println("Invalid file submitted.");
                continue;
            }

            //test for line count = 8n
            int count = 0;
            try{
                Scanner fileReader = new Scanner(packPath);
                while (fileReader.hasNextLine()){
                    fileReader.nextLine();
                    count++;
                }

                fileReader.close();
                if (count == 8 * playerCount){
                    return packPath;
                }
            } catch (IOException e){
                System.out.println("Invalid file, IOException: " + e);
            }  
            System.out.println("Invalid file submitted.");
        } 
    }
}