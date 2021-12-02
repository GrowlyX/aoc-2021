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

	var startIndex = 0
	var endIndex = 2

	while (scanner.hasNextInt())
	{
		val currentNumber = scanner.nextInt()
		integers.add(currentNumber)

		if (integers.size < 3)
		{
			continue
		}

		val numberSubList = integers.subList(
			startIndex, endIndex + 1
		)

		val previousSum = if (integerSums.isEmpty())
			Int.MAX_VALUE else integerSums.last()

		val sumOfIntegers = numberSubList.sum()
		integerSums.add(sumOfIntegers)

		if (sumOfIntegers > previousSum)
		{
			greaterThanPrevious++
		}

		startIndex++; endIndex++
	}

	println("The answer is: $greaterThanPrevious")
}
