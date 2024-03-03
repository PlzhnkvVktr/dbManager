package ru.avem.enums

import androidx.compose.runtime.mutableStateOf


enum class Category (
    val title: String,
    val index: Int
) {
    TEST_EQUIPMENT("Испытательное оборудование", 1),
    AUTOMOTIVE_ELECTROMECHANICS("Автомобильная электромеханика", 2),
    DEVICES("Приборы", 3),
    TRAINING_DEMONSTRATION_STANDS("Учебные демонстрационные стенды", 4),
    HYDRAULIC_EQUIPMENT("Гидравлическое оборудование", 5),
    MEASURING_SYSTEMS("Измерительные системы", 6),
    OTHER_EQUIPMENT("Другое оборудование", 7);

    companion object {
        val currentCategoryIndex = mutableStateOf(1)
        val values by lazy {
            listOf(
                TEST_EQUIPMENT,
                AUTOMOTIVE_ELECTROMECHANICS,
                DEVICES,
                TRAINING_DEMONSTRATION_STANDS,
                HYDRAULIC_EQUIPMENT,
                MEASURING_SYSTEMS,
                OTHER_EQUIPMENT
            )
        }
        fun getCurrentCategory(): Category {
            return when (currentCategoryIndex.value) {
                1 -> TEST_EQUIPMENT
                2 -> AUTOMOTIVE_ELECTROMECHANICS
                3 -> DEVICES
                4 -> TRAINING_DEMONSTRATION_STANDS
                5 -> HYDRAULIC_EQUIPMENT
                6 -> MEASURING_SYSTEMS
                7 -> OTHER_EQUIPMENT
                else -> TEST_EQUIPMENT
            }
        }
    }

    override fun toString(): String = title

}

