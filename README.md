CAFEDOKU
========

CafeDoku is a [sudoku](http://en.wikipedia.org/wiki/Sudoku) solver written in
Scala and based on the [CafeSat](https://github.com/regb/scabolic) SAT solver.

Usage
-----

You can build CafeDoku using sbt:

    sbt cafedoku

sbt will then generate a `cafedoku` script that you can use to run CafeDoku in
command line mode:

    ./cafedoku INPUT

`INPUT` is a data file representing a sudoku problem. You can find examples
in the `examples/` directory.
