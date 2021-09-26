package pbt.kotlin.jqwik

import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.constraints.AlphaChars
import net.jqwik.api.constraints.NumericChars
import net.jqwik.api.constraints.Size
import net.jqwik.api.constraints.WithNull
import java.math.BigDecimal

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
    fun propertyWithAnnotatedParameterTypes(@ForAll list: @Size(5) List<@NumericChars String>) {
        //println(list)
    }

    @Property(tries = 30)
    fun propertyWithNullableParameter(@ForAll nullOrString: String?) {
        //println(nullOrString)
    }

    @Property(tries = 30)
    fun propertyWithNullableParameterType(@ForAll list: List<@WithNull(0.5) Int>) {
        //println(list)
    }

    @Property
    fun `property with a long name`(@ForAll aNumber: BigDecimal) {
    }
}