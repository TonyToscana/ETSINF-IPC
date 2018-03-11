import java.math.BigInteger

/**
 * Created by Oreki on 03/03/2018.
 */
class Fibonacci {
    companion object {
        const val solution = 4782

        fun fibonacciDigits(): Int {
            var counter: Int = 3
            var fiboLast: BigInteger = BigInteger.valueOf(2)
            var tmp: BigInteger
            var fibo: BigInteger = BigInteger.valueOf(2)

            while (fiboLength(fibo) < 1000) {
                tmp = fibo
                fibo = fibo + fiboLast
                fiboLast = tmp
                ++counter
                //println("Iteration $counter, fibo $fibo")
            }
            return counter
        }
        fun fiboLength(i: BigInteger): Int {
            var length = 0
            var number: BigInteger = i
            while (number > BigInteger.valueOf(0)) {
                number = number/BigInteger.valueOf(10)
                ++length
            }
            return length
        }
    }
}