fun isLeapYear(year: Int) = when {
    year isDivisibleBy 400 -> true
    year isDivisibleBy 100 -> false
    else -> year isDivisibleBy 4
}

infix fun Int.isDivisibleBy(divider: Int) = this % divider == 0