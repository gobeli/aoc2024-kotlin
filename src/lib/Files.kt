package lib

import java.io.BufferedReader
import java.io.File

fun readFile(pathname: String): List<String> {
    val bufferedReader: BufferedReader = File(pathname).bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
    return inputString.split("\n")
}

