package port.persistence

import domain.BoardDefinition

interface NonogramGetter {

    fun getNonogram(): BoardDefinition

}
