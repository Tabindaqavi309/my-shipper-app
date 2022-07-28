package com.oldsailor.customerSrv.model

import java.util.*
import javax.persistence.*

@Table(name = "cars")
@Entity
data class CarModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name="id")
    var id: Long?,
    @Column(unique=true, name="date_added")
    var date_added: Date?,
    @Column(unique=true, name="vin")
    var vin: String,
    var details: String,
    var value_for_aes: String?,
    var container_id: Long,
    var weight: Int?,
    var measurement: Int?,

//    @ManyToOne
//    @JoinColumn(name="container_id", nullable=false, insertable = false, updatable = false)
//    var containerModel: ContainerModel?
)