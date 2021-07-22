import io.kotest.common.ExperimentalKotest
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

@ExperimentalKotest
class LeapYearTest : ExpectSpec({

    context("A year is not a leap year") {
        expect("if not divisible by 4") {
            checkAll(Arb.int().filter { it % 4 != 0 }) { a ->
                isLeapYear(a) shouldBe false
            }
        }
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
