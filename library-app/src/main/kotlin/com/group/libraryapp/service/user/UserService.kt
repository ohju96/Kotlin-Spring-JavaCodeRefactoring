package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.dto.user.response.BookHistoryResponse
import com.group.libraryapp.dto.user.response.UserLoanHistoryResponse
import com.group.libraryapp.dto.user.response.UserResponse
import com.group.libraryapp.util.fail
import com.group.libraryapp.util.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
        private val userRepository: UserRepository,
) {

    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val newUser = User(request.name, request.age)
        userRepository.save(newUser)
    }

    @Transactional(readOnly = true)
    fun getUsers(): List<UserResponse> {
        return userRepository.findAll()
                // 여러 방법으로 활용할 수 있다.
//                .map { user -> UserResponse(user) }
//                .map { ::UserResponse }
                .map { UserResponse.of(it) }
    }

    @Transactional
    fun updateUserName(request: UserUpdateRequest) {
        val user = userRepository.findByIdOrThrow(request.id) //확장 함수를 통해 코드를 간결하게 만들어 준다.
        user.updateName(request.name)
    }

    @Transactional
    fun deleteUser(name: String) {
//        val user = userRepository.findByName(name) ?: throw IllegalArgumentException() //옵셔널을 사용한 것 처럼 사용
        val user = userRepository.findByName(name) ?: fail() //코틀린 파일에 예외처리 메서드를 추가해 처리한다.
        userRepository.delete(user)
    }

    @Transactional(readOnly = true)
    fun getUserLoanHistories(): List<UserLoanHistoryResponse> {
        return userRepository.findAllWithHistories().map(UserLoanHistoryResponse::of)
    }
}
