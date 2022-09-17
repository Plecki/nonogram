package usecase

import domain.model.BoardWithState
import domain.model.state.BoardStateFactory
import port.persistence.NonogramGetter
import port.persistence.NonogramPersistence
import port.presentation.NonogramPresentation

class NonogramPresentationUseCaseImpl(
    private val nonogramPresentation: NonogramPresentation,
    private val nonogramGetter: NonogramGetter,
    private val nonogramPersistence: NonogramPersistence,
    private val boardStateFactory: BoardStateFactory,
) : NonogramPresentationUseCase {

    override fun showNonogram() {
        val boardDefinition = nonogramGetter.getNonogram()
        val boardWithState = BoardWithState(boardDefinition, boardStateFactory.createEmpty(boardDefinition))
        nonogramPersistence.persist(boardWithState)
        nonogramPresentation.present(boardWithState)
    }
}