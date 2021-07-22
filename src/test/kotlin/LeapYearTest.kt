import io.kotest.core.spec.style.ExpectSpec

class LeapYearTest : ExpectSpec({
    expect("leap year function") {
        isLeapYear()
    }
})

fun isLeapYear() {
    TODO("Not yet implemented")
}
