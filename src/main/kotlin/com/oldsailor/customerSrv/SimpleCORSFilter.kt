//package com.oldsailor.customerSrv
//
//import org.slf4j.LoggerFactory
//import org.springframework.stereotype.Component
//import java.io.IOException
//import javax.servlet.*
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
//
//@Component
//class SimpleCORSFilter : Filter {
//    private val log = LoggerFactory.getLogger(SimpleCORSFilter::class.java)
//
//    @Throws(IOException::class, ServletException::class)
//    override fun doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain) {
//        val request = req as HttpServletRequest
//        val response = res as HttpServletResponse
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"))
//        response.setHeader("Access-Control-Allow-Credentials", "true")
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT")
//        response.setHeader("Access-Control-Max-Age", "3600")
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization")
//        chain.doFilter(req, res)
//    }
//
//    override fun init(filterConfig: FilterConfig) {}
//    override fun destroy() {}
//
//    init {
//        log.info("SimpleCORSFilter init")
//    }
//}