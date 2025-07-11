package com.example.deadlinecty.util


// Dữ liệu gửi lên API
data class LoginRequest(
    val username: String,
    val password: String
)

// Dữ liệu API trả về
data class LoginResponse(
    val status: Int,
    val message: String,
    val data: DataResponse?
)

data class DataResponse(
    val token: String,
    val userId: Int
)
