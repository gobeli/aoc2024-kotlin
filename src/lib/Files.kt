package lib

import java.io.BufferedReader
import java.io.File

fun readFileLines(pathname: String): List<String> {
    return readFile(pathname).split("\n")
}

fun readFile(pathname: String): String {
    val bufferedReader: BufferedReader = File(pathname).bufferedReader()
    return bufferedReader.use { it.readText() }
}
