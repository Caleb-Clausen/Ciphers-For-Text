// The MorseCipher is fundamentally different then both the Caeser and Vigenere Cipher. Instead of using
// shift values it directly translates chars into a morse code representation using a given array to loop
// through. It uses only capital letters in its alphabet and only extends the "Cipher" class
// its not so much as a encrypting class as a direct substitution method
class MorseCipher extends Cipher {
  
  // String letters is used as the only alphabet for this class.
  public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
  
  // "codes" is a String array that holds all the morse code chars to represent morse code
  public static final String[] codes = {
    ".-",    /* A */
    "-...",  /* B */    
    "-.-.",  /* C */    
    "-..",   /* D */
    ".",     /* E */    
    "..-.",  /* F */    
    "--.",   /* G */    
    "....",  /* H */
    "..",    /* I */    
    ".---",  /* J */    
    "-.-",   /* K */    
    ".-..",  /* L */
    "--",    /* M */    
    "-.",    /* N */    
    "---",   /* O */    
    ".--.",  /* P */
    "--.-",  /* Q */    
    ".-.",   /* R */    
    "...",   /* S */    
    "-",     /* T */
    "..-",   /* U */    
    "...-",  /* V */    
    ".--",   /* W */    
    "-..-",  /* X */
    "-.--",  /* Y */    
    "--..",  /* Z */    
    ".----", /* 1 */    
    "..---", /* 2 */
    "...--", /* 3 */    
    "....-", /* 4 */    
    ".....", /* 5 */    
    "-....", /* 6 */
    "--...", /* 7 */    
    "---..", /* 8 */    
    "----.", /* 9 */    
    "-----", /* 0 */
  };
  // Basic contructor for MorseCipher, takes no arguments
  public MorseCipher(){
  }
  
  // The encrypt method for morse code takes a String and for every char in the String, it replaces it
  // with the corrosponding morse code String, not char. such as char  "A" in "plainText
  // == ".-" in morse code taken from the "codes []". 
  @Override public String encrypt(String plainText){
   // String "holder" is used to start the string that will be returned upon successful encryption 
    String holder = "";
   // This takes the String "plainText" and makes it all upper case, this is needed to use the "letters"
   // String correctly
    plainText = plainText.toUpperCase();
   // Make a new alphabet out of this classes instance String "letters" to better handle the chars
     Alphabet a = new  Alphabet (letters);
   // For loop for building the String "holder", checking all indexs for chars in plainText and grabbing the 
   // the same indexs for the code[i] to replace them with the morse code String that represent their chars.
    for(int i = 0; i < plainText.length(); i ++){
   // In the for loop this if statement checks to see if there is a space in the plain text
   // and handdles it as a special case by adding seven spaces to the holder String 
      if((plainText.charAt(i)+"").equals(" ") == true ){
        holder = holder + "       ";
        continue;
      }
    // Grabs the next letter in "plaintext index and addes its morse code represenetive plus three spaces to
    // the "holder" String
      holder = holder+ (codes[a.indexOf(plainText.charAt(i))]+ "   ");
    }
    // Needed to replace the ten spaces with the correct amount of seven then trim holder before returning it
    holder = holder.replace("          ", "       ");
    return holder.trim();
  }
  
  // The decrypt method for morse code takes a String and for every char in the String, it replaces it
  // with the corrosponding correct char in the "letters" String. Such as String ".-" in "cryptText"
  // == "A" in the "letters" String. 
  @Override public String decrypt(String cryptText){
    // Make a new alphabet out of this classes instance String "letters" to better handle the chars
    Alphabet a = new  Alphabet (letters);
    // String "decRight" is used to start the string that will be returned upon successful decryption 
    String decRight = "";
    // Declare another method varible to get rid off all the extra spaces in "cryptText" and make them 
    // eqaul to one instead, I do this so I can use a split method to put all the elememts into an array
    String uncrypt = cryptText.replaceAll("   "," ");
    // Get rid of the seven spaces and make them equal to two
    uncrypt = uncrypt.replaceAll("    ","  ");
    // Declare a new array and assign it the array got from calling uncrypt.split(" ") 
    String [] holder = uncrypt.split(" ");
    // This is a double for loop, the the outer for loop goes through holder array and the next for loop checks
    // to see if any of the Strings in the holder [i] equal a String in the codes[ii], if this checks out as
    // true, grab the correct char at ii count index and add it onto the decRight String
    for(int i = 0; i < holder.length; i ++){
      for(int ii = 0; ii < codes.length; ii ++){
        if(codes[ii].equals(holder[i]) == true){
          decRight = decRight + a.get(ii);
          break;
        }
     // Adds a space if no chars in codes == holders
        if(ii+1 == codes.length){
          decRight = decRight + " ";
          break;
        }
      }
      
    }
    //Replaces all double spaces by a normal space between words
    return (decRight = decRight.replaceAll("  ", " "));
  }
}