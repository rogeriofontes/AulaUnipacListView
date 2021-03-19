package br.com.unipac.exemplolistview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.news_item.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    var listNews = ArrayList<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newsLv = findViewById<ListView>(R.id.listNews)

        var news1 = News(1, "A hacker's guide to numerical analysis", "Life may toss us ill-conditioned problems, but it is too short to settle for unstable algorithms")
        listNews.add(news1)
        var news2 = News(2, "Data Science in Julia for Hackers", "We have a habit in writing articles published in scientific journals to make the work as finished as possible, to cover up all the tracks, to not worry about the blind alleys or describe how you had the wrong idea first, and so on - Richard Feynman")
        listNews.add(news2)
        var news3 = News(3, "Introducing the Python package cache", "Figuring out how to install third-party libraries can derail people from learning to code or starting a new side project.")
        listNews.add(news3)
        var news4 = News(4, "Introducing the Python package cache1", "Figuring out how to install third-party libraries can derail people from learning to code or starting a new side project.")
        listNews.add(news4)
        var news5 = News(5, "Introducing the Python package cache2", "Figuring out how to install third-party libraries can derail people from learning to code or starting a new side project.")
        listNews.add(news5)
        var news6 = News(6, "Introducing the Python package cache3", "Figuring out how to install third-party libraries can derail people from learning to code or starting a new side project.")
        listNews.add(news6)
        var news7 = News(7, "Introducing the Python package cache4", "Figuring out how to install third-party libraries can derail people from learning to code or starting a new side project.")
        listNews.add(news7)
        var news8 = News(8, "Introducing the Python package cache5", "Figuring out how to install third-party libraries can derail people from learning to code or starting a new side project.")
        listNews.add(news8)

        var newsAdapter = NewsAdapter(this@MainActivity, listNews)
        newsLv.adapter = newsAdapter

        newsLv.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, position, id ->
            Toast.makeText(this@MainActivity, "Cliquei no ${listNews[position].title}", Toast.LENGTH_LONG).show()
        }
    }

    inner class NewsAdapter : BaseAdapter {
        var listNews = ArrayList<News>()
        var contex: Context? = null

        constructor(contex: Context?, listNews: ArrayList<News>) : super() {
            this.listNews = listNews
            this.contex = contex
        }

        override fun getCount(): Int {
            return listNews.size
        }

        override fun getItem(position: Int): Any {
            return listNews[position]
        }

        override fun getItemId(position: Int): Long {
            return listNews[position].id!!.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var view: View? = null
            val viewHolder: ViewHolder

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.news_item, parent, false)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            } else {
                view = convertView
                viewHolder = view.tag as ViewHolder
            }

            viewHolder.tvTitle.text = listNews[position].title
            viewHolder.vContent.text = listNews[position].content
            return view
        }
    }

    private class ViewHolder(view: View?) {
        val tvTitle: TextView
        val vContent: TextView

        init {
            this.tvTitle = view?.findViewById(R.id.tvTitle) as TextView
            this.vContent = view?.findViewById(R.id.tvContent) as TextView
        }
    }
}