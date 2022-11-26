package port.presentation

import domain.model.state.Input

interface NonogramInput {

    fun provideInput(): Input

}