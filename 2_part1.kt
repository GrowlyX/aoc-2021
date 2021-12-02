import java.io.File
import java.util.*

val numberPair = MutablePair(0, 0)

val mutators = mutableMapOf<String, (Int) -> Unit>(
	"forward" to { numberPair.first += it },
	"down" to { numberPair.second += it },
	"up" to { numberPair.second -= it }
)

fun main(args: Array<String>) 
{
  val scanner = Scanner(
	File("inputs", "two.txt")
  )

  while (scanner.hasNextLine())
  {
	val split = scanner.nextLine().split(' ')
	
	mutators[split[0]]?.invoke(split[1].toInt())
  }

  println("The answer is: ${numberPair.first * numberPair.second}")
}

class MutablePair<T>(
	var first: T,
	var second: T
)
