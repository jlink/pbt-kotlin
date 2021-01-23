package pbt.kotilin.jqwik

import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.constraints.AlphaChars
import net.jqwik.api.constraints.NumericChars
import net.jqwik.api.constraints.Size

class PlainJqwikTests {

    @Property
    fun aProperty(@ForAll @AlphaChars aString: String) {
        //println(aString)
    }

    @Property
    fun anotherProperty(@ForAll anInt: Int) {
        //println(anInt)
    }

    @Property(tries = 30)
    fun test(@ForAll list: @Size(5) List<@NumericChars String>) {
        println(list)
    }
}