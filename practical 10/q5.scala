object countLetters{
    def countLetters(wordList:List[String]):Int={
        wordList.map(_.length).reduce(_+_);
    }
    def main(args:Array[String]):Unit ={
        val wordList = List("apple", "banana", "cherry", "date");
        val numLettersInList = countLetters(wordList);

        println("Output: " + numLettersInList);
    }
}