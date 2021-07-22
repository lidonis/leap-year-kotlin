import io.kotest.core.spec.style.ExpectSpec

class LeapYearTest : ExpectSpec({
    expect("leap year function takes year as parameter") {
        isLeapYear(2021)
    }
})
