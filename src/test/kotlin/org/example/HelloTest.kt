package org.example

import io.kotlintest.specs.ShouldSpec
import kotlin.test.fail

class HelloTest : ShouldSpec({

    should("fail") {
        fail("test failed on purpose")
    }

    should("pass") {
        assert(true)
    }

})
