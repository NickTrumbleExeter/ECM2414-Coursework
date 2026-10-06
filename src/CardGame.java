//Executable class
import java.nio.file.Path;
import java.util.Scanner;

public class CardDeck{

    public static void main(String[] args){
        //requests number of players and pack location
        Scanner scanner = new Scanner(System.in);

        //check player count is valid?
        System.out.println("Enter the number of players");
        int playerCount = scanner.nextLine();

        //check path is valid?
        Path packPath = requestPackPath(playerCount);

        //deal cards into decks from input packs

        //deal cards into hands from decks

        //create output files

        //loop through turns and writing to output files

        
    }

    private static Path requestPackPath(int playerCount){
        //request location of the pack
        System.out.println("Enter the location of the input pack:");
        Path packPath = Path.of(scanner.nextLine());

        //checks is file .txt file
        if (packPath.getFileName().toString().endsWith(".txt")){

            //test for line count = 8n
            int count = 0;
            Scanner fileReader = new Scanner(packPath);
            do{
                fileReader.nextLine();
                count++;
            }while (fileReader.hasNext());

            if (count == 8 * playerCount){
                return packPath;
            }
        }

        //if conditions not met, call function again
        System.out.println("Invalid file submitted.");
        packPath = requestPackPath();
        return packPath;    
    }
}