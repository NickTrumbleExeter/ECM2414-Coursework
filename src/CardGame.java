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
    }

    private Path requestPackPath(int playerCount){
        System.out.println("Enter the location of the input pack:");
        Path packPath = Path.of(scanner.nextLine());

        if (packPath.getFileName().toString().endsWith(".txt")){

            //count lines as well
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


        System.out.println("Invalid file submitted.");
        packPath = requestPackPath();
        return packPath;    
    }
}