package com.oldsailor.customerSrv

import JWTAuthorizationFilter
import com.oldsailor.customerSrv.exception.CustomException
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.util.*


@EnableWebSecurity
@Configuration
class BasicAuthSecurity : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("password")
            .roles("USER")
    }

    @ExceptionHandler(CustomException::class)
    override fun configure(http: HttpSecurity) {
        http.cors().configurationSource(corsConfigurationSource());

        http.csrf().disable()
            .addFilterAfter(JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
            .authorizeRequests()
            .anyRequest().authenticated()


    }

    fun corsConfigurationSource(): CorsConfigurationSource? {
        val configuration = CorsConfiguration()
        val allowOrigins: List<String> = listOf("https://shipping-frontend-app.herokuapp.com", "http://localhost:3000")
        configuration.allowedOrigins = allowOrigins
        configuration.allowedMethods = listOf("*")
        configuration.allowedHeaders = listOf("*")
        //in case authentication is enabled this flag MUST be set, otherwise CORS requests will fail
        configuration.allowCredentials = false
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }


//    @Configuration
//    class WebConfiguration : WebMvcConfigurer {
//        override fun addCorsMappings(registry: CorsRegistry) {
//            registry
//                .addMapping("http://www.oldsailor-prod.xyz")
//                .allowedMethods("POST, PUT, DELETE, GET")
//                .allowedHeaders("Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization")
//                .allowedOrigins("http://www.oldsailor-prod.xyz")
//                .allowCredentials(true)
//        }
//    }


}



