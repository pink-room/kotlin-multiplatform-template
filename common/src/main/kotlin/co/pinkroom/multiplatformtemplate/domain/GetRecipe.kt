package co.pinkroom.multiplatformtemplate.domain

import co.pinkroom.multiplatformtemplate.data.Recipe

class GetRecipe {

    fun run(): Recipe {
        return Recipe("Bacalhau com Natas!")
    }
}