package org.example

object TruncateSentence extends App {
  println(Solution.truncateSentence("Hello how are you Contestant", 4))
  println(Solution.truncateSentence("chopper is not a tanuki", 5))

  object Solution {
    def truncateSentence(s: String, k: Int): String = {
      s.split(' ')
        .take(k)
        .mkString(" ")
    }
  }
}
