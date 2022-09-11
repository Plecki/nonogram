package usecase

import port.persistence.NonogramGetter
import port.presentation.NonogramPresentation

class NonogramPresentationUseCaseImpl(
    private val nonogramPresentation: NonogramPresentation,
    private val nonogramGetter: NonogramGetter,
) : NonogramPresentationUseCase {

    override fun showNonogram() {
        val nonogram = nonogramGetter.getNonogram()
        nonogramPresentation.present(nonogram)
    }
}