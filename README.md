Cafedoku
========

Cafedoku is a [sudoku](http://en.wikipedia.org/wiki/Sudoku) solver written in
Scala and based on the [CafeSat](https://github.com/regb/scabolic) SAT solver.

CafeDoku is a very simple project, with limited ambitions, mostly to experiment
with CafeSat as a Scala library.

The core solving part is in [`Solver`](/src/main/scala/cafedoku/Solver.scala) and
consists of about 10 lines of code. It illustrates how to elegantly solve sudoku
problems by encoding to SAT and how to use CafeSat to solve the SAT instance.

Usage
-----

You can build Cafedoku using `sbt`:

    sbt cafedoku

sbt will then generate a `target/cafedoku` script that you can use to run Cafedoku in
command line mode:

    ./target/cafedoku INPUT

`INPUT` is a data file representing a sudoku problem. You can find examples
in the `examples/` directory. Try:

    ./target/cafedoku examples/sudoku1.dat
