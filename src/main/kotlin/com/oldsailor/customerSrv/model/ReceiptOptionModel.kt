package com.oldsailor.customerSrv.model

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class ReceiptOptionModel(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "id")
    var id: Long?,
    var type: String?,
    var text: String?,
)