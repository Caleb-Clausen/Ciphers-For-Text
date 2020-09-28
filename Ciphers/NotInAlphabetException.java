// NotInAlphabetException class was created to throw exceptions in the Alphabet Class if
// any of the characters where not found in Alphabets String of characters it Extends.
// RuntimeException to ease its ability to be thrown
public class NotInAlphabetException extends RuntimeException{
  // String msg is used to hold the message that will be used to tell the user what char is not found
  public final String msg;
  
  // offender is used to hold the char that is not found 
  public final char offender;
  
  // Alphabet is used to hold the current alphabet so it can access its symbols for the offending char
  public final Alphabet a;
  
  // One of the constructors for this class, assigns all varibles using its own class insatnce varibles
  public NotInAlphabetException(String msg, char offender, Alphabet a){
    this.msg = msg;
    this.offender = offender;
    this.a = a;
  }
  
  // One of the constructors for this class, assigns all varibles using its own class insatnce varibles
  // the ones difference is the msg, it handles special cases
  public NotInAlphabetException(char offender, Alphabet a){
    this.offender = offender;
    this.a = a;
    this.msg = String.format("Not in alphabet: '%c' not found in %s.", this.offender, this.a.toString());
  }
  // To string representation of this class
  public String toString(){
    return this.msg;
  }
}