/**
 * Created by Oreki on 07/03/2018.
 */
fun main(args: Array<String>) {
    println(Esta(20))
}
public class Esta(val tamaño: Int) {
    override fun toString(): String {
        var res: String = "8"
        for (i in 1..tamaño) {
            res += "="
        }
        res += "D"
        return res
    }
}