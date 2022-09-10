package port.persistence

import domain.Board

interface NonogramGetter {

    fun getNonogram(): Board

}
