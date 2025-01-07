package days

import lib.readFileLines
import kotlin.math.abs

fun day01Part1(input: List<List<Int>>): Int {
    val sorted = input.map { it.sorted() }
    return sorted[0].zip(sorted[1]).sumOf { abs(it.second - it.first) }
}

fun day01Part2(input: List<List<Int>>): Int {
    return input[0]
        .fold(0) { acc, value -> acc + value * input[1].filter { it == value }.size }
}

fun day01() {
    val input = readFileLines("data/day_01.txt")
        .map { it.split("   ") }
        .fold(listOf(listOf(), listOf<Int>())) { acc, next ->
            acc
                .zip(next.map { it.toInt() })
                .map { it.first + listOf(it.second) }
        }

    println("Part 1: " + day01Part1(input))
    println("Part 2: " + day01Part2(input))
}