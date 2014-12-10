package cafedoku

import scala.io.Source
import java.io.InputStream

object Parser {

  /*
   * A sudoku solver is represented in text format,
   * with 9 lines of 9 characters, each character [1-9.]
   * with '.' representing unknown number
   */
  def parse(input: InputStream): Array[Array[Option[Int]]] = {

    try {
      val lines = for(line <- Source.fromInputStream(input).getLines()) yield {
        val row = line.map(c => if(c == '.') None else Some(c.asDigit))
        row.toArray
      }
      lines.toArray
    } catch {
      case e: Exception =>
        println("Parse error")
        sys.exit(-1)
    }
  }

}
