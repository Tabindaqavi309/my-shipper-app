import com.oldsailor.customerSrv.exception.CustomException
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.filter.OncePerRequestFilter
import java.util.stream.Collectors
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthorizationFilter : OncePerRequestFilter() {
    private val HEADER = "Authorization"
    private val PREFIX = "Bearer "
    private val SECRET = "oldsailorsdbSecretKey"

    @ExceptionHandler(CustomException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        try {
            if (checkJWTToken(request, response)) {
                val claims = validateToken(request)
                println(claims)
                if (claims["authorities"] != null) {
                    setUpSpringAuthentication(claims)
                } else {
                    SecurityContextHolder.clearContext()
                }
            } else {
                SecurityContextHolder.clearContext()
            }
            chain.doFilter(request, response)
        } catch (e: ExpiredJwtException) {
            throw CustomException(e.message)
        } catch (e: UnsupportedJwtException) {
            throw CustomException(e.message)
        } catch (e: MalformedJwtException) {
            throw CustomException(e.message)
        }
    }

    private fun validateToken(request: HttpServletRequest): Claims {
        val jwtToken = request.getHeader(HEADER).replace(PREFIX, "")
        return Jwts.parser().setSigningKey(SECRET.toByteArray()).parseClaimsJws(jwtToken).body
    }

    /**
     * Authentication method in Spring flow
     *
     * @param claims
     */
    private fun setUpSpringAuthentication(claims: Claims) {
        val authorities: List<*>? = claims["authorities"] as List<*>?
        val auth = UsernamePasswordAuthenticationToken(
            claims.subject, null,
            authorities!!.stream().map { role: Any? ->
                SimpleGrantedAuthority(
                    role as String?
                )
            }.collect(Collectors.toList())
        )
        SecurityContextHolder.getContext().authentication = auth
    }

    private fun checkJWTToken(request: HttpServletRequest, res: HttpServletResponse): Boolean {
        val authenticationHeader = request.getHeader(HEADER)
         return !(authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
    }
}