fun isLeapYear(year: Int): Boolean {
    return if (year isDivisibleBy 4) {
        if (year isDivisibleBy 100) {
            year isDivisibleBy 400
        } else true
    } else false
}

infix fun Int.isDivisibleBy(divider: Int) = this % divider == 0