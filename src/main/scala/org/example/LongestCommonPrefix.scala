package org.example

object LongestCommonPrefix extends App {
  println(Solution.longestCommonPrefix(Array("flower", "flow", "flight")))
  println(Solution.longestCommonPrefix(Array("dog", "racecar", "car")))

  object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
      strs.reduce((a, b) => (a zip b)
        .takeWhile(Function.tupled(_ == _))
        .map(_._1)
        .mkString
      )
    }
  }
}
