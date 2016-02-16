package iii_conventions

import util.*


class Invokable: (() -> Invokable) {

    private var invokeCount = 0

    override fun invoke(): Invokable {
        invokeCount += 1
        return this
    }

    fun getNumberOfInvocations(): Int {
        return invokeCount
    }


}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
//    todoTask31()
    return invokable()()()().getNumberOfInvocations()
}
