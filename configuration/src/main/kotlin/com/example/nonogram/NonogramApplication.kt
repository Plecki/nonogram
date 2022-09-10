package com.example.nonogram

import BoardDefinitionConverter
import FileNonogramGetter
import LineDefinitionConverter
import NonogramPresentationUseCase
import NonogramPresentationUseCaseImpl
import RowColSplitter
import com.example.nonogram.terminal.TerminalPresentation
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import port.persistence.NonogramGetter
import port.presentation.NonogramPresentation

class NonogramApplication : KoinComponent {
    private val nonogramPresentationUseCase by inject<NonogramPresentationUseCase>()

    companion object {
        private val nonogramModule = module {
            singleOf(::BoardDefinitionConverter)
            singleOf(::RowColSplitter)
            singleOf(::LineDefinitionConverter)
            single { TerminalPresentation() as NonogramPresentation }
            single { FileNonogramGetter("simple-nonogram.txt", get()) as NonogramGetter }
            single { NonogramPresentationUseCaseImpl(get(), get()) as NonogramPresentationUseCase }
        }

        @JvmStatic
        fun main(args: Array<String>) {

            startKoin {
                printLogger()
                modules(nonogramModule)
            }

            NonogramApplication().showNonogram()
        }
    }

    private fun showNonogram() {
        nonogramPresentationUseCase.showNonogram()
    }
}