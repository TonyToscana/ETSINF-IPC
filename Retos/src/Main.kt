import Fibonacci.Companion.fibonacciDigits
import Palindromic.Companion.getConsecutiveSquares
import Palindromic.Companion.getPalindromicArray
import Palindromic.Companion.getSquares
import Palindromic.Companion.getSum
import Palindromic.Companion.reverse
import TrianglesConcurrent.Companion.totalRightTriangles
import java.lang.Thread.sleep
import kotlin.concurrent.thread

/**
 * Created by Oreki on 03/03/2018.
 */

fun main(args: Array<String>) {
    println("Lista de retos:")
    println()

    val start = System.currentTimeMillis()

/*    val fibo = fibonacciDigits()
    println("Fibonacci, problem 25: $fibo, ${fibo == Fibonacci.solution}")

    //7 minutes
    val tri = totalRightTriangles()
    println("Right triangles, problem 75: $tri, ${tri == Triangles.solution}")

    val squares = getSum(getConsecutiveSquares())

    println("Palindromic squares sum, problem 125: $squares, ${squares == Palindromic.solution} ")*/
    val tri = totalRightTriangles()
    println("Right triangles, problem 75: $tri, ${tri == Triangles.solution}")

    val end = System.currentTimeMillis()

    println("Time elapsed: ${end-start} ms")


}