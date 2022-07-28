package com.oldsailor.customerSrv

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomerSrvApplication

fun main(args: Array<String>) {
	runApplication<CustomerSrvApplication>(*args)
}
