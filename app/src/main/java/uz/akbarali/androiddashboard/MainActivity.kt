package uz.akbarali.androiddashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.androiddashboard.R
import uz.akbarali.adapter.MoviesAdapter
import com.example.androiddashboard.databinding.ActivityMainBinding
import uz.akbarali.models.Movie
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupMoviesViewPager()
    }

    private fun setupMoviesViewPager() {
        binding.apply {
            moviesViewPager.clipToPadding = false
            moviesViewPager.clipChildren = false
            moviesViewPager.offscreenPageLimit = 3
            moviesViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(10))
            compositePageTransformer.addTransformer { page, position ->
                val r: Float = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
            moviesViewPager.setPageTransformer(compositePageTransformer)
            moviesViewPager.adapter = MoviesAdapter(getMovies())
        }
    }

    private fun getMovies(): ArrayList<Movie> {
        val list = ArrayList<Movie>()

        val thor = Movie()
        thor.poster = R.drawable.dark_world
        thor.name = "Thor Odinson"
        thor.category = "Science Fiction"
        thor.releaseDate = "December 26, 2011"
        thor.rating = 4.9f
        list.add(thor)
        val deepwater = Movie()
        deepwater.poster = R.drawable.deepwater
        deepwater.name = "Deepwater Horizon"
        deepwater.category = "Science Fiction"
        deepwater.releaseDate = "June 10, 2016"
        deepwater.rating = 4.7f
        list.add(deepwater)
        val movie = Movie()
        movie.rating = 4.6f
        movie.releaseDate = "January 15, 2016"
        movie.category = "Science Fiction"
        movie.poster = R.drawable.wove
        movie.name = "The 5th Wave"
        list.add(movie)
        val movie1 = Movie()
        movie1.poster = R.drawable.movie2
        movie1.rating = 3.6f
        movie1.releaseDate = "January 21, 2019"
        movie1.category = "Science Fiction"
        movie1.name = "Journey 2"
        list.add(movie1)
        val movie2 = Movie()
        movie2.poster = R.drawable.avatar
        movie2.rating = 4.2f
        movie2.releaseDate = "January 21, 2009"
        movie2.category = "Science Fiction"
        movie2.name = "Avatar"
        list.add(movie2)
        val movie3 = Movie()
        movie3.poster = R.drawable.pantera
        movie3.rating = 3.2f
        movie3.releaseDate = "February 16, 2018"
        movie3.category = "Science Fiction"
        movie3.name = "BLACK PANTHER"
        list.add(movie3)
        return list
    }
}