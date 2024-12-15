import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.filterNot
import io.kotest.property.arbitrary.negativeInt
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.checkAll

class LeapYearTest : FreeSpec({

    "A year is not a leap year" - {
        "if not divisible by 4" {
            checkAll(Arb.positiveInt().filterNot { it isDivisibleBy 4 }) { year ->
                isLeapYear(year) shouldBe false
            }
        }
        "if divisible by 100 but not by 400" {
            checkAll(Arb.positiveInt().filter { (it isDivisibleBy 100) && !(it isDivisibleBy 400) }) { year ->
                isLeapYear(year) shouldBe false
            }
        }
    }

    "A year is a leap year" - {
        "if divisible by 4 but not by 100" {
            checkAll(Arb.positiveInt().filter { (it isDivisibleBy 4) && !(it isDivisibleBy 100) }) { year ->
                isLeapYear(year) shouldBe true
            }
        }
        "if divisible by 400" {
            checkAll(Arb.positiveInt().filter { it isDivisibleBy 400 }) { year ->
                isLeapYear(year) shouldBe true
            }
        }
    }

    "A year is supported" - {
        "if it is positive" {
            checkAll(Arb.positiveInt()) { year ->
                shouldNotThrow<UnsupportedOperationException> {
                    isLeapYear(year)
                }
            }
        }
    }

    "A year is not supported" - {
        "if it is zero" {
            shouldThrow<UnsupportedOperationException> {
                isLeapYear(0)
            }
        }
        "if it is negative" {
            checkAll(Arb.negativeInt()) { year ->
                shouldThrow<UnsupportedOperationException> {
                    isLeapYear(year)
                }
            }
        }
    }
})
