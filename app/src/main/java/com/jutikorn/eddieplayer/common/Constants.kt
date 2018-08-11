package com.jutikorn.eddieplayer.common

class Constants {

    open class SingletonHolder<out T, in A>(creator: (A) -> T) {
        private var creator: ((A) -> T)? = creator
        @Volatile private var instance: T? = null

        fun getInstance(arg: A): T {
            val i = instance
            if (i != null) {
                return i
            }

            return synchronized(this) {
                val i2 = instance
                if (i2 != null) {
                    i2
                } else {
                    val created = creator!!(arg)
                    instance = created
                    creator = null
                    created
                }
            }
        }
    }


    open class SingletonHolder2Arguments<out T, in A1, in A2>(creator: (A1, A2) -> T) {
        private var creator: ((A1, A2) -> T)? = creator
        @Volatile private var instance: T? = null

        fun getInstance(arg1: A1, arg2: A2): T {
            val i = instance
            if (i != null) {
                return i
            }

            return synchronized(this) {
                val i2 = instance
                if (i2 != null) {
                    i2
                } else {
                    val created = creator!!(arg1, arg2)
                    instance = created
                    creator = null
                    created
                }
            }
        }
    }

    open class SingletonHolder3Arguments<out T, in A1, in A2, in A3>(creator: (A1, A2, A3) -> T) {
        private var creator: ((A1, A2, A3) -> T)? = creator
        @Volatile private var instance: T? = null

        fun getInstance(arg1: A1, arg2: A2, arg3: A3): T {
            val i = instance
            if (i != null) {
                return i
            }

            return synchronized(this) {
                val i2 = instance
                if (i2 != null) {
                    i2
                } else {
                    val created = creator!!(arg1, arg2, arg3)
                    instance = created
                    creator = null
                    created
                }
            }
        }
    }
}