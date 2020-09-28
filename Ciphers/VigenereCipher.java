// The VigenereCipher class uses a given password instead of a shift
// value to replace a given character in a alphabet and uses the "password" String to
// offset its index and replace it with the new index plus the password char index value and uses this to 
// encrpyt text messages. its encrpyt is all about shifting indexs by using the passwords 
// own characters indexs as its index values
public class VigenereCipher extends SymmetricCipher{
  
  // The "password" String is used to encrypt the given message
  protected String password;
  
  // "passwordPos" is used to keep track of the current index of the passwords char so it can be used
  // and reset when it reachs the end length of "password.length"
  protected int passwordPos;
  
  // Public constructor for this class, takes a password String and an alphabet by calling super
  public VigenereCipher(String password,Alphabet alphabet){
    super(alphabet);
    this.password = password;
  }
  
  // Second public constructor for this class, takes a password String and alphabet.DEFAULT by calling super
  public VigenereCipher(String password){
    super(Alphabet.DEFAULT);
    this.password = password;
  }
 
  // Returns the password String of this object
  public String getPassword(){
    return this.password;
  }
  
  // Overrides the parents definition of encrypt1 due to it needing to keep track of the current passwords
  // postion by using the "passwordPos" variable. Instead of using a given shift value it loops through the
  // given password and uses each of the chars indexes to grab a respective char form this classes alphabet
  // at the "password" index
  @Override  protected char encrypt1(char c)throws NotInAlphabetException{
    // Calls alphabet.indexOf(c) to see if a NotInAlphabetException needs to be thrown
    alphabet.indexOf(c); 
    // Special case checker to be able to loop through the given password over and over by setting
    // "passwordPos" to 0 to start from the begining of the index of the gven password String if "passwordPos"
    // == password.length()
    if(passwordPos == password.length()){
      passwordPos = 0;
    }
    int alpha = alphabet.indexOf(c);
    //  char "holder" uses the current "passwordPos" to grab the char in the given alphabet at the same index
    //  as the passwords char is located by then after it gets the index uses the parents rotate method to 
    //  assure it is not out of the alphabets index.  
    char holder = alphabet.get(super.rotate((alphabet.indexOf(password.charAt(passwordPos))+alpha), alphabet.length()));
    passwordPos = passwordPos + 1;
    return holder;
  }
  
  // Overrides the parents definition of decrypt1 due to it needing to keep track of the current passwords
  // postion by using the "passwordPos" variable. Instead of using a given shift value it loops through the
  // given password and uses each of the chars indexes to grab a respective char form this classes alphabet
  // at the "password" index to give back its old char index value
  @Override  protected char decrypt1(char c)throws NotInAlphabetException{
    // Calls alphabet.indexOf(c) to see if a NotInAlphabetException needs to be thrown
    alphabet.indexOf(c); 
    // Special case checker to be able to loop through the given password over and over by setting
    // "passwordPos" to 0 to start from the begining of the index of the gven password String if "passwordPos"
    // == password.length()
    if(passwordPos == password.length()){
      passwordPos = 0;
    }
    int alpha = alphabet.indexOf(c);
    //  char "holder" uses the current "passwordPos" to grab the char in the given alphabet
    //  at the (index-password) char index to revert the encrypted code back to its original alphabet index.
    //  uses the parents rotate method to assure it is not out of the alphabets index.  
    char holder = alphabet.get(super.rotate((-(alphabet.indexOf(password.charAt(passwordPos)))+alpha), alphabet.length()));
    passwordPos = passwordPos + 1;
    return holder;
  }
  
  // Uses a basic override to set "passwordPos" at 0 to start then calls its parent method of encrypt to
  // build the return String
  @Override public String encrypt(String s)throws NotInAlphabetException{
    passwordPos = 0;
    return super.encrypt(s);
  }
    
  // Uses a basic override to set "passwordPos" at 0 to start then calls its parent method of decrypt to
  // build the return String
  @Override  public String decrypt(String s)throws NotInAlphabetException{
    passwordPos = 0;
    return super.decrypt(s);
  }
  
  // Returns a String representation of this object so its readable
  @Override public String toString(){
    String cc = String.format("Vigenere Cipher (password='%s')", this.password);
    return cc;
  }
}
