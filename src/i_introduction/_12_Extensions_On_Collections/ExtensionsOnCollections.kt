package i_introduction._12_Extensions_On_Collections

import util.*
import java.util.*

fun todoTask12(): Nothing = TODO(
    """
        Task 12.
        In Kotlin standard library there are lots of extension functions that make the work with collections more convenient.
        Rewrite the previous example once more using an extension function 'sortedDescending'.

        Kotlin code can be easily mixed with Java code.
        Thus in Kotlin we don't introduce our own collections, but use standard Java ones (slightly improved).
        Read about read-only and mutable views on Java collections.
    """,
    documentation = doc12()
)

fun task12(): List<Int> {
    fun List<Int>.sortedDescending() : List<Int> {
        Collections.sort(this, {x,y -> y.compareTo(x)})
        return this
    }
    return arrayListOf(1, 5, 2).sortedDescending()
}

