package co.pinkroom.multiplatformtemplate

import co.pinkroom.multiplatformtemplate.domain.GetRecipe
import kotlin.browser.*
import kotlin.dom.*

fun main(args: Array<String>) {
    val recipe = GetRecipe().run()
    document.getElementById("tooltip")?.appendText(recipe.title)
}