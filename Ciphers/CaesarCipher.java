// The CeaserCipher class uses a given shift value to replace a given character in a alphabet to
// offset  its index and replace it with the new index plus the shift value and uses this to 
// encrpyt text messages. its encrpyt is all about shifting indexes only
public class CaesarCipher extends SymmetricCipher{
  // This class has one of its own instance variables to hold the value it needs to shift to encrpyt called
  // "shift"
  protected int shift;
  
  // Public constructor for this class, takes a shift value and aphabet to use as its coding index
  public CaesarCipher(int shift, Alphabet alphabet){
    super(alphabet);
    this.shift = shift;
  }
  
  // Second public constructor that uses the Alphabet.DEFAULT as its base and accepts a shift value
  public CaesarCipher(int shift){
    super(Alphabet.DEFAULT);
    this.shift = shift;
  }
  
  // The encrypt method for this class relies solely upon its parent SymmetricCipher for building the 
  // encrypted string
  public String encrypt(String s){
    return super.encrypt(s);
  }
  
  // The decrypt method for this class relies solely upon its parent SymmetricCipher for building the 
  // decrypted string
  public String decrypt(String s){
    return super.decrypt(s);
  }
  
  // encrypt1 is overridden from its parent class and calls the parent's rotate method to shift the single
  // char its given to the correct index to make it an encrypted character. then returns the char
  @Override  protected char encrypt1(char c){
    int warp = super.rotate(alphabet.indexOf(c), this.shift);
    return alphabet.get(warp);
  }
  
  // decrypt1 is overridden from its parent class and calls the parent's rotate method to shift the single
  // char its given to the correct index to make it the origanl character. then returns the char
  @Override protected char decrypt1(char c){
    int warp = super.rotate(alphabet.indexOf(c), (-this.shift));
    return alphabet.get(warp);
  }
  
  // redefines the toString method for this class to return a readable String
  @Override public String toString(){
    String cc = String.format("Caesar Cipher (shift=%d)", this.shift);
    return cc;
  }
}