object CaesarCipher{
  def encrypting(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter){
        val base = if (char.isUpper) 'A' else 'a'
        val newChar = ((char - base + shift) % 26 + 26) % 26 + base
        newChar.toChar
      }else{
        char
      }
    }.mkString
  }

  def decrypting(text: String, shift: Int): String = {
    text.map{ char =>
      if (char.isLetter){
        val base = if (char.isUpper) 'A' else 'a'
        val newChar = ((char - base - shift) % 26 + 26) % 26 + base
        newChar.toChar
      }else {
        char
      }
    }.mkString
  }

  def cipher(text: String, shift: Int, operation: (String, Int) => String): String = {
    operation(text, shift)
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hello, World!"
    val shift = 3

    val encryptedText = cipher(plaintext, shift, encrypting)
    println("Encrypted Text: " + encryptedText)

    val decryptedText = cipher(encryptedText, shift, decrypting)
    println("Decrypted Text: "+ decryptedText)
  }
}
