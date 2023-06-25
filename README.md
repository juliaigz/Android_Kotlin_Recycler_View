# Android_Kotlin_Recycler_View
### This is a project made in Android Studio, using kotlin, to create a Recycler View. 

Step 1 : Create the activity_main.xml
![image](https://github.com/juliaigz/Android_Kotlin_Recycler_View/assets/40221707/c63d85fe-83f1-488e-b18b-5c5af7d0a40f)

Step 2 : Create the item_layout.xml
![image](https://github.com/juliaigz/Android_Kotlin_Recycler_View/assets/40221707/468d7740-93c9-4d24-85f1-976fa7729581)

Step 3 : Create  AdapterRecyclerView.kt
![image](https://github.com/juliaigz/Android_Kotlin_Recycler_View/assets/40221707/e49e4ae4-1032-4b20-9d4b-d0f2b9edeab5)

Step 4 : Create MainActivity.kt
![image](https://github.com/juliaigz/Android_Kotlin_Recycler_View/assets/40221707/be52a46f-fce2-4ed3-8e98-d9a985b670b6)


### activity_main.xml

´´´ bash

<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="38dp"
            android:background="@drawable/fondo"
            android:gravity="center"
            android:text="KotlinRecyclerView"
            android:textColor="#FBFBFB"
            android:textSize="20sp" />

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/reciclerView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="1dp" />
    </LinearLayout>

</FrameLayout>

´´´


### item_layout.xml

´´´ bash

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <LinearLayout
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:gravity="left"
        android:padding="8dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="83dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            app:srcCompat="@drawable/twotone_archive_24" />

        <TextView
            android:id="@+id/nombreTextView"
            android:layout_width="300dp"
            android:layout_height="wrap_content"
            android:text="item"
            android:textColor="@android:color/black"
            android:textSize="16sp" />

    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>

´´´




### AdapterRecyclerView.kt

´´´ bash

data class TuModeloDeDatos(val items: String)

//el daptador donde le entregamos la lista y la funcion de estructura
class AdapterRecyclerView(private val datos: List<TuModeloDeDatos>) : RecyclerView.Adapter<AdapterRecyclerView.TuViewHolder>() {

    //funcion donde se pesca el layout estructural
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return TuViewHolder(view)
    }

    //para cargar la estructura la cantidad de veces necesarias segun ellargo de la lista entregada de datos
    override fun onBindViewHolder(holder: TuViewHolder, position: Int) {
        val item = datos[position]
        holder.bind(item)
    }
    //contador de datos entregados
    override fun getItemCount(): Int {
        return datos.size
    }

    //adaptador de la estructura a los datos entregados
    inner class TuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemTextView: TextView=itemView.findViewById(R.id.nombreTextView)
        fun bind(item: TuModeloDeDatos) {
            itemTextView.text=item.items
        }
    }
}

´´´



### MainActivity.kt

´´´ bash 

class MainActivity : AppCompatActivity() {
    val tusDatos: MutableList<TuModeloDeDatos> = mutableListOf()
    val elementos= listOf(
        TuModeloDeDatos("Item1"),
                TuModeloDeDatos("Item2"),
                TuModeloDeDatos("Item3"),
                TuModeloDeDatos("Item4"),
                TuModeloDeDatos("Item5"),
                TuModeloDeDatos("Item6"),
                TuModeloDeDatos("Item7"),
                TuModeloDeDatos("Item8"),
                TuModeloDeDatos("Item9"),
                TuModeloDeDatos("Item10"),
                TuModeloDeDatos("Item11")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tusDatos.addAll(elementos)

        val recyclerView: RecyclerView = findViewById(R.id.reciclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) // Puedes usar otras opciones como GridLayoutManager o StaggeredGridLayoutManager
        val adapter = AdapterRecyclerView(tusDatos) // Crea tu propio adaptador personalizado
        recyclerView.adapter = adapter
    }
}

´´´








