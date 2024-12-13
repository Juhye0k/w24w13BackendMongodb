package kr.ac.kumoh.s20241203.w24w13BackendMongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "songs")
data class Camera(
    @Id val id: String? = null,
    val model: String,
    val brand: String,
    val rating: Int=0,
    val image: String,
    val description: String
)