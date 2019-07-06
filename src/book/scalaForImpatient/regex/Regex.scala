package book.scalaForImpatient.regex

object Regex {
  
    def main(args: Array[String]): Unit = {
      
        val numPattern = "[0-9]+".r
        
        for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles")) {
            println(matchString)
        }
        
        
        /*
         * replace
         */
        println(numPattern.replaceAllIn("99 bottles, 98 bottles", "xx"))  // print "xx bottles, xx bottles"
        
        val replaceSome = numPattern.replaceSomeIn("99 bottles, 98 bottles", m => if (m.matched.toInt % 2 == 0) Some("xx") else None)
        println(replaceSome)  // print "99 bottles, xx bottles"
        
        
        val varPattern = """\$[0-9]+""".r
        def format(message: String, vars: String*) = 
            varPattern.replaceSomeIn(message, m => vars.lift(m.matched.tail.toInt))
    
        println(format("At $1, there was $2 on $0.", "plant 7", "12:30pm", "a disturbance of the force"))
    
        
        
        /*
         * regex groups
         */
        val numItemPattern = "([0-9]+) ([a-z]+)".r  // NOTE: there is a space between two groups
        for (m <- numItemPattern.findAllMatchIn("99 bottles, 98 bottles")) {
            println(m.group(1))  // print 99 and 98
        }
        
        // or use group names
        val numItemPatternWithGroupName = "([0-9]+) ([a-z]+)".r("num", "item")
         for (m <- numItemPatternWithGroupName.findAllMatchIn("99 bottles, 98 bottles")) {
            println(m.group("num"))  // print 99 and 98
        }
    }
}