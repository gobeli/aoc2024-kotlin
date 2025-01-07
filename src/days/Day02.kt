package days

import lib.readFileLines
import kotlin.math.abs


fun day02Part1(line: List<Int>): Boolean {
    val dir = line[1] - line[0] > 0
    for (i in 0..line.size - 2) {
        val diff = line[i + 1] - line[i];
        if (diff > 0 != dir || diff == 0 || abs(diff) > 3) {
            return false
        }
    }
    return true
}

fun day02Part2(line: List<Int>): Boolean {
    val dir = line[1] - line[0] > 0
    var badValue = 0
    for (i in 0..line.size - 2) {
        val diff = line[i + 1] - line[i];
        if (diff > 0 != dir || diff == 0 || abs(diff) > 3) {
            if (badValue < 1) {
                badValue++
            } else {
                return false
            }
        }
    }
    return true
}

fun day02() {
    val reports = readFileLines("data/day_02.txt")
        .map { line -> line.split(" ").map { it.toInt() } }

    val part01 = reports
        .filter { day02Part1(it) }
        .size

    val part02 = reports
        .filter { day02Part2(it) }
        .size

    println("Part 1: " + part01)
    println("Part 2: " + part02)
}
