package io.luan.bank.types;

data class PhoneNumber(val number: String) {
    init {
//        if (isValid(number)) {
//            throw IllegalArgumentException()
//        }
    }

    fun getAreaCode(): String? {
        for (i in 0 until number.length) {
            val prefix = number.substring(0, i)
            if (isAreaCode(prefix)) {
                return prefix
            }
        }
        return null
    }

    companion object {
        private fun isAreaCode(prefix: String): Boolean {
            val areas = arrayOf("0571", "021", "010")
            return areas.asList().contains(prefix)
        }

        fun isValid(number: String): Boolean {
            val pattern = "^0?[1-9]{2,3}-?\\d{8}$"
            return number.matches(pattern.toRegex())
        }
    }

}