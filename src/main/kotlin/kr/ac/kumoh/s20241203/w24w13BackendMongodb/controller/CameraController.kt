package kr.ac.kumoh.s20241203.w24w13BackendMongodb.controller

import kr.ac.kumoh.s20241203.w24w13BackendMongodb.model.Camera
import kr.ac.kumoh.s20241203.w24w13BackendMongodb.service.CameraService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = ["https://wsp2024frontend.netlify.app"])
class CameraController(private val service: CameraService) {

    @GetMapping
    fun getRoot() = mapOf("status" to "success")

    //카메라 리스트 전체 조회
    @GetMapping
    fun getAllCamera(): List<Camera> = service.getAllCameras()

    @PostMapping
    fun addCamera(@RequestBody camera:Camera):Camera=service.addCamera(camera)

    @GetMapping("/{model}")
    fun getCameraById(@PathVariable model: String): Camera?= service.getCameraByModel(model)

    @PutMapping("/{id}")
    fun updateCamera(@PathVariable id:String,@RequestBody cameraDetails:Camera):Camera?=service.updateCamera(id,cameraDetails)

    @DeleteMapping("/{id}")
    fun deleteCamera(@PathVariable id:String): Map<String,String>{
        return if(service.deleteCamera(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}


