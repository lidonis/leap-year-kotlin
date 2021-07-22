fun isLeapYear(year: Int) = year isDivisibleBy 4

infix fun Int.isDivisibleBy(divider: Int) = this % divider == 0