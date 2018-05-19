object input_output {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(327); 
  def main(args: Array[String]) {
	  var numberGuess = 0	\
	  do {
	    print("Guess a number : ")
	
	    // You can also use readInt, readDouble, readByte, readShort, readLong
	    numberGuess = readLine.toInt
	
	  } while (numberGuess != 15)
	
	  printf("You guessed the secret number %d\n", 15)
  };System.out.println("""main: (args: Array[String])Unit""")}
}
