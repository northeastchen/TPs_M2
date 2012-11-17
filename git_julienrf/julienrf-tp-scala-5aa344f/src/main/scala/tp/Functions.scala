package tp

import annotation.tailrec

object Functions {

  def fibonacci(n: Int): Int =
    if (n <= 2)
      1
    else
      fibonacci(n - 1) + fibonacci(n - 2)

  def fibonacciRec(n: Int): Int = ???

  def show(f: Int => Int, xs: Int*): Unit =
    for (x <- xs) {
      println(f(x))
    }
}
