package com.example.flocator.authentication.client

import com.example.flocator.authentication.client.dto.UserCredentialsDto
import com.example.flocator.authentication.client.dto.UserRegistrationDto
import com.example.flocator.main.models.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthenticationApi {
    @POST("/api/user/register")
    fun registerUser(@Body userRegistrationDto: UserRegistrationDto): Single<Boolean>

    @POST("/api/user/login")
    fun loginUser(@Body userCredentialsDto: UserCredentialsDto): Single<Long>

    @GET("/api/user/{userId}")
    fun getUserById(@Path("userId") userId: Long): Single<User>

    @GET("/api/user/is_login_available")
    fun isLoginAvailable(@Query("login") login: String): Single<Boolean>

    @GET("/api/user/is_email_available")
    fun isEmailAvailable(@Query("email") email: String): Single<Boolean>
}