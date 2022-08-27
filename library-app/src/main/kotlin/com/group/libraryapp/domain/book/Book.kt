package com.group.libraryapp.domain.book

import javax.persistence.*

@Entity
class Book(
        val name: String,

        @Enumerated(EnumType.STRING) //인덱스로 저장되어 삭제 및 추가에 제한적인 상황을 개선할 수 있다.
        val type : BookType,

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어있을 수 없습니다.")
        }
    }

    companion object {
        fun fixture(
                name: String = "책 이름",
                type: BookType = BookType.COMPUTER,
                id: Long? = null,
        ): Book {
            return Book(
            name = name,
            type = type,
            id = id,
            )
        }
    }
}