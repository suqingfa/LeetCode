package org.example

object MaximizeSumOfArrayAfterKNegations extends App {
  println(Solution.largestSumAfterKNegations(Array(4, 2, 3), 1))
  println(Solution.largestSumAfterKNegations(Array(3, -1, 0, 2), 3))
  println(Solution.largestSumAfterKNegations(Array(2, -3, -1, 5, -4), 2))

  object Solution {
    def largestSumAfterKNegations(nums: Array[Int], k: Int): Int = {
      import scala.collection.mutable

      val queue = mutable.PriorityQueue.empty[Int](Ordering.Int.reverse)
      queue.addAll(nums)

      for (_ <- 1 to k) {
        val value = queue.dequeue()
        queue.enqueue(-value)
      }

      queue.sum
    }
  }
}
