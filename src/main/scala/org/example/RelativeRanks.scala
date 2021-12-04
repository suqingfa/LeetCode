package org.example

object RelativeRanks extends App {
  println(Solution.findRelativeRanks(Array(5, 4, 3, 2, 1)).mkString("Array(", ", ", ")"))
  println(Solution.findRelativeRanks(Array(10, 3, 8, 9, 4)).mkString("Array(", ", ", ")"))

  object Solution {
    def findRelativeRanks(score: Array[Int]): Array[String] = {
      score
        .zipWithIndex
        .sortBy { case (score, _) => -score }
        .zipWithIndex
        .map { case ((_, index), rank) =>
          if (rank == 0)
            (index, "Gold Medal")
          else if (rank == 1)
            (index, "Silver Medal")
          else if (rank == 2)
            (index, "Bronze Medal")
          else
            (index, (rank + 1).toString)
        }
        .sortBy { case (index, _) => index }
        .map { case (_, rankString) => rankString }
    }
  }
}
