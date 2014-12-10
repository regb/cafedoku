CAFEDOKU
========

CafeDoku is a [sudoku](http://en.wikipedia.org/wiki/Sudoku) solver written in
Scala and based on the [CafeSat](https://github.com/regb/scabolic) SAT solver.

CafeDoku is a very simple project, with limited ambitions, mostly to experiment
with CafeSat as a Scala library.

Usage
-----

You can build CafeDoku using sbt:

    sbt cafedoku

sbt will then generate a `target/cafedoku` script that you can use to run CafeDoku in
command line mode:

    ./target/cafedoku INPUT

`INPUT` is a data file representing a sudoku problem. You can find examples
in the `examples/` directory. Try:

    ./target/cafedoku examples/sudoku1.dat
