package kr.ac.kumoh.s20241203.w24w13BackendMongodb.service

import kr.ac.kumoh.s20241203.w24w13BackendMongodb.model.Camera
import kr.ac.kumoh.s20241203.w24w13BackendMongodb.repository.CameraRepository
import org.springframework.stereotype.Service

@Service
class CameraService(private val repository: CameraRepository) {

    fun addSong(camera: Camera):Camera=repository.save(camera)
    fun getAllSongs(): List<Camera> = repository.findAll()
    fun getSongById(id: String): Camera?= repository.findById(id).orElse(null)
    fun getSongBySinger(model:String): List<Camera> = repository.findByModel(model)

    fun updateSong(id: String, camera: Camera): Camera? {
        val songTarget = repository.findById(id)

        return if (songTarget.isPresent) {
            val oldSong = songTarget.get()
            val updatedSong = oldSong.copy(
                model = camera.model,
                brand = camera.brand,
                rating = camera.rating,
                description = camera.description
            )
            repository.save(updatedSong)
        } else {
            null
        }
    }

    fun deleteSong(id: String): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }

}
