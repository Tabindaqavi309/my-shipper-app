package com.oldsailor.customerSrv.controller

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.AutoCompleteModel
import com.oldsailor.customerSrv.model.POANRAModel
import com.oldsailor.customerSrv.service.POANRAService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/receipt-srv")
class POANRAController {
    @Autowired
    lateinit var poaNraService: POANRAService

    @GetMapping("/poa_nra")
    @ResponseStatus(HttpStatus.OK)
    fun index(@RequestParam offset: String, @RequestParam limit: String): JSONObject {
        return poaNraService.find(offset.toInt(), limit.toInt())
    }

    @PostMapping("/poa_nra/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody body: POANRAModel): POANRAModel {
        try {
            return poaNraService.insert(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @GetMapping("/receipt_auto_complete")
    @ResponseStatus(HttpStatus.CREATED)
    fun findAutoComplete(): List<AutoCompleteModel> {
        try {
            return poaNraService.findAutoComplete()
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @PostMapping("/receipt_auto_complete/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun insertAutoComplete(@RequestBody body: AutoCompleteModel): AutoCompleteModel {
        try {
            return poaNraService.insertAutoComplete(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @PutMapping("/poa_nra/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @RequestBody body: POANRAModel,
    ) {
        poaNraService.update(body)
    }

    @DeleteMapping("/poa_nra/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) {
        try {
            poaNraService.delete(id)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @GetMapping("/poa_nra/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findDataById(@PathVariable id: Long) = poaNraService.findDataById(id)


    @PostMapping("/poa_nra/full-text-search")
    fun fullTextSearch(@RequestBody req: SearchObj): JSONObject {
        try {
            return  poaNraService.fullTextSearch(req.value)
        } catch (e: java.lang.Exception) {
            throw CustomException(e.message)
        }
    }
}

