package days

import lib.readFile

fun day03part1(input: String): Int {
    return Regex("""mul\(\d{1,3},\d{1,3}\)""")
        .findAll(input)
        .map {
            it.value.replace("mul(", "")
                .replace(")", "")
                .split(",")
                .map { digit -> digit.toInt() }
                .reduce { a, b -> a * b }
        }
        .sum()
}

fun keywordStart(keyword: String, input: String): Sequence<Pair<Int, String>> {
    return Regex("""$keyword\(\)""").findAll(input)
        .map { Pair(it.range.first, keyword) }
}

fun day03part2(input: String): Int {
    // add virtual do and don't for the windowing to work
    val modifiedInput = "do()${input}don't()"

    val keywords =  (keywordStart("don't", modifiedInput) + keywordStart("do", modifiedInput))
        .sortedBy { it.first }
        .toList()

    return keywords
        .filterIndexed { i, it -> if (i > 0) it.second != keywords[i - 1].second else true }
        .windowed(2, 2)
        .map { modifiedInput.slice(IntRange(it[0].first, it[1].first)) }
        .sumOf { day03part1(it) }
}

fun day03() {
    val input = readFile("data/day_03.txt")

    println("Part 1: " + day03part1(input))
    println("Part 2: " + day03part2(input))
}
