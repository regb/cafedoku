package cafedoku

import org.scalatest.FunSuite

class SolverSuite extends FunSuite {

  val solvedPuzzle = Array(
    Array(6, 7, 9, 2, 8, 5, 3, 1, 4),
    Array(1, 4, 8, 9, 6, 3, 5, 2, 7),
    Array(2, 3, 5, 1, 7, 4, 8, 6, 9),
    Array(5, 6, 4, 3, 1, 9, 2, 7, 8),
    Array(8, 1, 3, 5, 2, 7, 4, 9, 6),
    Array(9, 2, 7, 8, 4, 6, 1, 5, 3),
    Array(3, 8, 6, 7, 5, 1, 9, 4, 2),
    Array(7, 5, 2, 4, 9, 8, 6, 3, 1),
    Array(4, 9, 1, 6, 3, 2, 7, 8, 5)
  )

  test("solve basic") {
    val puzzle1: Array[Array[Option[Int]]] = 
      solvedPuzzle.map(row => row.map(i => (Some(i): Option[Int])))
    val correct1 = puzzle1(0)(0).get
    val correct2 = puzzle1(4)(8).get
    val correct3 = puzzle1(7)(7).get
    puzzle1(0)(0) = None
    puzzle1(4)(8) = None
    puzzle1(7)(7) = None

    val res1 = Solver.solve(puzzle1)
    assert(res1 !== None)
    assert(res1.get(0)(0) === correct1)
    assert(res1.get(4)(8) === correct2)
    assert(res1.get(7)(7) === correct3)
  }

}
