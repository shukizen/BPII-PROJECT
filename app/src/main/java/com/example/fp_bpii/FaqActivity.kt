import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bpii.FaqItem
import com.example.fp_bpii.R

class FaqActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFaq)

        // Contoh data FAQ
        val faqList = listOf(
            FaqItem("Apa itu Android?", "Android adalah sistem operasi berbasis Linux."),
            FaqItem("Apa itu RecyclerView?", "RecyclerView adalah komponen UI untuk menampilkan daftar data."),
            FaqItem("Bagaimana cara membuat aplikasi Android?", "Gunakan Android Studio dan bahasa seperti Kotlin atau Java.")
        )

        val adapter = FaqAdapter(faqList)
        recyclerView.adapter = adapter
    }
}
