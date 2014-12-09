package cafedoku

import scala.io.Source
import java.io.InputStream

object Parser {

  def parse(input: InputStream): Array[Array[Option[Int]]] = {

    val puzzle: Array[Array[Option[Int]]] = Array.fill(9,9)(None)
    var i = 0
    var j = 0
    var expectComma = false
    for(line <- Source.fromInputStream(input).getLines()) {
      for(c <- line) {
        if(c != ' ') {
          if(expectComma && c != ',') {
            println("Parse error")
            sys.exit(-1)
          } else if(!expectComma) {
            val entry = c.toString.toInt
            if(entry == 0)
              puzzle(i)(j) = None
            else
              puzzle(i)(j) = Some(entry)
            j = (j + 1) % 9
            if(j == 0)
              i = i + 1
          }
          expectComma = !expectComma
        }
      }
    }
    puzzle
  }

}
