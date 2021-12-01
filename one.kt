import java.io.*
import java.net.URL

fun main(args: Array<String>) 
{
 	val url = URL("https://gist.githubusercontent.com/GrowlyX/4bcfca53f521aa7fdfe71bc342dcf2c0/raw/a55c3bb423b69845a70f15f3426cc9050131811a/numbers")

	val reader = BufferedReader(
		InputStreamReader(url.openStream())
	)
	val numbers = mutableListOf<Int>()
	var line: String?

	while (reader.readLine().also { line = it } != null) 
	{
		numbers.add(line!!.toInt())
	}

	var amountGreater = 0

	numbers.forEachIndexed { index, number -> 
		try
		{
			if (numbers[index - 1] < number)
			{
				amountGreater++
			}
		} catch (ignored: Exception)
		{

		}
	}

	println("The amount is: ${amountGreater}")
}
