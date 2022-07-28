package com.oldsailor.customerSrv.model;

import javax.persistence.*


@Table(name = "auto_completes")
@Entity
data class AutoCompleteModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var type: String,
    var text: String
)