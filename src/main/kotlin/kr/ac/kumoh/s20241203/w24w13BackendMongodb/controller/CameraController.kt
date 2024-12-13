package kr.ac.kumoh.s20241203.w24w13BackendMongodb.controller

import kr.ac.kumoh.s20241203.w24w13BackendMongodb.model.Camera
import kr.ac.kumoh.s20241203.w24w13BackendMongodb.service.CameraService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = ["http://localhost:3000"])
class CameraController(private val service: CameraService) {

    @PostMapping
    fun addCamera(@RequestBody camera:Camera):Camera=service.addSong(camera)

    @GetMapping
    fun getAllCamera(): List<Camera> = service.getAllSongs()

    @GetMapping("/{id}")
    fun getCameraById(@PathVariable id: String): Camera?= service.getSongById(id)

    @GetMapping("/model/{model}")
    fun getCameraByModel(@PathVariable model:String): List<Camera> = service.getSongBySinger(model)

    @PutMapping("/{id}")
    fun updateCamera(@PathVariable id:String,@RequestBody cameraDetails:Camera):Camera?=service.updateSong(id,cameraDetails)

    @DeleteMapping("/{id}")
    fun deleteCamera(@PathVariable id:String): Map<String,String>{
        return if(service.deleteSong(id))
            mapOf("status" to "deleted")
        else
            mapOf("status" to "not found")
    }
}