// Main Parent class to all ciphers
public abstract class Cipher{
  // These methods are what all the classes override or inherit, this is the top parent class
  // providing an idea to the encrypt and decrypt methods 
  public abstract String encrypt(String s);
   public abstract String decrypt(String s);
}