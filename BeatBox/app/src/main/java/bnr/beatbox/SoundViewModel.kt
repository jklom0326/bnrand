package bnr.beatbox

class SoundViewModel {

    var sound: Sound? = null
    set(sound) {
        field = sound
    }
    val title: String?
        get() = sound?.name
}