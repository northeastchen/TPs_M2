package tp

/**
 * The code inside this object will be executed when you’ll hit `sbt run`
 */
object Main extends App {

  println(Functions.fibonacci(6))

  //  val xs = IntList(1, 2, 3)
  //  println(xs)
  //
  //  println(xs.map(x => x * x))

  Functions.show(x => x * x, 1, 2, 3)
  println(IntList(1, 2).toString)
  IntList(1, 2, 3).foreach(x => println(x % 2 == 1))
  println(IntList(1, 2, 3).map(x => x + 1))
  println(IntList(1, 2, 3).filter(x => x <= 2))

  println(IntList(1, 2, 3, 4).sum)
  println(IntList(1, 2, 3, 4).product)

  println(IntList(1, 2, 3).forall(x => x <= 3))
}
