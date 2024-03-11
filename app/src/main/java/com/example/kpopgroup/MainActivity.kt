package com.example.kpopgroup

import KpopGroupAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), KpopGroupAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: KpopGroupAdapter
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menginisialisasi data
        val kpopGroups = listOf(
            KpopGroup("AESPA", "-","MY", R.drawable.aespa_profile, "Aespa (에스파), stylized as æspa, is a four-member South Korean girl group under SM Entertainment. The group consists of Karina, Giselle, Winter, and NingNing. They debuted on November 17, 2020, with the digital single, Black Mamba. On June 2, 2022, it has been announced that aespa has signed with Warner Records for global promotions."),
            KpopGroup("BOYNEXTDOOR", "-", "ONEDOOR", R.drawable.bnd_profile, "BOYNEXTDOOR (보이넥스트도어) (can be shorten as BND) is a South Korean boy group under KOZ Entertainment who debuted on May 30th, 2023 with the single album “WHO!“. The members are Jaehyun, Sungho, Riwoo, Taesan, Leehan, and Woonhak."),
            KpopGroup("IVE", "I HAVE", "DIVE", R.drawable.ive_profile, "IVE (아이브) is a 6-member South Korean girl group under STARSHIP Entertainment. The group consists of An Yujin, Gaeul, Rei, Jang Wonyoung, Liz, and Leeseo. They debuted on December 1st, 2021 with the single album ‘Eleven‘. The group made their Japanese debut on October 19th, 2022. They made their English debut on January 19th, 2024 with the single, ‘All Night (feat. Saweetie)‘, a remake of Icona Pop’s ‘All Night‘."),
            KpopGroup("KISS OF LIFE", "-","KISSY",  R.drawable.kiof_profile, "KISS OF LIFE (키스 오브 라이프; KIOF) is a four-member South Korean girl group under S2 Entertainment. The members consist of Julie, Natty, Belle, and Haneul. They had their debut on July 5, 2023, with their first mini album, KISS OF LIFE."),
            KpopGroup("LE SSERAFIM", "-","FEARNOT", R.drawable.lesserafim_profile, "LE SSERAFIM (르세라핌) is a 5-member girl group under HYBE and Source Music. The members currently consist of Kim Chaewon, Sakura, Huh Yunjin, Kazuha, and Hong Eunchae. LE SSERAFIM officially debuted on May 2, 2022 with their 1st mini album “FEARLESS”. On July 19, 2022, it was announced that Kim Garam had left the group."),
            KpopGroup("NewJeans", "-","Bunnies", R.drawable.newjeans_profile, "NewJeans (뉴진스) is a 5-member girl group under ADOR and HYBE Labels. The members consist of Minji, Hanni, Danielle, Haerin, and Hyein. They released their debut single “Attention” on July 22, 2022, followed by their debut extended play, New Jeans, which was released on August 1, 2022."),
            KpopGroup("PSYCHIC FEVER from EXILE TRIBE", "-", "ForEVER", R.drawable.psychic_profile, "PSYCHIC FEVER from EXILE TRIBE is a 7 member Japanese boy group under the label LDH & signed to Rhythm Zone. The group currently consists of: TSURUGI, RYOGA, REN, JIMMY, KOKORO, RYUSHIN, & WEESA. The group was formed in 2019 and made their official debut on July 13th, 2022 with the album “P.C.F“. Their debut MV “Chosen One” was released on June 27th, 2022."),
            KpopGroup("SEVENTEEN", "-", "CARAT", R.drawable.seventen_profile, "SEVENTEEN (세븐틴) is a self-produced Kpop boy group that consists of 13 members: S.coups, Wonwoo, Mingyu, Vernon (the hip-hop unit); Woozi, Jeonghan, Joshua, DK, Seungkwan (the vocal unit); Hoshi, Jun, The8, Dino (the performance unit). SEVENTEEN debuted on May 26, 2015, with the mini album “17 Carat” under PLEDIS Entertainment.\n" + "As of May 25, 2020 Big Hit Entertainment (now known as HYBE Labels) became PLEDIS’ major shareholder, but PLEDIS will continue to act as an independent label."),
            KpopGroup("TWS", "TWENTY FOUR SEVEN WITH US", "-", R.drawable.tws_profile, "TWS (투어스) is a 6 member boy group under PLEDIS Entertainment. The 6 members are Shinyu, Dohoon, Youngjae, Hanjin, Jihoon, and Kyungmin. They released a pre-release single on January 2nd, 2024. They made their debut on January 22nd, 2024 with the mini album, ‘Sparkling Blue‘. Geffen Records and Virgin Music will be handling the group’s global activities as of February 2024."),
            KpopGroup("XG", "Xtraordinary Girls", "ALPHAZ", R.drawable.xg_profile, "XG is a hip-hop/R&B-inspired girl group comprised of 7 members: JURIN, CHISA, HARVEY, HINATA, JURIA, MAYA, and COCONA.\n" + "\n" + "They debuted in March 2022 with their first single ‘TIPPY TOES’ under the global entertainment production company XGALX, which promotes a bold culture and produces artist groups with unique worldviews."),
        )

        adapter = KpopGroupAdapter(kpopGroups, this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        // Mengambil data dari adapter berdasarkan posisi item yang diklik
        val clickedItem = adapter.getItemAtPosition(position)

        // Membuat intent untuk memulai DescriptionActivity
        val intent = Intent(this, DescriptionActivity::class.java)
        intent.putExtra("groupName", clickedItem.name)
        intent.putExtra("groupFullName", clickedItem.fullName)
        intent.putExtra("groupFandom", clickedItem.fandomName)
        intent.putExtra("groupImageResId", clickedItem.imageResId)
        intent.putExtra("groupDescription", clickedItem.description)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                // Menampilkan halaman AboutActivity
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
