package com.travel.travelapi.services

import com.travel.travelapi.auth.TravelUserDetails
import com.travel.travelapi.models.Permission
import com.travel.travelapi.models.Role
import com.travel.travelapi.models.User
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository
interface AuthService {
    fun getUserByIdentifier(@Param("identifier") identifier: String): User
    fun identifierExists(@Param("email") email: String): String
    fun createUser(@Param("user") user: User)

    fun getUserRoles(@Param("user") user: User): ArrayList<Role>
    fun getUserPermissions(@Param("roles") roles: ArrayList<Role>): ArrayList<Permission>

    fun mapUserRoles(@Param("user") user: User)
}