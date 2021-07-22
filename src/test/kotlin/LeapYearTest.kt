import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class LeapYearTest : ExpectSpec({
    expect("2021 is not a leap year") {
        isLeapYear(2021) shouldBe false
    }
})
