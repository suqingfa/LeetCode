package org.example


object RansomNote extends App {
  println(Solution.canConstruct("a", "b")) // false
  println(Solution.canConstruct("aa", "ab")) // false
  println(Solution.canConstruct("abb", "ab")) // false
  println(Solution.canConstruct("aa", "aab")) // true

  object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
      val ransomNoteMap = ransomNote.groupBy(identity).map { case (char, string) => char -> string.length }
      val magazineMap = magazine.groupBy(identity).map { case (char, string) => char -> string.length }.withDefaultValue(0)

      ransomNoteMap.map { case (char, int) => magazineMap(char) >= int }.reduce(_ && _)
    }
  }
}
