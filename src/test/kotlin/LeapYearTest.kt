import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

@ExperimentalKotest
class LeapYearTest : ExpectSpec({

    expect("2021 is not a leap year") {
        isLeapYear(2021) shouldBe false
    }

    context("A year is a leap year if it is divisible by 4") {
        withData(1984,
            2016,
            2020,
        ) { year ->
            isLeapYear(year) shouldBe true
        }
    }
})
