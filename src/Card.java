//Mandatory thread-safe class

//toString method to print card value 
//holds one face value 

public class Card{
    //final to make it thread safe so onec created it cannot be changed
    final int value;

    //reject negative numbers??
    public Card(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return Integer.toString(this.value);
    }
}