package bnr.beatbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bnr.beatbox.databinding.ActivityMainBinding
import bnr.beatbox.databinding.ListItemSoundBinding

private lateinit var beatBox: BeatBox
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        beatBox = BeatBox(assets)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = SoundAdapter(beatBox.sounds)
        }

    }
    private inner class SoundHolder(private val binding: ListItemSoundBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    // 어댑터
    private inner class SoundAdapter(private val sounds:List<Sound>): RecyclerView.Adapter<SoundHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(layoutInflater, R.layout.list_item_sound, parent, false)
            return SoundHolder(binding)
        }
        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
        }
        override fun getItemCount() = sounds.size

    }
}