import java.io.File
import java.util.*

fun main()
{
	val scanner = Scanner(
		File("inputs", "one.txt")
	)

	val integers = mutableListOf<Int>()
	val integerSums = mutableListOf<Int>()

	var greaterThanPrevious = 0
	val indexDelta = MutablePair(0, 2)

	while (scanner.hasNextInt())
	{
		val currentNumber = scanner.nextInt()
		integers.add(currentNumber)

		if (integers.size < 3)
		{
			continue
		}

		val numberSubList = integers.subList(
			indexDelta.first, indexDelta.second + 1
		)

		val previousSum = if (integerSums.isEmpty())
			Int.MAX_VALUE else integerSums.last()

		val sumOfIntegers = numberSubList.sum()
		integerSums.add(sumOfIntegers)

		if (sumOfIntegers > previousSum)
		{
			greaterThanPrevious++
		}

		indexDelta.first++; indexDelta.second++
	}

	println("The answer is: $greaterThanPrevious")
}

class MutablePair<T>(
	var first: T,
	var second: T
)
