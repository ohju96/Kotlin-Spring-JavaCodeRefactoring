package com.group.libraryapp.domain.book

enum class BookType {
    //DB에는 인덱스 0부터 들어가게 된다. 문자가 들어가지는 않는다.
    // 이럴 때 Enum 순서가 바뀌게 되면 큰일이 난다. 때문에 삭제나 추가에 제한적이게 된다.
    COMPUTER,
    ECONOMY,
    SOCIETY,
    LANGUAGE,
    SCIENCE,
}