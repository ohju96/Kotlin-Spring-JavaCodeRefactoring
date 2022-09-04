package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.user.User


interface UserRepositoryCustom {

    fun findAllWithHistories(): List<User>
}