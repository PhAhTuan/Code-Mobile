package com.example.deadlinecty.util

import com.example.deadlinecty.model.ConfigResponse
import com.example.deadlinecty.model.LoginBody
import com.example.deadlinecty.model.SessionModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("api/v10/sessions")  // Ví dụ lấy thông tin user có id=1
    fun getSession(
        @Header("ProjectId") projectId: Int,
    ): Call<SessionModel>

    @GET("api/v10/configs")  // Ví dụ lấy thông tin user có id=1
    fun getConfig(
        @Header("ProjectId") projectId: Int,
        @Query("restaurant_name") restaurantName: String,
        @Query("project_id") projectIdParam: String,
    ): Call<ConfigResponse>

    //fun login(i: Int, string: String, string: String, string: String)
    //fun login(restaurantId: Int, authorization: String, username: String, password: String)
    @POST("api/v10/employees/login")
    fun login(
        @Header("Authorization") authorization: String,
        @Header("ProjectId") projectId: Int,
        @Query("ProjectId") projecId: Int,
        @Body body: LoginBody
    ): Call<com.example.deadlinecty.model.LoginResponse>
}