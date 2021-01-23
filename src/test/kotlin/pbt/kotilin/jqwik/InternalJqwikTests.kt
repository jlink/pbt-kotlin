package pbt.kotilin.jqwik

import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.constraints.AlphaChars

internal class InternalJqwikTests {

    @Property
    internal fun aProperty(@ForAll @AlphaChars aString: String) {
        //println(aString)
    }

    @Property
    internal fun anotherProperty(@ForAll anInt: Int) {
        //println(anInt)
    }
}