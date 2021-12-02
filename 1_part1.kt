import java.io.File
import java.util.*

fun main()
{
	val scanner = Scanner(
		File("inputs", "one.txt")
	)
	val integers = mutableListOf<Int>()
	var greaterThanPrevious = 0

	while (scanner.hasNextInt())
	{
		val previous = if (integers.isEmpty())
			Int.MAX_VALUE else integers.last()

		val current = scanner.nextInt()
		integers.add(current)

		if (current > previous)
		{
			greaterThanPrevious++
		}
	}

	println("The answer is: $greaterThanPrevious")
}
