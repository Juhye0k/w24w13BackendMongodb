package kr.ac.kumoh.s20241203.w24w13BackendMongodb.repository

import kr.ac.kumoh.s20241203.w24w13BackendMongodb.model.Camera
import org.springframework.data.mongodb.repository.MongoRepository

interface CameraRepository : MongoRepository<Camera,String> {

    fun findByModelContainingIgnoreCase(model:String):Camera
}