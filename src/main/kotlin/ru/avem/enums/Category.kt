package ru.avem.enums


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
    }
    override fun toString(): String = title

}

