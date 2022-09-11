package port.persistence

import domain.definition.BoardDefinition

interface NonogramGetter {

    fun getNonogram(): BoardDefinition

}
