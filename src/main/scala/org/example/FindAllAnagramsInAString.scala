package org.example

object FindAllAnagramsInAString extends App {
  println(Solution.findAnagrams("cbaebabacd", "abc"))

  object Solution {
    def findAnagrams(s: String, p: String): List[Int] = {
      val map = p.groupMapReduce(identity)(_ => 1)(_ + _)

      s.sliding(p.length)
        .zipWithIndex
        .filter(map == _._1.groupMapReduce(identity)(_ => 1)(_ + _))
        .map(_._2)
        .toList
    }
  }
}
