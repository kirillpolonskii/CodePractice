package top_interview_150.sliding_window.hard

import java.util.LinkedList

class Solution30 {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordsSize = words[0].length
        val totalWordLength = wordsSize * words.size
        val result = ArrayList<Int>()
        val wordsToAmount = hashMapOf<String, Int>()
        for (word in words) {
            wordsToAmount[word] = wordsToAmount.getOrDefault(word, 0) + 1
        }
        for (offset in 0 until wordsSize) {
            var start = offset
            val seenMap = hashMapOf<String, Int>()
            val queue = LinkedList<String>()
            while (start + wordsSize <= s.length) {
                val currentWord = s.substring(start, start + wordsSize)
                if (wordsToAmount.containsKey(currentWord)) {
                    queue.offer(currentWord)
                    seenMap[currentWord] = seenMap.getOrDefault(currentWord, 0) + 1

                    while (seenMap[currentWord]!! > wordsToAmount[currentWord]!!) {
                        val removedWord = queue.poll()
                        seenMap[removedWord] = seenMap[removedWord]!! - 1
                    }

                    if (queue.size == words.size) {
                        result.add(start - totalWordLength + wordsSize)
                    }
                } else {
                    queue.clear()
                    seenMap.clear()
                }
                start += wordsSize
            }
        }
        return result
    }
}