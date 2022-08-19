package com.group.libraryapp.calculator

class Calculator(
        var number: Int
        // setter를 열어두지만 사용하지 않는 방법.
        // data 클래스를 사용하는 방법
        // 커스텀 객체를 통해 이용
) { // 커맨드 N으로 패키지 생성

    fun add(operand: Int) {
        this.number += operand
    }

    fun minus(operand: Int) {
        this.number -= operand
    }

    fun multiply(operand: Int) {
        this.number *= operand
    }

    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        this.number /= operand
    }
}