package iv_properties

import util.*

class LazyProperty(val initializer: () -> Int) {
    private var _lazy = 0
    private var _lazy_initialized = false
    val lazy: Int
        get() {
            if (!_lazy_initialized) {
                _lazy = initializer()
                _lazy_initialized = true
            }
            return _lazy
        }
}

fun todoTask33(): Nothing = TODO(
    """
        Task 33.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegated properties!
    """,
    references = { LazyProperty({ 42 }).lazy }
)
