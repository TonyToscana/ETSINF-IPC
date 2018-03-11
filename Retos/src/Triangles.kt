/**
 * TODO implement with matrices
 * Time with current implementation: 7 minutes
 * https://en.wikipedia.org/wiki/Tree_of_primitive_Pythagorean_triples#Presence_of_every_primitive_Pythagorean_triple_exactly_once
 */

/**
 * Created by Oreki on 03/03/2018.
 */
class Triangles {
    companion object {
        const val maxLength = 1500000
        const val solution = 161667

        fun totalRightTriangles(len: Int = maxLength): Int {
            var cases = 0
            var nreOfMultiple = 0
            val arr = pythagoricTriples()

            for (i in 12..len) {
                //println(i)
                for (j in arr) {
                    if (j > i) break
                    if(isMultiple(i, j)) nreOfMultiple++
                }
                if (nreOfMultiple == 1) cases++
                nreOfMultiple = 0
            }

            return cases
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