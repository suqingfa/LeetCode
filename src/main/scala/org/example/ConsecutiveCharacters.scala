package org.example

object ConsecutiveCharacters extends App {
  println(Solution.maxPower("leetcode"))
  println(Solution.maxPower("abbcccddddeeeeedcba"))
  println(Solution.maxPower("hooraaaaaaaaaaay"))
  println(Solution.maxPower("tourist"))

  object Solution {
    def maxPower(s: String): Int = {
      var max = 0
      var preC = '\u0000'
      var preCount = 0
      for (c <- s) {
        if (preC == c)
          preCount += 1
        else {
          preC = c
          preCount = 1
        }

        max = if (max < preCount) preCount else max
      }

      max
    }
  }
}
