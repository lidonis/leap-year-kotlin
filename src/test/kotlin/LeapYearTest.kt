import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class LeapYearTest : ExpectSpec({
    expect("2021 is not a leap year") {
        isLeapYear(2021) shouldBe false
    }

    expect("2020 is a leap year") {
        isLeapYear(2020) shouldBe true
    }
})
