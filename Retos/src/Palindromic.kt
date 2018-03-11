import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * The palindromic number 595 is interesting because it can be written as the sum of consecutive squares: 6**2 + 7**2 + 8**2 + 9**2 + 10**2 + 11**2 + 12**2.
 * There are exactly eleven palindromes below one-thousand that can be written as consecutive square sums, and the sum of these palindromes is 4164.
 * Note that 1 = 0**2 + 1**2 has not been included as this problem is concerned with the squares of positive integers.
 * Find the sum of all the numbers less than 10**8 that are both palindromic and can be written as the sum of consecutive squares.
 *
 * 5 = 1**2 + 2**2
 *
 * Solution: 2906969179 :ok_hand:
 *
 */

class Palindromic {
    companion object {
        private const val max: Long = 100_000_000 //100_000_000
        const val solution = 2906969179

        fun getSum(arr: List<Long>): Long {
            var x: Long = 0
            for (i in arr) {
                x += i
            }
            return x
        }
        // 3 seconds
        private val array = ArrayList<Long>().apply {
            for (i in 1..max) {
                if (i == Companion.reverse(i)) this.add(i)
            }
        }

        fun getConsecutiveSquares(sqr: List<Long> = array): List<Long> {
            val arr = ArrayList<Long>()
            for (i in 0..(sqr.size - 1)) {
                if (isConsecutiveSquares(sqr[i], getSquares(sqr[i]))) arr.add(sqr[i])
            }
            return arr
        }

        fun getSquares(num: Long): List<Long> {
            val naruto = ArrayList<Long>()
            val numDouble = num.toDouble()

            for (i in 1..Math.sqrt((numDouble) - (num % 2)).toLong()) {
                naruto.add(i*i)
            }

            return naruto
        }

        fun isConsecutiveSquares(num: Long, list: List<Long>): Boolean {
            val length = list.size
            var sum: Long = 0

            for (i in 0.. (length - 1)) {
                var j = i
                var s = 0
                while(sum < num && j < length) {
                    sum += list[j++]
                    s++
                }

                if (sum == num && s > 1) return true
                sum = 0
            }
            return false
        }

        fun reverse(a: Long): Long {
            var number: Long = 0
            var j = a
            while (j > 0) {
                number = number * 10 + j % 10
                j /= 10
            }
            return number
        }

        fun getPalindromicArray() = array
    }
}