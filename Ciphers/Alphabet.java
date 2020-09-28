// Alphabet class is used to give all ciphers a quick access to a String of characters 
// that it uses to encrypt or decrypt. it supplies it own methods to get characters from it's 
// given String of characters and makes use of the NotInAlphabetException to check a characters
// exsistance in itself.
public class Alphabet {
  // Symbols is the Alphabets String input for any alphabet that is not Alphabet.DEFAULT 
  private String symbols;
  
  // All Alphabets have a staic DEFAULT alphabet that has all key board characters 
  public static final Alphabet DEFAULT = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz 1234567890!@#$%^&*()_+-=[]{}\\|;:'\",./?<>");
  
  // Alphabet Constructor taking a user input of a String of Characters
  public Alphabet(String symbols){
    this.symbols = symbols;
  }
  // indexOf is an upgraded version of String.indexOf() that throws a NotInAlphabetException
  // if the Character char c is not found in this alphabet 
  public int indexOf(char c)throws NotInAlphabetException{
  // Checks to see if c is in symbols, returns -1 if it is not and the throws NotInAlphabetException
    int index = symbols.indexOf(c);
    if(index == -1){
      throw new  NotInAlphabetException(c, this);
    }
    return index;
  }
  
  // get() Grabs the character at alphabet's index of i and retunrs it, if index of i is out
  // of the range of the String's index throws an NotInAlphabetException
  public char get(int i) throws NotInAlphabetException{
  // Creates a correct message to throw if i is greater then this alphabets length
    String correctmsg = String.format("Asked to get symbol @%d, but length of Alphabet is %d.",i, this.length());
    if(i > symbols.length()){
      throw new NotInAlphabetException(correctmsg,(char)i, this);
    }
    char character = symbols.charAt(i);
    return character;
  }
  
  // Returns the alphabet's length
  public int length(){
    return this.symbols.length();
  }
  
   // Returns the alphabet's String of characters
  public String getSymbols(){
    return this.symbols;
  }
  
  // Returns a readable String representation of this alphabet
  @Override public String toString(){
    String rep = String.format("Alphabet(%s)",this.symbols);
    return rep;
  }
  
  // Checks to see if this alphabet is equal to another alphabet's String of characters
  @Override public boolean equals(Object other){
    Alphabet a = ((Alphabet)other);
    if( this.symbols.equals(a.symbols) == true ){
      return true;
    }
    return false;
  }
}