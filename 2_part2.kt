import java.io.File
import java.util.*

val numberTriple = MutableTriple(0, 0, 0)

val mutators = mutableMapOf<String, (Int) -> Unit>(
	"forward" to { 
		numberTriple.first += it 
		numberTriple.second += numberTriple.third * it
	},
	"down" to { numberTriple.third += it },
	"up" to { numberTriple.third -= it }
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

  println("The answer is: ${numberTriple.first * numberTriple.second}")
}

class MutableTriple<T>(
	var first: T,
	var second: T,
	var third: T
)
