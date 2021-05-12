package com.ssantano.project.data.model.error

import java.lang.Exception

class KoreException(val asyncError: AsyncError): Exception() {

    override fun toString(): String {
        return asyncError.toString()
    }

}