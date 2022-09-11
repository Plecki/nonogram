package com.example.nonogram

import BoardDefinitionConverter
import FileNonogramGetter
import LineDefinitionConverter
import RowColSplitter
import com.example.nonogram.desktop.DesktopPresentation
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import port.persistence.NonogramGetter
import port.presentation.NonogramPresentation
import usecase.GetBoardUseCase
import usecase.GetBoardUseCaseImpl
import usecase.NonogramPresentationUseCase
import usecase.NonogramPresentationUseCaseImpl

class NonogramApplication : KoinComponent {
    private val nonogramPresentationUseCase by inject<NonogramPresentationUseCase>()

    companion object {
        private val nonogramModule = module {
            singleOf(::BoardDefinitionConverter)
            singleOf(::RowColSplitter)
            singleOf(::LineDefinitionConverter)
            single { DesktopPresentation() as NonogramPresentation }
            single { FileNonogramGetter("simple-nonogram.txt", get()) as NonogramGetter }
            single { NonogramPresentationUseCaseImpl(get(), get()) as NonogramPresentationUseCase }
            single { GetBoardUseCaseImpl(get()) as GetBoardUseCase }
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