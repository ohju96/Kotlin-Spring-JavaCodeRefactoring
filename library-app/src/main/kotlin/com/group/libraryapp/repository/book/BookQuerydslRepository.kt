package com.group.libraryapp.repository.book

import com.group.libraryapp.domain.book.QBook.book
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class BookQuerydslRepository(
        private val queryFactory: JPAQueryFactory,
) {

    fun getStats(): List<BookStatResponse> {
        return queryFactory
                .select(
                        Projections.constructor( // 주어진 dto의 생성자를 호출한다는 의미이다.
                                BookStatResponse::class.java,
                                book.type,
                                book.id.count()
                        ))
                .from(book)
                .groupBy(book.type)
                .fetch()
    }
}