package cafedoku

object Main {

  def main(args: Array[String]): Unit = {
    if(args.size != 1) {
      println("Wrong number of arguments.")
      println("Usage: ./cafedoku INPUT")
      sys.exit(1)
    }
    val puzzleInput = args(0)

    val puzzle = Parser.parse(new java.io.FileInputStream(puzzleInput))

    println("Input sudoku is:")
    println(Printer(puzzle))

    println("Solving ...")
    Solver.solve(puzzle) match {
      case None =>
        println("No solution !")
      case Some(sol) =>
        println("Solution is:")
        println(Printer(sol))
    }
  }

}
