package org.example

object KThSmallestPrimeFraction extends App {
  println(Solution.kthSmallestPrimeFraction(Array(1, 2, 3, 5), 3).mkString("Array(", ", ", ")"))
  println(Solution.kthSmallestPrimeFraction(Array(1, 7), 1).mkString("Array(", ", ", ")"))

  object Solution {
    def kthSmallestPrimeFraction(arr: Array[Int], k: Int): Array[Int] = {
      val seq = for {
        i <- arr.indices
        j <- (i + 1) until arr.length
      } yield Fractional(arr(i), arr(j))

      val sorted = seq.sorted
      val result = sorted(k - 1)
      Array(result.n, result.d)
    }

    case class Fractional(n: Int, d: Int) extends Ordered[Fractional] {
      override def compare(that: Fractional): Int = this.n * that.d - that.n * this.d
    }
  }
}
