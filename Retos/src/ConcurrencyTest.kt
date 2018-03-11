import java.lang.Thread.sleep
import kotlin.concurrent.thread

/**
 * Created by Oreki on 03/03/2018.
 */

    fun main(args: Array<String>) {
        val cases = ArrayList<Int>()
        val threads = ArrayList<Thread>()

        for (j in 0..3) {
            val sum = 100000/4
            threads.add(thread(name = j.toString()) {
                println("Thread $j starts")
                var caseThread = 0
                val nreOfMultiple = 1

                for (i in (j * sum + 1)..((j + 1) * sum)) {
                    caseThread++
                    //nreOfMultiple = 0
                }
                println("Thread $j: $caseThread")
                if (j == 3) sleep(2000)
                cases.add(caseThread)
                println("Thread $j ends")
            })
        }
        for (i in threads) {
            i.join()
        }

        println(cases.sum())
        //thread()
    }