package com.travel.travelapi.auth

import com.travel.travelapi.models.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.core.user.OAuth2User
import java.util.*
import kotlin.collections.ArrayList


data class TravelUserDetails(private val id: Long? = null,
                             private val username: String?=null,
                             private val password: String?=null,
                             private val grantedAuthorities: List<GrantedAuthority?>?= ArrayList()) : UserDetails, OAuth2User {

    private var attributes: Map<String, Any> = emptyMap()

    companion object{
        fun create(user: User): TravelUserDetails {
            val authorities: List<GrantedAuthority> = Collections.singletonList(SimpleGrantedAuthority("ROLE_USER"))
            return TravelUserDetails(
                    user.id,
                    user.email,
                    user.password,
                    authorities
            )
        }

        fun create(user: User, attributes: Map<String, Any>): TravelUserDetails {
            val userPrincipal: TravelUserDetails = create(user)
            userPrincipal.attributes = attributes
            return userPrincipal
        }
    }

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return grantedAuthorities!!
    }

    override fun getPassword(): String {
        return password!!
    }

    override fun getUsername(): String {
        return username!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getName(): String {
       return id.toString()
    }

    override fun getAttributes(): Map<String, Any> {
       return attributes
    }

}
