import domain.BoardDefinition
import port.persistence.NonogramGetter

class GetBoardUseCaseImpl(
    private val nonogramGetter: NonogramGetter
) : GetBoardUseCase {

    override fun getBoard(): BoardDefinition {
        return nonogramGetter.getNonogram()
    }
}