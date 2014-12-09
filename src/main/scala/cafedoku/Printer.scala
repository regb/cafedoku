package cafedoku

object Printer {

  def apply(sudoku: Array[Array[Option[Int]]]) =
    sudoku.map(row => row.map(opt => opt.getOrElse(" ")).mkString(" ")).mkString("\n")

  def apply(sudoku: Array[Array[Int]]) =
    sudoku.map(row => row.mkString(" ")).mkString("\n")

}
