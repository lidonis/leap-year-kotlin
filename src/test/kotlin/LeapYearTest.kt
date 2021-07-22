import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class LeapYearTest : ExpectSpec({

    context("A year is not a leap year") {
        expect("if not divisible by 4") {
            checkAll(Arb.int().filter { !(it isDivisibleBy 4) }) { a ->
                isLeapYear(a) shouldBe false
            }
        }
        expect("if divisible by 100 but not by 400") {
            checkAll(Arb.int().filter { (it isDivisibleBy 100) && !(it isDivisibleBy 400) }) { a ->
                isLeapYear(a) shouldBe false
            }
        }
    }

    context("A year is a leap year") {
        expect("if divisible by 4") {
            checkAll(Arb.int().filter { it isDivisibleBy 4 }) { a ->
                isLeapYear(a) shouldBe true
            }
        }
        expect("if divisible by 400") {
            checkAll(Arb.int().filter { it isDivisibleBy 400 }) { a ->
                isLeapYear(a) shouldBe true
            }
        }
    }
})
