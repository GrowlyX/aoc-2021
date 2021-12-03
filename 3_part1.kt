import java.io.File
import java.util.*
import java.lang.*
import kotlin.collections.*

// took wayyy to long (2 hours)
fun main(args: Array<String>) 
{
	val allNumbers = mutableMapOf<Int, MutableList<Int>>()

	val mostCommon = mutableMapOf<Int, Int>()
	val leastCommon = mutableMapOf<Int, Int>()

 	val scanner = Scanner(
		File("inputs", "three.txt")
  	)

  	while (scanner.hasNextLine())
  	{
		var indexTest = 0
		val line = scanner.nextLine()

		// Iterates through each character in the line
		for (number in 0..line.length - 1)
		{
			// Parses the character to the numeric value
			val parsed = Character.getNumericValue(line.get(number))
	
			if (allNumbers[indexTest] == null)
			{
				allNumbers[indexTest] = mutableListOf<Int>()
			}

			// Adds the number to the list bound to this char index
			allNumbers[indexTest]?.add(parsed); indexTest++
		}
  	}

	var index = 0

	for (numbers in allNumbers.values)
	{
		val ones = numbers
			.filter { it -> it == 1 }.size
		val zeros = numbers
			.filter { it -> it == 0 }.size

		// adds the most common number
		mostCommon[index] = if (ones > zeros) 1 else 0
		leastCommon[index] = if (ones < zeros) 1 else 0

		index++
	}
	
	val mostCommonBinary = StringBuilder("")
	val leastCommonBinary = StringBuilder("")

	mostCommon.values.forEachIndexed { index, common ->
		mostCommonBinary.append(common.toString())
	}

	leastCommon.values.forEachIndexed {  index, common ->
		leastCommonBinary.append(common.toString())
	}
	
	val gammaRate = Integer.parseInt(mostCommonBinary.toString(), 2)
	val epsilonRate = Integer.parseInt(leastCommonBinary.toString(), 2)

	println("Gamma Rate: $gammaRate")
	println("Epsilon Rate: $epsilonRate")

	println("Consumption: ${epsilonRate * gammaRate}")
}
