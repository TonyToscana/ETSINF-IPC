import kotlin.concurrent.thread

/**
 * Created by Oreki on 03/03/2018.
 */

class TrianglesConcurrent {
    companion object {
        const val maxLength = 1500000
        const val solution = 161667

        fun totalRightTriangles(len: Int = maxLength): Int {
            val cases = ArrayList<Int>()
            val arr = pythagoricTriples()
            val threads = ArrayList<Thread>()

            for (j in 0..99) {
                val sum = maxLength/100
                threads.add(thread {
                    //println("Thread $j starts")
                    var caseThread = 0
                    var nreOfMultiple = 0

                    for (i in (j * sum + 1)..((j + 1) * sum)) {
                        for (z in arr) {
                            if (z > i) break
                            if(isMultiple(i, z)) nreOfMultiple++
                        }
                        if (nreOfMultiple == 1) caseThread++
                        nreOfMultiple = 0
                    }
                    //println("Thread $j ends with: $caseThread cases")
                    cases.add(caseThread)
                })
            }
            threads.forEach { it.join() }
            println(cases.sum())
            return cases.sum()
        }

        //Optimized fun

        fun pythagoricTriples(): List<Int> {
            var a: Int
            var b: Int
            var c: Int
            val lim = Math.sqrt(maxLength.toDouble()).toInt() + 1
            val leng = ArrayList<Int>()

            for (m in 1..lim) {
                val range = (1 + (m % 2))..(m - 1) step 2 //(maxLength/(2 * m) - m) step 2
                for (n in range) {
                    if (euclides(m, n)){
                        a = m * m - n * n
                        b = 2 * m * n
                        c = m * m + n * n

                        leng.add(a + b + c)
                    }
                }
            }
            return leng.sorted()
        }

        fun euclides(a: Int, b: Int): Boolean {
            var ab = a
            var cd = b
            var res = -1

            while (res != 0) {
                (ab % cd).let {
                    when(it) {
                        0 -> return cd == 1
                        else -> res = it
                    }
                }
                ab = cd
                cd = res
            }
            return res == 1
        }

        fun isMultiple(a: Int, b: Int) = a % b == 0
    }
}