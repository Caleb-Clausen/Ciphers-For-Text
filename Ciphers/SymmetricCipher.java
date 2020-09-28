// SymmectricCipher is the parent class to CeaserCipher and VigenereCipher, it supplies 
// All basic methods for encrpyt and decrypt, it also gives them the frame work so they can
// easily rotate or change the index of the given shift values for both chipers
public abstract class SymmetricCipher extends Cipher{
  
  // This is the only class instance variable, it is going to hold the this classes alphabet for
  // easy characters refernces
  protected Alphabet alphabet;
  
  // the class contructor, needs one alphabet to know what characters it can work on
  public SymmetricCipher(Alphabet alphabet){
    this.alphabet = alphabet;
  }
  
  // WrapInt is handed a shift value and it checks to see if its bigger then the current
  // Alphabet's length or smaller such as -10. it uses a while loop to put the int i back into an index that
  // the alphabet can use
  public int wrapInt(int i){
  // Special case checker to see if i is in alphabet's index 
    if (i < alphabet.length() && i >= 0){
      return i;
  // If the first case checker fails then it checks to see if i is greater than Alphabet's length 
  // then runs a while loop wraping it back around to a valid index
    }else if (i >= alphabet.length()){
      while(i >= alphabet.length()){
        i = i - alphabet.length();
      }
      return i;
  // If the second case checker fails then it checks to see if i is less than Alphabet's length 
  // then runs a while loop wraping it back around to a valid index   
    }else if(i < 0){
      while(i < 0){
        i = i + alphabet.length();
      }
      return i;
    }
    return i;
  }
  // Rotate calls wrapInt to acomodate for the index value of "index" + "shift" value's
  // it then returns a correctly shifted index value that if need be was rotated around the alphabets length
  public int rotate(int index, int shift){  
    int a = wrapInt(index+shift);
    return a;
  }
  // Simple retrun method that returns this Ciphers alphabet
  public Alphabet getAlphabet(){
    return alphabet;
  }
  
  // the encrpyt method builds an encrypted string by repeatedly calling encrypt1
  // it is pormised that the method encrypt1 will be built in a child class
  @Override public String encrypt(String s)throws NotInAlphabetException{
    String rtrnVal = "";
  // Loop to continuously call encrypt1 method to build a String of the encrypted text
    for(int i = 0; i < s.length(); i++){
      rtrnVal = rtrnVal + encrypt1(s.charAt(i));
      
    }
    return rtrnVal;
  }
  
  // the decrpyt method builds the original Message string by repeatedly calling decrypt1
  // it is pormised that the method decrypt1 will be built in a child class
  @Override public String decrypt(String s)throws NotInAlphabetException{  
    String rtrnVal = "";
  // Loop to continuously call decrypt1 method to build a String of the decrypted text
    for(int i = 0; i < s.length(); i++){
      rtrnVal = rtrnVal + decrypt1(s.charAt(i));
      
    }
    return rtrnVal;
  }
  // Abstract methods from the Cipher parent class, these will be defined in the child classses of this class
  protected abstract char encrypt1(char c);
  protected abstract char decrypt1(char c);
}