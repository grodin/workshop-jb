package iii_conventions

import com.google.common.collect.ComparisonChain

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return ComparisonChain.start()
            .compare(this.year, other.year)
            .compare(this.month, other.month)
            .compare(this.dayOfMonth, other.dayOfMonth)
            .result()
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}



class DateRange(public override val start: MyDate, public override val endInclusive: MyDate): Iterable<MyDate>, ClosedRange<MyDate> {
    override fun contains(value: MyDate): Boolean {
        return (start <= value && value <= endInclusive)
    }

    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {

            private var currDate = start

            override fun next(): MyDate {
                if (!hasNext())
                    throw UnsupportedOperationException()
                else {
                    val ret = currDate
                    currDate = currDate.nextDay()
                    return ret
                }
            }

            override fun hasNext(): Boolean {
                return (currDate <= endInclusive)

            }

        }
    }
}

