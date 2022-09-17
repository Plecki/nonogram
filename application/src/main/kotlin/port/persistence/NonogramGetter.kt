package port.persistence

import domain.model.definition.BoardDefinition

interface NonogramGetter {

    fun getNonogram(): BoardDefinition

}
